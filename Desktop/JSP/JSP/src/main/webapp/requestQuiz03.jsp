<%@page import="java.util.Arrays"%>
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
				int height;
				double height1;
				double weight;

				
				
				request.setCharacterEncoding("utf-8");
				
				height = Integer.parseInt(request.getParameter("height"));
				weight = Integer.parseInt(request.getParameter("weight"));
				
				height1 = height / 100.0;
				double result = (double) weight / (height1 * height1);
				out.print("키는" + height1 +"이고<br>");
				out.print("입력한 몸무게는" + weight + "이므로<br>"); 
				
				if(result <= 18.5){
					out.print("당신의 BMI 수치는" +String.format("%.2f", result)+ "입니다.<br>");
					out.print("결과는 저체중 입니다.<br>");%>
					<p><img alt="저체중" src="underweight.png"></p>
				<%}else if(result <= 23){
					out.print("당신의 BMI 수치는" +String.format("%.2f", result)+ "입니다.<br>");
					out.print("결과는 정상 입니다<br>");%>
					<p><img alt="정상" src="nomal.png"></p>
					
				<%}else if(result <= 25){
					out.print("당신의 BMI 수치는" +String.format("%.2f", result)+ "입니다.<br>");
					out.print("결과는 과체중 입니다");%>
					<p><img alt="과체중" src="obaseweight.png"></p>
				 <%}else{
					out.print("당신의 BMI 수치는" +String.format("%.2f", result)+ "입니다.<br>");
					out.print("결과는 비만 입니다<br>");
				}%>
					<p><img alt="저체중" src="overweight.png"></p>					
				
				
			
			
				
	</body>
</html>