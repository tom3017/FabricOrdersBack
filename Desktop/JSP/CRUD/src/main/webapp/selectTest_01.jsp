<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% 

	String url_mysql = "jdbc:mysql://localhost/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "gkdldua12!@";
	
	String query = "SELECT id, userid FROM wtest";
	
	int cnt = 0;
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		ResultSet rs = stmt_mysql.executeQuery(query);
		
%>	
	<table border = "1">
		<tr>
			<th>일련번호</th><th>User ID</th>
		</tr>
<%
		while(rs.next()){
%>
			<tr>
				<td><%=rs.getInt(1) %></td>
				<td><%=rs.getString(2) %></td>
			</tr>
<%
			cnt++;
		}
%>		
		</table>		
<%		
		conn_mysql.close();
		
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}


%>
	<br><br>
	총인원은 <%=cnt %>명 입니다.


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>