package com.example.fabricordersserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Value("${spring.mail.gmail.username:}")
    private String gmailUsername;

    @Value("${spring.mail.gmail.password:}")
    private String gmailPassword;

    @Value("${spring.mail.naver.username:}")
    private String naverUsername;

    @Value("${spring.mail.naver.password:}")
    private String naverPassword;

    @Bean(name = "gmailSender")
    public JavaMailSender gmailSender() {
        return createMailSender(
                "smtp.gmail.com",
                587,
                gmailUsername,
                gmailPassword,
                false,
                true,
                null
        );
    }

    @Bean(name = "naverSender")
    public JavaMailSender naverSender() {
        return createMailSender(
                "smtp.naver.com",
                465,
                naverUsername,
                naverPassword,
                true,
                false,
                "smtp.naver.com"
        );
    }

    private JavaMailSender createMailSender(
            String host,
            int port,
            String username,
            String password,
            boolean sslEnable,
            boolean starttlsEnable,
            String sslTrustHost
    ) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", String.valueOf(starttlsEnable));
        props.put("mail.smtp.ssl.enable", String.valueOf(sslEnable));
        if (sslTrustHost != null) {
            props.put("mail.smtp.ssl.trust", sslTrustHost);
        }
        return mailSender;
    }
}
