package com.example.fabricordersserver.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing a vendor (거래처).
 * Fields match the frontend vendor form and are persisted to the `vendors` table.
 */
@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    private String branchName;

    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
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

    private boolean active = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    protected Vendor() {}

    public Vendor(String groupName,
                  String branchName,
                  String loginId,
                  String password,
                  String representativeName,
                  String businessName,
                  String businessNumber,
                  String businessType,
                  String businessItem,
                  String zipcode,
                  String address,
                  String detailAddress,
                  String mobile,
                  String fax,
                  String email,
                  String taxEmail,
                  Integer baseRatePercent,
                  Integer baseRateWon) {
        this.groupName = groupName;
        this.branchName = branchName;
        this.loginId = loginId;
        this.password = password;
        this.representativeName = representativeName;
        this.businessName = businessName;
        this.businessNumber = businessNumber;
        this.businessType = businessType;
        this.businessItem = businessItem;
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.mobile = mobile;
        this.fax = fax;
        this.email = email;
        this.taxEmail = taxEmail;
        this.baseRatePercent = baseRatePercent;
        this.baseRateWon = baseRateWon;
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

    public boolean isActive() {
        return active;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void setBusinessItem(String businessItem) {
        this.businessItem = businessItem;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTaxEmail(String taxEmail) {
        this.taxEmail = taxEmail;
    }

    public void setBaseRatePercent(Integer baseRatePercent) {
        this.baseRatePercent = baseRatePercent;
    }

    public void setBaseRateWon(Integer baseRateWon) {
        this.baseRateWon = baseRateWon;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
