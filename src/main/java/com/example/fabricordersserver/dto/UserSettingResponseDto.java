package com.example.fabricordersserver.dto;

public class UserSettingResponseDto {

    private String name;

    private String email;

    private String phone;

    private String profileImage;

    private boolean kakaoNotification;

    public UserSettingResponseDto(

            String name,
            String email,
            String phone,
            String profileImage,
            boolean kakaoNotification

    ) {

        this.name = name;

        this.email = email;

        this.phone = phone;

        this.profileImage = profileImage;

        this.kakaoNotification = kakaoNotification;
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
}