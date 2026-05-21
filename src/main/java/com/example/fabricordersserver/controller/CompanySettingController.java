package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.dto.CompanySettingRequestDto;
import com.example.fabricordersserver.dto.CompanySettingResponseDto;
import com.example.fabricordersserver.service.CompanySettingService;
import com.example.fabricordersserver.service.JwtService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company-setting")
public class CompanySettingController {

    private final CompanySettingService companySettingService;

    private final JwtService jwtService;

    public CompanySettingController(

            CompanySettingService companySettingService,

            JwtService jwtService
    ) {

        this.companySettingService =
                companySettingService;

        this.jwtService =
                jwtService;
    }

    // =========================
    // 회사 정보 조회
    // =========================
    @GetMapping
    public CompanySettingResponseDto getSetting(

            @RequestHeader("Authorization")
            String authorization
    ) {

        String token = authorization.replace(
                "Bearer ",
                ""
        );

        String loginId =
                jwtService.getLoginIdFromToken(
                        token
                );

        return companySettingService
                .getSetting(loginId);
    }

    // =========================
    // 회사 정보 등록
    // =========================
    @PostMapping
    public String saveSetting(

            @RequestHeader("Authorization")
            String authorization,

            @RequestBody
            CompanySettingRequestDto dto
    ) {

        String token = authorization.replace(
                "Bearer ",
                ""
        );

        String loginId =
                jwtService.getLoginIdFromToken(
                        token
                );

        return companySettingService
                .saveSetting(
                        loginId,
                        dto
                );
    }

    // =========================
    // 회사 정보 수정
    // =========================
    @PutMapping
    public String updateSetting(

            @RequestHeader("Authorization")
            String authorization,

            @RequestBody
            CompanySettingRequestDto dto
    ) {

        String token = authorization.replace(
                "Bearer ",
                ""
        );

        String loginId =
                jwtService.getLoginIdFromToken(
                        token
                );

        return companySettingService
                .saveSetting(
                        loginId,
                        dto
                );
    }
}