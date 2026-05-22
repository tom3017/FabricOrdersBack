package com.example.fabricordersserver.dto;

/**
 * DTO for creating or updating a vendor from frontend payload.
 * Fields correspond to the vendor form inputs sent by the UI.
 */
public class VendorRequestDto {

    private String groupName;
    private String branchName;
    private String loginId;
    private String password;
    private String representativeName;
    private String businessName;
    private String businessNumber;
    private String businessType;
    private String businessItem;
    private String zipcode;
    private String address;
    private String detailAddress;
    private String mobile;
    private String fax;
    private String email;
    private String taxEmail;
    private Integer baseRatePercent;
    private Integer baseRateWon;

    public String getGroupName() {
        return groupName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public String getBusinessName() {
        return businessName;
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

    public String getZipcode() {
        return zipcode;
    }

    public String getAddress() {
        return address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getTaxEmail() {
        return taxEmail;
    }

    public Integer getBaseRatePercent() {
        return baseRatePercent;
    }

    public Integer getBaseRateWon() {
        return baseRateWon;
    }
}
