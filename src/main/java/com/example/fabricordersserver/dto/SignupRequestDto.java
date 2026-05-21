package com.example.fabricordersserver.dto;

public class SignupRequestDto {

    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phone;

    public String getLoginId() { return loginId; }

    public String getPassword() { return password; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }
}