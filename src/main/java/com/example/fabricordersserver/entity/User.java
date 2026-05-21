package com.example.fabricordersserver.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 로그인 아이디
    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;

    // 비밀번호
    @Column(nullable = false)
    private String password;

    // 이름
    @Column(nullable = false)
    private String name;

    // 이메일
    @Column(nullable = false, unique = true)
    private String email;

    // 전화번호
    private String phone;

    // 프로필 이미지
    private String profileImage;

    // 카카오 알림 여부
    private boolean kakaoNotification;

    // 가입일
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    protected User() {}

    public User(
            String loginId,
            String password,
            String name,
            String email,
            String phone
    ) {

        this.loginId = loginId;

        this.password = password;

        this.name = name;

        this.email = email;

        this.phone = phone;

        this.profileImage = "";

        this.kakaoNotification = false;
    }

    public Long getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public boolean isKakaoNotification() {
        return kakaoNotification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setKakaoNotification(boolean kakaoNotification) {
        this.kakaoNotification = kakaoNotification;
    }
}