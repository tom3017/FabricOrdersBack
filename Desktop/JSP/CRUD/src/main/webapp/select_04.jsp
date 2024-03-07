<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String userid = (String) session.getAttribute("USERID");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
    session.setAttribute("userid", userid);
    session.setAttribute("name", name);
    session.setAttribute("tel", tel);
    session.setAttribute("address", address);

	String url_mysql = "jdbc:mysql://localhost/customer?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "gkdldua12!@";
	
	PreparedStatement ps = null;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		
		
		String query = "delete from purchaserinfo where userid = ?";
		ps = conn_mysql.prepareStatement(query);
		ps.setString(1, userid);
		
		ps.executeUpdate();
		
		conn_mysql.close();
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	

	response.sendRedirect("select_01.jsp");



%>



