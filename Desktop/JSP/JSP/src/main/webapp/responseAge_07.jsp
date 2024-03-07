<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>성인 확인</title>
	</head>
	<body>
	<%
	/* ************************************************************************************** */
		String age = request.getParameter("age");
		String title = URLDecoder.decode(request.getParameter("title"), "utf-8");
		String result = URLDecoder.decode(request.getParameter("result"), "utf-8");
	/* ************************************************************************************** */
		
	%>
	
	
	
		<h1><%=title %></h1>>
		당신의 나이는 <%=age %>살 이므로 주류구매가 <%=result %>합니다. <br>
		<a href="responseAge_05.jsp">처음으로 이동</a>
	</body>
</html>