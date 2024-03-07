<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
	
		String age = request.getParameter("age");
	
	%>
	
	
	
		<h1>미성년자</h1>>
		당신의 나이는 <%=age %>살 이므로 주류구매가 불가능합니다. Naga <br>
		<a href="responseAge_01.jsp">처음으로 이동</a>
	
	
	</body>
</html>