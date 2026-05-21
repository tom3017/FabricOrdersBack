package com.example.fabricordersserver.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    // Gmail SMTP
    @Bean(name = "gmailSender")
    public JavaMailSender gmailSender(){

        JavaMailSenderImpl mailSender
                = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");

        mailSender.setPort(587);

        mailSender.setUsername(
                "jungmin940324@gmail.com"
        );

        mailSender.setPassword(
                "ojqv wygt jyrz seti"
        );

        Properties props
                = mailSender.getJavaMailProperties();

        props.put("mail.smtp.auth", "true");

        props.put(
                "mail.smtp.starttls.enable",
                "true"
        );

        return mailSender;
    }

    // 네이버 SMTP
    @Bean(name = "naverSender")
    public JavaMailSender naverSender(){

        JavaMailSenderImpl mailSender
                = new JavaMailSenderImpl();

        mailSender.setHost("smtp.naver.com");

        mailSender.setPort(465);

        mailSender.setUsername(
                "tom3017@naver.com"
        );

        mailSender.setPassword(
                "1KRGF6PH62WM"
        );

        Properties props
                = mailSender.getJavaMailProperties();

    // SMTP 인증

    props.put("mail.smtp.auth", "true");

    // SSL 사용

    props.put(

            "mail.smtp.ssl.enable",

            "true"

    );

    // TLS 끄기

    props.put(

            "mail.smtp.starttls.enable",

            "false"

    );

    // 신뢰 서버

    props.put(

            "mail.smtp.ssl.trust",

            "smtp.naver.com"

    );

        return mailSender;
    }
}