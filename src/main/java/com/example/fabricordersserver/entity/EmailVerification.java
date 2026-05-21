package com.example.fabricordersserver.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "email_verifications")
public class EmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이메일
    private String email;

    // 인증번호
    private String code;

    // 인증 여부
    private boolean verified;

    public EmailVerification(){}

    public EmailVerification(

            String email,
            String code
    ){

        this.email = email;

        this.code = code;

        this.verified = false;
    }

    public String getEmail() {

        return email;
    }

    public String getCode() {

        return code;
    }

    public boolean isVerified() {

        return verified;
    }

    public void setVerified(boolean verified) {

        this.verified = verified;
    }
}