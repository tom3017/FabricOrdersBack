<%@page import="com.javalec.base.dto"%>
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
	dto product = new dto(); /* 하나씩 아니고 객체를 집어넣는다. 클라스를 보내버린다. */
	
	product.setName("바나나");
	product.setValue(2000);
	
	request.setAttribute("PRODUCT", product);
	RequestDispatcher dispatcher = request.getRequestDispatcher("EL_04.jsp");
	dispatcher.forward(request, response);
	
	
	
	
	
	
	
	
	
	
	%>
	</body>
</html>