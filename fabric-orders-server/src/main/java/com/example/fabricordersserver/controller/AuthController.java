package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.dto.*;

import com.example.fabricordersserver.entity.User;

import com.example.fabricordersserver.service.AuthService;

import com.example.fabricordersserver.service.EmailVerificationService;

import com.example.fabricordersserver.service.JwtService;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/auth")
public class AuthController {

    // =========================
    // 회원 인증 서비스
    // =========================
    private final AuthService authService;

    // =========================
    // 이메일 인증 서비스
    // =========================
    private final EmailVerificationService
            emailVerificationService;

    // =========================
    // JWT 서비스
    // =========================
    private final JwtService jwtService;

    // =========================
    // 생성자 주입
    // =========================
    public AuthController(

            AuthService authService,

            EmailVerificationService
                    emailVerificationService,

            JwtService jwtService
    ) {

        this.authService = authService;

        this.emailVerificationService
                = emailVerificationService;

        this.jwtService = jwtService;
    }

    // =========================
    // 서버 연결 테스트
    // =========================
    @GetMapping("/test")
    public String test() {

        return "서버 연결 성공";
    }

    // =========================
    // 아이디 중복확인
    // =========================
    @GetMapping("/check-id")
    public String checkId(

            @RequestParam String loginId
    ){

        // 아이디 존재 여부 확인
        boolean exists

                = authService
                .checkDuplicateId(loginId);

        // 이미 존재
        if(exists){

            return "DUPLICATE";
        }

        // 사용 가능
        return "AVAILABLE";
    }

    // =========================
    // 이메일 인증번호 발송
    // 회원가입용
    // =========================
    @PostMapping("/email/send")
    public String sendEmailCode(

            @RequestBody
            EmailSendRequestDto dto
    ) {

        emailVerificationService
                .sendCode(dto.getEmail());

        return "SEND_SUCCESS";
    }

    // =========================
    // 이메일 인증번호 확인
    // =========================
    @PostMapping("/email/verify")
    public String verifyEmailCode(

            @RequestBody
            EmailVerifyRequestDto dto
    ) {

        boolean result

                = emailVerificationService
                .verifyCode(

                        dto.getEmail(),

                        dto.getCode()
                );

        // 인증 성공
        if (result) {

            return "VERIFY_SUCCESS";
        }

        // 인증 실패
        return "VERIFY_FAIL";
    }

    // =========================
    // 회원가입
    // =========================
    @PostMapping("/signup")
    public String signup(

            @RequestBody
            SignupRequestDto dto
    ) {

        return authService.signup(dto);
    }

    // =========================
    // 로그인
    // =========================
    @PostMapping("/login")
    public LoginResponseDto login(

            @RequestBody
            LoginRequestDto dto
    ) {

        // 로그인
        User user = authService.login(dto);

        // 실패
        if (user == null) {

            return new LoginResponseDto(

                    "FAIL",

                    null,

                    null
            );
        }

        // JWT 생성
        String token = jwtService.createToken(

                user.getLoginId(),

                user.getName()
        );

        // 성공
        return new LoginResponseDto(

                "SUCCESS",

                user.getName(),

                token
        );
    }

    // =========================
    // 비밀번호 찾기
    // 인증번호 발송
    // =========================
    @PostMapping("/find-password/send-code")
    public String sendResetCode(

            @RequestBody
            PasswordChangeRequestDto dto
    ){

        try {

            // 아이디 + 이메일 확인 후 발송
            emailVerificationService
                    .sendCodeForPasswordReset(

                            dto.getLoginId(),

                            dto.getEmail()
                    );

            return "SEND_SUCCESS";

        } catch (Exception e){

            return e.getMessage();
        }
    }

    // =========================
    // 비밀번호 찾기
    // 인증번호 검증
    // =========================
    @PostMapping("/find-password/verify")
    public String verifyResetCode(

            @RequestBody
            EmailVerifyRequestDto dto
    ){

        boolean result =

                emailVerificationService
                        .verifyCode(

                                dto.getEmail(),

                                dto.getCode()
                        );

        // 인증 성공
        if(result){

            return "VERIFY_SUCCESS";
        }

        // 인증 실패
        return "VERIFY_FAIL";
    }

    // =========================
    // 비밀번호 재설정
    // =========================
    @PostMapping("/find-password/reset")
    public String resetPassword(

            @RequestBody
            PasswordChangeRequestDto dto
    ){

        return authService
                .resetPassword(dto);
    }
}