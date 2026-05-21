package com.example.fabricordersserver.dto;

public class CompanySettingRequestDto {

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

    private String kakaoChannelId;

    private Integer soldOutYard;

    private Boolean showSoldOut;

    private Boolean usePriceCut;

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