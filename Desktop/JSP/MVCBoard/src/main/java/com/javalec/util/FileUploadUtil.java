package com.javalec.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploadUtil {

    // 이미지를 폴더에 저장하고 저장된 파일의 경로를 반환하는 메소드
    public static String saveImageToFolder(Part part, String folderPath) throws IOException {
        InputStream inputStream = part.getInputStream();
        String uniqueFileName = generateUniqueFileName(part);
        String filePath = folderPath + File.separator + uniqueFileName;

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        return filePath; // 파일이 저장된 경로를 반환
    }

    // 이미지 파일에 고유한 파일 이름 생성
    private static String generateUniqueFileName(Part part) {
        String submittedFileName = part.getSubmittedFileName();
        String extension = submittedFileName.substring(submittedFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + extension;
    }
}
