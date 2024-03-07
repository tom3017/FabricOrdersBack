<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>

<% 
	String userid = request.getParameter("userid");

	String url_mysql = "jdbc:mysql://localhost/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "gkdldua12!@";
	
	/* String userid = request.getParameter("userid"); */
	
	PreparedStatement ps = null;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		String query = "update wtest set userid = ? where id = ?";
		ps = conn_mysql.prepareStatement(query);
		ps.setString(1, userid);
		ps.setString(2, (String)session.getAttribute("ID"));
		
		ps.executeUpdate();
		
		conn_mysql.close();
		session.setAttribute("NEW", userid);
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("updateTest_04.jsp");



%>


