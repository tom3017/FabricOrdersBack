package com.example.fabricordersserver.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "company_settings")
public class CompanySetting {

    // =========================
    // PK
    // =========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // 유저
    // =========================
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // =========================
    // 사업자 정보
    // =========================
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

    // =========================
    // 회사 로고
    // =========================
    private String logoImage;

    // =========================
    // 카카오 설정
    // =========================
    private String kakaoChannelId;

    // =========================
    // 품절 설정
    // =========================
    private Integer soldOutYard;

    // =========================
    // 온라인 설정
    // =========================
    private Boolean showSoldOut;

    // =========================
    // 정산 설정
    // =========================
    private Boolean usePriceCut;

    // =========================
    // 생성자
    // =========================
    public CompanySetting() {

    }

    // =========================
    // getter / setter
    // =========================

    public Long getId() {

        return id;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public String getBrandName() {

        return brandName;
    }

    public void setBrandName(String brandName) {

        this.brandName = brandName;
    }

    public String getStoreName() {

        return storeName;
    }

    public void setStoreName(String storeName) {

        this.storeName = storeName;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getFax() {

        return fax;
    }

    public void setFax(String fax) {

        this.fax = fax;
    }

    public String getZipcode() {

        return zipcode;
    }

    public void setZipcode(String zipcode) {

        this.zipcode = zipcode;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getDetailAddress() {

        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {

        this.detailAddress = detailAddress;
    }

    public String getOwnerName() {

        return ownerName;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    public String getBusinessNumber() {

        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {

        this.businessNumber = businessNumber;
    }

    public String getBusinessType() {

        return businessType;
    }

    public void setBusinessType(String businessType) {

        this.businessType = businessType;
    }

    public String getBusinessItem() {

        return businessItem;
    }

    public void setBusinessItem(String businessItem) {

        this.businessItem = businessItem;
    }

    public String getTaxEmail() {

        return taxEmail;
    }

    public void setTaxEmail(String taxEmail) {

        this.taxEmail = taxEmail;
    }

    public String getLogoImage() {

        return logoImage;
    }

    public void setLogoImage(String logoImage) {

        this.logoImage = logoImage;
    }

    public String getKakaoChannelId() {

        return kakaoChannelId;
    }

    public void setKakaoChannelId(String kakaoChannelId) {

        this.kakaoChannelId = kakaoChannelId;
    }

    public Integer getSoldOutYard() {

        return soldOutYard;
    }

    public void setSoldOutYard(Integer soldOutYard) {

        this.soldOutYard = soldOutYard;
    }

    public Boolean getShowSoldOut() {

        return showSoldOut;
    }

    public void setShowSoldOut(Boolean showSoldOut) {

        this.showSoldOut = showSoldOut;
    }

    public Boolean getUsePriceCut() {

        return usePriceCut;
    }

    public void setUsePriceCut(Boolean usePriceCut) {

        this.usePriceCut = usePriceCut;
    }
}