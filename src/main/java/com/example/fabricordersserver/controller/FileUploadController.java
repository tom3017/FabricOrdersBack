package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.entity.User;

import com.example.fabricordersserver.repository.UserRepository;

import com.example.fabricordersserver.service.JwtService;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;

import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final JwtService jwtService;

    private final UserRepository userRepository;

    public FileUploadController(

            JwtService jwtService,

            UserRepository userRepository

    ) {

        this.jwtService = jwtService;

        this.userRepository = userRepository;
    }

    // =========================
    // 프로필 이미지 업로드
    // =========================
    @PostMapping("/profile")
    public ResponseEntity<String> uploadProfile(

            @RequestHeader("Authorization")
            String authorization,

            @RequestParam("file")
            MultipartFile file

    ) throws IOException {

        // 토큰 추출
        String token = authorization.replace(
                "Bearer ",
                ""
        );

        // 로그인 아이디 추출
        String loginId = jwtService
                .getLoginIdFromToken(token);

        // 유저 조회
        User user = userRepository
                .findByLoginId(loginId)
                .orElseThrow();

        // 파일 없을 경우
        if (file.isEmpty()) {

            return ResponseEntity
                    .badRequest()
                    .body("EMPTY_FILE");
        }

        // 원본 파일명
        String originalName =
                file.getOriginalFilename();

        // 확장자 추출
        String extension =
                originalName.substring(
                        originalName.lastIndexOf(".")
                );

        // 랜덤 파일명 생성
        String savedName =
                UUID.randomUUID()
                        + extension;

        // 프로젝트 루트 경로
        String rootPath =
                System.getProperty(
                        "user.dir"
                );

        // uploads/profile 절대경로
        File directory = new File(

                rootPath
                        + "/"
                        + uploadDir
        );

        // 폴더 없으면 생성
        if (!directory.exists()) {

            directory.mkdirs();
        }

        // 저장 파일
        File saveFile = new File(
                directory,
                savedName
        );

        // 실제 파일 저장
        file.transferTo(saveFile);

        // DB 저장용 이미지 주소
        String imagePath =

                "http://localhost:8080/uploads/profile/"
                        + savedName;

        // 유저 프로필 이미지 저장
        user.setProfileImage(imagePath);

        userRepository.save(user);

        // 반환
        return ResponseEntity.ok(
                imagePath
        );
    }
}