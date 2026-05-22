package com.example.fabricordersserver.dto;

import com.example.fabricordersserver.entity.Vendor;

/**
 * Response DTO returned to frontend representing a vendor.
 * Constructed from the `Vendor` entity and used by list/detail views.
 */
public class VendorResponseDto {

    private Long id;
    private String groupName;
    private String branchName;
    private String loginId;
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
    private boolean active;

    public VendorResponseDto(Vendor vendor) {
        this.id = vendor.getId();
        this.groupName = vendor.getGroupName();
        this.branchName = vendor.getBranchName();
        this.loginId = vendor.getLoginId();
        this.representativeName = vendor.getRepresentativeName();
        this.businessName = vendor.getBusinessName();
        this.businessNumber = vendor.getBusinessNumber();
        this.businessType = vendor.getBusinessType();
        this.businessItem = vendor.getBusinessItem();
        this.zipcode = vendor.getZipcode();
        this.address = vendor.getAddress();
        this.detailAddress = vendor.getDetailAddress();
        this.mobile = vendor.getMobile();
        this.fax = vendor.getFax();
        this.email = vendor.getEmail();
        this.taxEmail = vendor.getTaxEmail();
        this.baseRatePercent = vendor.getBaseRatePercent();
        this.baseRateWon = vendor.getBaseRateWon();
        this.active = vendor.isActive();
    }

    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLoginId() {
        return loginId;
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

    public boolean isActive() {
        return active;
    }
}
