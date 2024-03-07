<%@page import="java.util.GregorianCalendar"%>
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
	
	
	GregorianCalendar now = new GregorianCalendar();
	String date = String.format("%TF", now); /* %TF : yyyy-mm-dd */
	String time = String.format("%TT", now);
	
	
	
	%>
			<%=String.format("현재일은 %TY 년 %Tm 월 %Td  일 입니다." , now, now, now) %><br>
			<%=String.format("현재 시각은 %TH시 %TM 분 %TS 초 입니다.", now, now, now) %>
</body>
</html>