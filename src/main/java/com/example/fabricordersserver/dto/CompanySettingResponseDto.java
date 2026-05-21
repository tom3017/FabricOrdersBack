package com.example.fabricordersserver.dto;

import com.example.fabricordersserver.entity.CompanySetting;

public class CompanySettingResponseDto {

    // 사업자 정보
    private String brandName;
    private String storeName;
    private String phone;
    private String fax;
    private String zipcode;
    private String address;
    private String detailAddress;
    private String ownerName;
    private String companyName;
    private String businessNumber;
    private String businessType;
    private String businessItem;
    private String taxEmail;

    // 카카오
    private String kakaoChannelId;

    // 품절
    private Integer soldOutYard;

    // 온라인
    private Boolean showSoldOut;

    // 정산
    private Boolean usePriceCut;

    public CompanySettingResponseDto(
            CompanySetting setting
    ) {

        this.brandName
                = setting.getBrandName();

        this.storeName
                = setting.getStoreName();

        this.phone
                = setting.getPhone();

        this.fax
                = setting.getFax();

        this.zipcode
                = setting.getZipcode();

        this.address
                = setting.getAddress();

        this.detailAddress
                = setting.getDetailAddress();

        this.ownerName
                = setting.getOwnerName();

        this.companyName
                = setting.getCompanyName();

        this.businessNumber
                = setting.getBusinessNumber();

        this.businessType
                = setting.getBusinessType();

        this.businessItem
                = setting.getBusinessItem();

        this.taxEmail
                = setting.getTaxEmail();

        this.kakaoChannelId
                = setting.getKakaoChannelId();

        this.soldOutYard
                = setting.getSoldOutYard();

        this.showSoldOut
                = setting.getShowSoldOut();

        this.usePriceCut
                = setting.getUsePriceCut();
    }

    public String getBrandName() {
        return brandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getAddress() {
        return address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getBusinessItem() {
        return businessItem;
    }

    public String getTaxEmail() {
        return taxEmail;
    }

    public String getKakaoChannelId() {
        return kakaoChannelId;
    }

    public Integer getSoldOutYard() {
        return soldOutYard;
    }

    public Boolean getShowSoldOut() {
        return showSoldOut;
    }

    public Boolean getUsePriceCut() {
        return usePriceCut;
    }
}