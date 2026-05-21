package com.example.fabricordersserver.service;

import com.example.fabricordersserver.dto.PasswordChangeRequestDto;

import com.example.fabricordersserver.dto.UserSettingResponseDto;

import com.example.fabricordersserver.dto.UserSettingUpdateRequestDto;

import com.example.fabricordersserver.entity.User;

import com.example.fabricordersserver.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class UserSettingService {

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
    // 생성자 주입
    // =========================
    public UserSettingService(

            UserRepository userRepository,

            BCryptPasswordEncoder passwordEncoder

    ) {

        this.userRepository
                = userRepository;

        this.passwordEncoder
                = passwordEncoder;
    }

    // =========================
    // 내 정보 조회
    // =========================
    public UserSettingResponseDto getMySetting(

            String loginId

    ) {

        User user = userRepository

                .findByLoginId(loginId)

                .orElseThrow();

        return new UserSettingResponseDto(

                user.getName(),

                user.getEmail(),

                user.getPhone(),

                user.getProfileImage(),

                user.isKakaoNotification()
        );
    }

    // =========================
    // 내 정보 수정
    // =========================
    public String updateMySetting(

            String loginId,

            UserSettingUpdateRequestDto dto

    ) {

        User user = userRepository

                .findByLoginId(loginId)

                .orElseThrow();

        // 이름
        user.setName(dto.getName());

        // 이메일
        user.setEmail(dto.getEmail());

        // 전화번호
        user.setPhone(dto.getPhone());

        // 카카오 알림
        user.setKakaoNotification(
                dto.isKakaoNotification()
        );

        // 저장
        userRepository.save(user);

        return "SUCCESS";
    }

    // =========================
    // 로그인 상태 비밀번호 변경
    // =========================
    public String changePassword(

            String loginId,

            PasswordChangeRequestDto dto

    ) {

        // 유저 조회
        User user = userRepository

                .findByLoginId(loginId)

                .orElseThrow();

        // 새 비밀번호 암호화
        String encodedPassword =

                passwordEncoder.encode(
                        dto.getNewPassword()
                );

        // 비밀번호 변경
        user.setPassword(
                encodedPassword
        );

        // 저장
        userRepository.save(user);

        return "SUCCESS";
    }
}