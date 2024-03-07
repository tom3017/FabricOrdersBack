package com.javalec.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.javalec.util.FileUploadUtil;

public class sign_Dao_JM {

    private DataSource dataSource;

    public sign_Dao_JM() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc"); // context 파일 위치
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(String id, String pw, String name, Part part) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            String query = "INSERT INTO customer (id, pw, name, date, image_path) VALUES (?, ?, ?, NOW(), ?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);
            preparedStatement.setString(3, name);

            // 파일 업로드 처리
            if (part != null) {
                // 이미지를 폴더에 저장
                String folderPath = "./image/"; // 원하는 폴더 경로로 업데이트
                String imageFileName = FileUploadUtil.saveImageToFolder(part, folderPath);
                preparedStatement.setString(4, imageFileName);
            } else {
                preparedStatement.setString(4, null);
            }

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 닫기
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
