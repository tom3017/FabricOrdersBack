package com.example.fabricordersserver.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration config =
                new CorsConfiguration();

        // React 주소 허용
        config.setAllowedOriginPatterns(
                List.of("*")
        );

        // Header 허용
        config.setAllowedHeaders(
                List.of("*")
        );

        // Method 허용
        config.setAllowedMethods(
                List.of("*")
        );

        // 인증 허용
        config.setAllowCredentials(true);

        // expose
        config.setExposedHeaders(
                List.of("Authorization")
        );

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                config
        );

        return new CorsFilter(source);
    }
}