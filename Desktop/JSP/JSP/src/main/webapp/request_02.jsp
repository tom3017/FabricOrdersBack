<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>반갑읍니다.</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("yourname");
				
			
		%>
		안녕하세요 <%=name %> 님 <br>
		
	</body>
</html>