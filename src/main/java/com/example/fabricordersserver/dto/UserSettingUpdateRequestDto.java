package com.example.fabricordersserver.dto;

public class UserSettingUpdateRequestDto {

    private String name;

    private String email;

    private String phone;

    private boolean kakaoNotification;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isKakaoNotification() {
        return kakaoNotification;
    }
}