<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String seq = (String) session.getAttribute("SEQ");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
    session.setAttribute("seq", seq);
    session.setAttribute("name", name);
    session.setAttribute("tel", tel);
    session.setAttribute("address", address);

	String url_mysql = "jdbc:mysql://localhost/quiz?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "gkdldua12!@";
	
	PreparedStatement ps = null;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		
		
		String query = "delete from userinfo where seq = ?";
		ps = conn_mysql.prepareStatement(query);
		ps.setString(1, seq);
		
		ps.executeUpdate();
		
		conn_mysql.close();
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	

	response.sendRedirect("quiz01.jsp");



%>



