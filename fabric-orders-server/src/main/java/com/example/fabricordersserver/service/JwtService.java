package com.example.fabricordersserver.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final String secretKeyValue;
    private final long expirationMs;
    private SecretKey secretKey;

    public JwtService(
            @Value("${security.jwt.secret}") String secretKeyValue,
            @Value("${security.jwt.expiration-ms:86400000}") long expirationMs
    ) {
        this.secretKeyValue = secretKeyValue;
        this.expirationMs = expirationMs;
    }

    @PostConstruct
    public void init() {
        if (secretKeyValue == null || secretKeyValue.isBlank() || secretKeyValue.length() < 32) {
            throw new IllegalStateException("JWT secret must be configured and at least 32 characters long.");
        }
        this.secretKey = Keys.hmacShaKeyFor(secretKeyValue.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(String loginId, String name) {
        Date now = new Date();

        return Jwts.builder()
                .setSubject(loginId)
                .claim("name", name)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationMs))
                .signWith(secretKey)
                .compact();
    }

    public String getLoginIdFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}