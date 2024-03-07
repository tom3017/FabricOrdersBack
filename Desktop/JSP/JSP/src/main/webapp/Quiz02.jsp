<%@page import="java.lang.StackWalker.Option"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<form action="requestQuiz.jsp" method="post">
			num1 : 
			<select name="num1">
								<% 
					for(int i = 1; i<=100; i++){
					out.print("<Option value ="+ i + ">"+ i +"</Option>");
					}
				%>
			</select><br>
			num2 : 
			<select name="num2">
				<% 
					for(int i = 1; i<=100; i++){
					out.print("<Option value ="+ i + ">"+ i +"</Option>");
					}
				%>
			</select><br>
			계산방법 :
			<input type = "radio" name = "Math" value="add" checked="checked"> 덧셈 
			<input type = "radio" name = "Math" value="sub"> 뺄셈
			<input type = "radio" name = "Math" value="mul"> 곱셈
			<input type = "radio" name = "Math" value="div"> 나눗셈
			
			<input type="submit" value="계산">
			
		</form>
		
	</body>
</html>