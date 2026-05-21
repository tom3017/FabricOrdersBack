package com.example.fabricordersserver.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 비밀번호 암호화
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    // Spring Security 설정
    @Bean
    public SecurityFilterChain securityFilterChain(

            HttpSecurity http

    ) throws Exception {

        http

            // csrf 끄기
            .csrf(csrf -> csrf.disable())

            // cors 허용
            .cors(cors -> {})

            // API 권한 설정
            .authorizeHttpRequests(auth -> auth

                // auth API 전체 허용
                .requestMatchers("/auth/**")

                .permitAll()


                .requestMatchers("/manufacturers/**")

                .permitAll()
                // 나머지는 허용
                .anyRequest()

                .permitAll()
            )

            // 로그인 폼 비활성화
            .formLogin(form -> form.disable());

        return http.build();
    }
}