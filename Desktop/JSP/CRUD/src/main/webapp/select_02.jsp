<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% 
	


	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");

	
	String url_mysql = "jdbc:mysql://localhost/customer?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "gkdldua12!@";
	
	String query = "SELECT name, tel, address FROM purchaserinfo where userid = '" + userid + "'";
	
	String name = "";
	String tel = "";
	String address = "";
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		ResultSet rs = stmt_mysql.executeQuery(query);
		
		if(rs.next()){
			name = rs.getString(1);
			tel = rs.getString(2);
			address = rs.getString(3);
		}
		conn_mysql.close();
		
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
	<form action = "select_03.jsp" method="post">
		<table>
			<tr>
				<td align = "righr"> User ID: </td>
				<td><input type="text" name="userid" size="10"  value="<%=userid %>" readonly="readonly"></td>
				
			</tr>
			<tr>
				<td align = "right"> 성명: </td>
				<td><input type="text" name="name" size="10"  value="<%=name %>"></td>
				
			</tr>
			<tr>
				<td align = "right"> 전화번호: </td>
				<td><input type="text" name="tel" value="<%=tel %>"></td>
				
			</tr>
			<tr>
				<td align = "right"> 주소: </td>
				<td><input type="text" name="address" size="60" value="<%=address %>"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
				<td><input type="submit" value="수정"> </td>
	
	
	</form>
	<form action = "select_04.jsp" method="post">
		<%session.setAttribute("USERID", userid); %>
		<td><input type="submit" value="삭제"> </td>
		
	</form>












<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>