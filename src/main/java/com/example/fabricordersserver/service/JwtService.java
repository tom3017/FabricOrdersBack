package com.example.fabricordersserver.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY =
            "fabric-order-app-secret-key-1234567890-fabric-order-app";

    // JWT 생성
    public String createToken(

            String loginId,
            String name

    ) {

        Date now = new Date();

        Date expiration = new Date(
                now.getTime() + 1000 * 60 * 60 * 24
        );

        return Jwts.builder()

                .subject(loginId)

                .claim("name", name)

                .issuedAt(now)

                .expiration(expiration)

                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes(
                                        StandardCharsets.UTF_8
                                )
                        )
                )

                .compact();
    }

    // JWT 에서 로그인 아이디 추출
    public String getLoginIdFromToken(

            String token

    ) {

        return Jwts.parser()

                .verifyWith(

                        Keys.hmacShaKeyFor(

                                SECRET_KEY.getBytes(
                                        StandardCharsets.UTF_8
                                )
                        )
                )

                .build()

                .parseSignedClaims(token)

                .getPayload()

                .getSubject();
    }
}