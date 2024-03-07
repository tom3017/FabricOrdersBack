<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	int age = Integer.parseInt(request.getParameter("age"));
	String title, result;
	
	
	
	if(age >= 20){
		/**************************************************************************/
		title = URLEncoder.encode("성인", "utf-8");
		result = URLEncoder.encode("가능", "utf-8");
		/**************************************************************************/
	
	}else{
		title = URLEncoder.encode("미성년자", "utf-8");
		result = URLEncoder.encode("불가능", "utf-8");
		
	}
		response.sendRedirect("responseAge_07.jsp?age=" + age + "&title="+title+"&result="+result);
	
	
	
%>