package com.example.fabricordersserver.service;

import com.example.fabricordersserver.entity.EmailVerification;

import com.example.fabricordersserver.repository.EmailVerificationRepository;

import com.example.fabricordersserver.repository.UserRepository;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailVerificationService {

    // =========================
    // 이메일 인증 DB 접근
    // =========================
    private final EmailVerificationRepository
            emailVerificationRepository;

    // =========================
    // 유저 DB 접근
    // =========================
    private final UserRepository userRepository;

    // =========================
    // Gmail SMTP
    // =========================
    private final JavaMailSender gmailSender;

    // =========================
    // 네이버 SMTP
    // =========================
    private final JavaMailSender naverSender;

    // =========================
    // 생성자 주입
    // =========================
    public EmailVerificationService(

            EmailVerificationRepository
                    emailVerificationRepository,

            UserRepository userRepository,

            @Qualifier("gmailSender")
            JavaMailSender gmailSender,

            @Qualifier("naverSender")
            JavaMailSender naverSender
    ) {

        this.emailVerificationRepository
                = emailVerificationRepository;

        this.userRepository
                = userRepository;

        this.gmailSender
                = gmailSender;

        this.naverSender
                = naverSender;
    }

    // =========================
    // 회원가입 인증번호 발송
    // =========================
    public String sendCode(String email){

        // =========================
        // 이메일 형식 검사
        // =========================
        if(

            !email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
            )

        ){

            throw new RuntimeException(
                    "INVALID_EMAIL"
            );
        }

        // =========================
        // 이미 가입된 이메일 검사
        // =========================
        if(

            userRepository.existsByEmail(email)

        ){

            throw new RuntimeException(
                    "DUPLICATE_EMAIL"
            );
        }

        // =========================
        // 인증번호 생성
        // =========================
        String code = createCode();

        // =========================
        // 인증 DB 저장
        // =========================
        saveVerification(email, code);

        // =========================
        // 메일 발송
        // =========================
        sendMail(

                email,

                "[Fabric Orders] 이메일 인증번호",

                "인증번호는 ["
                        + code
                        + "] 입니다."
        );

        return code;
    }

    // =========================
    // 비밀번호 찾기 인증번호 발송
    // =========================
    public String sendCodeForPasswordReset(

            String loginId,

            String email
    ){

        // =========================
        // 아이디 + 이메일 확인
        // =========================
        boolean exists =

                userRepository
                        .existsByLoginIdAndEmail(

                                loginId,

                                email
                        );

        if(!exists){

            throw new RuntimeException(
                    "USER_NOT_FOUND"
            );
        }

        // =========================
        // 인증번호 생성
        // =========================
        String code = createCode();

        // =========================
        // 인증 DB 저장
        // =========================
        saveVerification(email, code);

        // =========================
        // 메일 발송
        // =========================
        sendMail(

                email,

                "[Fabric Orders] 비밀번호 재설정 인증번호",

                "비밀번호 재설정 인증번호는 ["

                        + code +

                        "] 입니다."
        );

        return "SUCCESS";
    }

    // =========================
    // 인증번호 생성
    // =========================
    private String createCode(){

        return String.valueOf(

                100000
                +
                new Random().nextInt(900000)
        );
    }

    // =========================
    // 인증 DB 저장
    // =========================
    private void saveVerification(

            String email,

            String code
    ){

        EmailVerification verification

                = new EmailVerification(
                        email,
                        code
        );

        emailVerificationRepository
                .save(verification);
    }

    // =========================
    // 메일 발송 공통
    // =========================
    private void sendMail(

            String email,

            String subject,

            String text
    ){

        // =========================
        // 메일 객체 생성
        // =========================
        SimpleMailMessage message
                = new SimpleMailMessage();

        // 받는 사람
        message.setTo(email);

        // 제목
        message.setSubject(subject);

        // 내용
        message.setText(text);

        // =========================
        // 네이버 메일 발송
        // =========================
        if(email.contains("@naver.com")){

            message.setFrom(
                    "tom3017@naver.com"
            );

            message.setReplyTo(
                    "tom3017@naver.com"
            );

            try{

                naverSender.send(message);

            }catch (Exception e){

                throw new RuntimeException(
                        "EMAIL_SEND_FAIL"
                );
            }

        } else {

            // =========================
            // Gmail 메일 발송
            // =========================
            message.setFrom(
                    "jungmin940324@gmail.com"
            );

            message.setReplyTo(
                    "jungmin940324@gmail.com"
            );

            try{

                gmailSender.send(message);

            }catch (Exception e){

                throw new RuntimeException(
                        "EMAIL_SEND_FAIL"
                );
            }
        }
    }

    // =========================
    // 인증번호 검증
    // =========================
    public boolean verifyCode(

            String email,

            String code
    ){

        // 최근 인증번호 조회
        EmailVerification verification

                = emailVerificationRepository

                .findTopByEmailOrderByIdDesc(
                        email
                )

                .orElse(null);

        // 인증 데이터 없음
        if(verification == null){

            return false;
        }

        // 인증번호 불일치
        if(

            !verification.getCode()
                    .equals(code)

        ){

            return false;
        }

        // 인증 완료 처리
        verification.setVerified(true);

        // DB 저장
        emailVerificationRepository
                .save(verification);

        return true;
    }

    // =========================
    // 이메일 인증 여부 확인
    // =========================
    public boolean isVerified(String email){

        // 최근 인증 데이터 조회
        EmailVerification verification

                = emailVerificationRepository

                .findTopByEmailOrderByIdDesc(
                        email
                )

                .orElse(null);

        // 데이터 없음
        if(verification == null){

            return false;
        }

        // 인증 여부 반환
        return verification.isVerified();
    }
}