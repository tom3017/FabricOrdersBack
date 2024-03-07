<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	String tel = request.getParameter("phone");
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
		
		
		
		String query = "insert into purchaserinfo (userid, name, tel, address, insertdate) values (?, ?, ?, ?, now())";
		ps = conn_mysql.prepareStatement(query);
		ps.setString(1, userid);
		ps.setString(2, name);
		ps.setString(3, tel);
		ps.setString(4, address);
		
		ps.executeUpdate();
		
		conn_mysql.close();
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	

	response.sendRedirect("insert03.jsp");



%>



