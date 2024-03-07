<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
String url_mysql = "jdbc:mysql://localhost/quiz?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
String id_mysql = "root";
String pw_mysql = "gkdldua12!@";

/* getParameter */




String query = "SELECT seq, name, tel, address, email, relation  FROM userinfo";

int cnt = 0;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	Statement stmt_mysql = conn_mysql.createStatement();

	ResultSet rs = stmt_mysql.executeQuery(query);
%>
<table border="1">
	<tr>
		<th>Seq</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>전자우편</th>
		<th>관계</th>
	</tr>
	<%
	while (rs.next()) {
	%>
	<tr>
		<td><a href="quiz05.jsp?seq=<%=rs.getString(1)%>"><%=rs.getString(1)%></a></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(4)%></td>
		<td><%=rs.getString(5)%></td>
		<td><%=rs.getString(6)%></td>
	</tr>
	<%
	cnt++;
	}
	%>
</table>

<%
conn_mysql.close();

} catch (Exception e) {
e.printStackTrace();
}
%>

<form action="quiz02.jsp" method="post">

	<input type="submit" value="입력">
</form>


<br>
<br>
총인원은
<%=cnt%>명 입니다.


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>