package com.example.fabricordersserver.service;

import com.example.fabricordersserver.dto.LoginRequestDto;
import com.example.fabricordersserver.dto.PasswordChangeRequestDto;
import com.example.fabricordersserver.dto.SignupRequestDto;

import com.example.fabricordersserver.entity.User;

import com.example.fabricordersserver.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // =========================
    // 유저 Repository
    // =========================
    private final UserRepository
            userRepository;

    // =========================
    // 비밀번호 암호화
    // =========================
    private final BCryptPasswordEncoder
            passwordEncoder;

    // =========================
    // 이메일 인증
    // =========================
    private final EmailVerificationService
            emailVerificationService;

    // =========================
    // 생성자 주입
    // =========================
    public AuthService(

            UserRepository userRepository,

            BCryptPasswordEncoder passwordEncoder,

            EmailVerificationService
                    emailVerificationService
    ) {

        this.userRepository
                = userRepository;

        this.passwordEncoder
                = passwordEncoder;

        this.emailVerificationService
                = emailVerificationService;
    }

    // =========================
    // 아이디 중복 확인
    // =========================
    public boolean checkDuplicateId(

            String loginId
    ){

        return userRepository
                .existsByLoginId(loginId);
    }

    // =========================
    // 회원가입
    // =========================
    public String signup(

            SignupRequestDto dto
    ) {

        // 아이디 중복
        if (

            userRepository.existsByLoginId(
                    dto.getLoginId()
            )

        ) {

            return "DUPLICATE_ID";
        }

        // 이메일 중복
        if (

            userRepository.existsByEmail(
                    dto.getEmail()
            )

        ) {

            return "DUPLICATE_EMAIL";
        }

        // 이메일 인증 확인
        if (

            !emailVerificationService
                    .isVerified(
                            dto.getEmail()
                    )

        ) {

            return "EMAIL_NOT_VERIFIED";
        }

        // 비밀번호 암호화
        String encodedPassword =

                passwordEncoder.encode(
                        dto.getPassword()
                );

        // 유저 생성
        User user = new User(

                dto.getLoginId(),

                encodedPassword,

                dto.getName(),

                dto.getEmail(),

                dto.getPhone()
        );

        // 저장
        userRepository.save(user);

        return "SUCCESS";
    }

    // =========================
    // 로그인
    // =========================
    public User login(

            LoginRequestDto dto
    ) {

        User user = userRepository

                .findByLoginId(
                        dto.getId()
                )

                .orElse(null);

        // 유저 없음
        if (user == null) {

            return null;
        }

        // 비밀번호 불일치
        if (

            !passwordEncoder.matches(

                    dto.getPassword(),

                    user.getPassword()
            )

        ) {

            return null;
        }

        return user;
    }

    // =========================
    // 비밀번호 재설정
    // =========================
    public String resetPassword(

            PasswordChangeRequestDto dto
    ){

        // =========================
        // 유저 조회
        // =========================
        User user = userRepository

                .findByLoginId(
                        dto.getLoginId()
                )

                .orElse(null);

        // 유저 없음
        if(user == null){

            return "USER_NOT_FOUND";
        }

        // =========================
        // 이메일 불일치
        // =========================
        if(

            !user.getEmail()
                    .equals(dto.getEmail())

        ){

            return "EMAIL_NOT_MATCH";
        }

        // =========================
        // 이메일 인증 확인
        // =========================
        if(

            !emailVerificationService
                    .isVerified(
                            dto.getEmail()
                    )

        ){

            return "EMAIL_NOT_VERIFIED";
        }

        // =========================
        // 새 비밀번호 암호화
        // =========================
        String encodedPassword =

                passwordEncoder.encode(

                        dto.getNewPassword()
                );

        // =========================
        // 비밀번호 변경
        // =========================
        user.setPassword(
                encodedPassword
        );

        // =========================
        // 저장
        // =========================
        userRepository.save(user);

        return "SUCCESS";
    }
}