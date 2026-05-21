package com.example.fabricordersserver.service;

import com.example.fabricordersserver.dto.CompanySettingRequestDto;

import com.example.fabricordersserver.dto.CompanySettingResponseDto;

import com.example.fabricordersserver.entity.CompanySetting;

import com.example.fabricordersserver.entity.User;

import com.example.fabricordersserver.repository.CompanySettingRepository;

import com.example.fabricordersserver.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class CompanySettingService {

    // =========================
    // 회사설정 Repository
    // =========================
    private final CompanySettingRepository
            companySettingRepository;

    // =========================
    // 유저 Repository
    // =========================
    private final UserRepository
            userRepository;

    // =========================
    // 생성자 주입
    // =========================
    public CompanySettingService(

            CompanySettingRepository
                    companySettingRepository,

            UserRepository userRepository
    ) {

        this.companySettingRepository
                = companySettingRepository;

        this.userRepository
                = userRepository;
    }

    // =========================
    // 회사 설정 조회
    // =========================
    public CompanySettingResponseDto
    getSetting(String loginId) {

        // 유저 조회
        User user = userRepository
                .findByLoginId(loginId)
                .orElseThrow();

        // 회사 설정 조회
        CompanySetting setting =

                companySettingRepository
                        .findByUser(user)
                        .orElse(null);

        // 없으면 null
        if(setting == null){

            return null;
        }

        // DTO 반환
        return new CompanySettingResponseDto(
                setting
        );
    }

    // =========================
    // 회사 설정 저장/수정
    // =========================
    public String saveSetting(

            String loginId,

            CompanySettingRequestDto dto
    ) {

        // =========================
        // 유저 조회
        // =========================
        User user = userRepository
                .findByLoginId(loginId)
                .orElseThrow();

        // =========================
        // 기존 설정 조회
        // =========================
        CompanySetting setting =

                companySettingRepository
                        .findByUser(user)
                        .orElse(null);

        // =========================
        // 최초 등록
        // =========================
        if(setting == null){

            setting = new CompanySetting();

            setting.setUser(user);
        }

        // =========================
        // 브랜드명
        // 최초 등록 후 수정 불가
        // =========================
        if(

            setting.getBrandName() == null

            ||

            setting.getBrandName().isBlank()

        ){

            setting.setBrandName(
                    dto.getBrandName()
            );
        }

        // =========================
        // 사업자 정보
        // =========================

        setting.setStoreName(
                dto.getStoreName()
        );

        setting.setPhone(
                dto.getPhone()
        );

        setting.setFax(
                dto.getFax()
        );

        setting.setZipcode(
                dto.getZipcode()
        );

        setting.setAddress(
                dto.getAddress()
        );

        setting.setDetailAddress(
                dto.getDetailAddress()
        );

        setting.setOwnerName(
                dto.getOwnerName()
        );

        setting.setCompanyName(
                dto.getCompanyName()
        );

        setting.setBusinessNumber(
                dto.getBusinessNumber()
        );

        setting.setBusinessType(
                dto.getBusinessType()
        );

        setting.setBusinessItem(
                dto.getBusinessItem()
        );

        setting.setTaxEmail(
                dto.getTaxEmail()
        );

        // =========================
        // 카카오 설정
        // =========================
        setting.setKakaoChannelId(
                dto.getKakaoChannelId()
        );

        // =========================
        // 품절 관리
        // =========================
        setting.setSoldOutYard(
                dto.getSoldOutYard()
        );

        // =========================
        // 온라인 관리
        // =========================
        setting.setShowSoldOut(
                dto.getShowSoldOut()
        );

        // =========================
        // 정산 관리
        // =========================
        setting.setUsePriceCut(
                dto.getUsePriceCut()
        );

        // =========================
        // 저장
        // =========================
        companySettingRepository
                .save(setting);

        return "SUCCESS";
    }
}