package com.example.fabricordersserver.dto;

public class PasswordChangeRequestDto {

    // 아이디
    private String loginId;

    // 이메일
    private String email;

    // 새 비밀번호
    private String newPassword;

    public String getLoginId() {

        return loginId;
    }

    public void setLoginId(String loginId) {

        this.loginId = loginId;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getNewPassword() {

        return newPassword;
    }

    public void setNewPassword(String newPassword) {

        this.newPassword = newPassword;
    }
}