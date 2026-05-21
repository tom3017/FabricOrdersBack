package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.dto.PasswordChangeRequestDto;
import com.example.fabricordersserver.dto.UserSettingResponseDto;
import com.example.fabricordersserver.dto.UserSettingUpdateRequestDto;

import com.example.fabricordersserver.service.JwtService;
import com.example.fabricordersserver.service.UserSettingService;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")

@RestController

@RequestMapping("/settings")
public class UserSettingController {

    private final UserSettingService userSettingService;

    private final JwtService jwtService;

    public UserSettingController(

            UserSettingService userSettingService,

            JwtService jwtService

    ) {

        this.userSettingService = userSettingService;

        this.jwtService = jwtService;
    }

    // 내 정보 조회
    @GetMapping("/me")
    public UserSettingResponseDto getMySetting(

            @RequestHeader("Authorization")
            String authorization

    ) {

        String token = authorization.replace(
                "Bearer ",
                ""
        );

        String loginId = jwtService
                .getLoginIdFromToken(token);

        return userSettingService
                .getMySetting(loginId);
    }

    // 내 정보 수정
    @PutMapping("/me")
    public String updateMySetting(

            @RequestHeader("Authorization")
            String authorization,

            @RequestBody
            UserSettingUpdateRequestDto dto

    ) {

        String token = authorization.replace(
                "Bearer ",
                ""
        );

        String loginId = jwtService
                .getLoginIdFromToken(token);

        return userSettingService
                .updateMySetting(loginId, dto);
    }

    // 비밀번호 변경
    @PutMapping("/password")
    public String changePassword(

            @RequestHeader("Authorization")
            String authorization,

            @RequestBody
            PasswordChangeRequestDto dto

    ) {

        String token = authorization.replace(
                "Bearer ",
                ""
        );

        String loginId = jwtService
                .getLoginIdFromToken(token);

        return userSettingService
                .changePassword(loginId, dto);
    }
}