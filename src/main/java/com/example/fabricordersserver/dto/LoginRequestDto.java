package com.example.fabricordersserver.dto;

public class LoginRequestDto {

    // 아이디
    private String id;

    // 비밀번호
    private String password;

    // 아이디 getter
    public String getId() {
        return id;
    }

    // 비밀번호 getter
    public String getPassword() {
        return password;
    }
}