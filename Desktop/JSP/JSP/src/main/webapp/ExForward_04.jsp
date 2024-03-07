<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>곱셈 입니다.</title>
	</head>
	<body>
	
<%
	
	request.setCharacterEncoding("utf-8");

	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	int result = num1 * num2;
	
	response.sendRedirect("https://192.168.50.11:8080/ExForward_01=" + result);
	
%>
		첫번째수 : <%=num1 %>
		두번째수 : <%=num2 %>
		
		<%=num1 %> / <%=num2 %> = <%=result %>
		<input type="submit" value="초기화면">
		<input type="submit" value="나눗셈">
	
	</body>
</html>