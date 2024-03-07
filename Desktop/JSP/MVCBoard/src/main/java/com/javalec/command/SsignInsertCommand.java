package com.javalec.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.javalec.dao.sign_Dao_JM;
import com.javalec.util.FileUploadUtil;

public class SsignInsertCommand implements BCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        Part part = null;

        try {
            part = request.getPart("profileImage");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

        System.out.println("Part: " + part);
        if (part != null) {
            System.out.println("FilePart: " + part);
        } else {
            System.out.println("파일 파트가 존재하지 않습니다.");
            // 파일 파트가 존재하지 않을 때의 처리 (예: 기본 이미지 설정 등)
            return;
        }

        // 파일 업로드 처리
        if (part != null) {
            String imageFileName;
            try {
                imageFileName = FileUploadUtil.saveImageToFolder(part, "./image/");
                sign_Dao_JM dao = new sign_Dao_JM();
                dao.write(id, pw, imageFileName, part);
            } catch (IOException e) {
                e.printStackTrace();
                // 파일 업로드 실패 시 사용자에게 알림 메시지 등을 추가하는 것이 좋음
            }
        } else {
            // filePart가 null인 경우에 대한 처리
            System.out.println("파일이 첨부되지 않았습니다.");
        }
    }
}
