package com.example.fabricordersserver.dto;

public class LoginResponseDto {

    private String result;
    private String name;
    private String token;

    public LoginResponseDto(String result, String name, String token) {
        this.result = result;
        this.name = name;
        this.token = token;
    }

    public String getResult() { return result; }

    public String getName() { return name; }

    public String getToken() { return token; }
}