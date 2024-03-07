package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.dto.BDto;

public class BDao {
	// Field
	DataSource dataSource;

	// Construct

	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc"); // context 파일 위치

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 검색
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bid = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");

				BDto dto = new BDto(bid, bName, bTitle, bContent, bDate);

				dtos.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
			//역순으로 지운다. 이유는 1번 부터 지우면 2번 3 번을 땡겨서 번호가 달라짐
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					resultSet.close();
				if (connection != null)
					resultSet.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}// list()
	
	public void write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bName,bTitle,bContent,bDate) values (?,?,?,now())";
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.executeUpdate();
			
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {//메모리 정리용도로 많이 씀(만든거랑 거꾸로)
			try {
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}//write
	
	public void update(String bName, String bTitle, String bContent, String bId) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setString(4, bId);
			preparedStatement.executeUpdate();
			
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {//메모리 정리용도로 많이 씀(만든거랑 거꾸로)
			try {
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}//update
	
	public BDto infomation(String bId) {
		
		BDto dto_viewContent = null;
		int bId_int = Integer.parseInt(bId);
		
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select bName, bTitle, bContent, bDate from mvc_board";
			String where = " where= bId = ?";
			System.out.println(query + where);
			preparedStatement =connection.prepareStatement(query + where);
			preparedStatement.setString(1, bId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String infomation_bName = resultSet.getString("bName");
				String infomation_bTitle = resultSet.getString("bTitle");
				String infomation_bContent = resultSet.getString("bContent");
				java.sql.Timestamp bDate = resultSet.getTimestamp("bDate");
				dto_viewContent = new BDto(bId_int, infomation_bName, infomation_bTitle, infomation_bContent, bDate);
				
			}
			
			
			
			
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {//메모리 정리용도로 많이 씀(만든거랑 거꾸로)
			try {
				
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto_viewContent;
		
		
	}//view

	
	
	
}// END
