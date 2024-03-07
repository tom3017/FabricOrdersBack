<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
		 request.setCharacterEncoding("utf-8");

	     String userid = request.getParameter("userid");
	     String name = request.getParameter("name");
	     String tel = request.getParameter("tel");
	     String address = request.getParameter("address");

		 String url_mysql = "jdbc:mysql://localhost/customer?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
		 String id_mysql = "root";
		 String pw_mysql = "gkdldua12!@";
		 
		 PreparedStatement ps = null;
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			 Statement stmt_mysql = conn_mysql.createStatement();
			 
			 String query = "update purchaserinfo set name = ?, tel = ?, address = ? where userid = ?";
			 /* 준비하는거임 */
			 ps = conn_mysql.prepareStatement(query);
			 ps.setString(1, name);
			 ps.setString(2, tel);
			 ps.setString(3, address);
			 ps.setString(4, (String)session.getAttribute("USERID"));
			 
			 ps.executeUpdate();
			 
			 conn_mysql.close();
			 session.setAttribute("NAME", name);
			 session.setAttribute("TEL", tel);
			 session.setAttribute("ADDRESS", address);
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 response.sendRedirect("select_01.jsp");
%>