package com.example.fabricordersserver.dto;

public class EmailVerifyRequestDto {

    private String email;
    private String code;

    public String getEmail() { return email; }

    public String getCode() { return code; }
}