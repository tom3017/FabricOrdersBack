package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.entity.User;
import com.example.fabricordersserver.repository.UserRepository;
import com.example.fabricordersserver.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
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

    @PostMapping("/profile")
    public ResponseEntity<String> uploadProfile(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("EMPTY_FILE");
        }

        String token = authorization.replace("Bearer ", "");
        String loginId = jwtService.getLoginIdFromToken(token);

        User user = userRepository.findByLoginId(loginId).orElseThrow();

        String originalName = Optional.ofNullable(file.getOriginalFilename())
                .orElse("uploaded-file");

        String extension = originalName.contains(".")
                ? originalName.substring(originalName.lastIndexOf('.'))
                : ".bin";

        String savedName = UUID.randomUUID() + extension;

        Path directory = Path.of(uploadDir).toAbsolutePath();
        Files.createDirectories(directory);

        Path savePath = directory.resolve(savedName);
        file.transferTo(savePath);

        String imagePath = "http://localhost:8080/uploads/profile/" + savedName;
        user.setProfileImage(imagePath);
        userRepository.save(user);

        return ResponseEntity.ok(imagePath);
    }
}
