<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
/* getParameter */
String queryName = request.getParameter("query");
String queryContent = request.getParameter("content");

if (queryName == null) {
	queryName = "address";
	queryContent = "";
}
/* Database 연결 */
String url_mysql = "jdbc:mysql://localhost/quiz?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
String id_mysql = "root";
String pw_mysql = "gkdldua12!@";

/* getParameter */

String query = "SELECT seq, name, tel, address, email, relation  FROM userinfo ";
String query1 = "where " + queryName + " like '%" + queryContent + "%'";

int cnt = 0;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	Statement stmt_mysql = conn_mysql.createStatement();

	ResultSet rs = stmt_mysql.executeQuery(query + query1);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 명단 리스트</title>
</head>
<body>
	<h3>주소록 명단 리스트</h3>
	<form action="addressQuery01.jsp">
		검색 선택 : <select name="query">
			<option value="name">이름</option>
			<option value="tel">전화번호</option>
			<option value="address" selected="selected">주소</option>
			<option value="relation">관계</option>
		</select> <input type="text" name="content" size="30"> <input
			type="submit" value="검색">


	</form>
	<br>
	<hr>
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
	<br> 총인원은
	<%=cnt%>명 입니다.








</body>
</html>