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
	<form action="requestQuiz03.jsp" method="post">
			키(cm) : <input type="text" name="height" size="3" ><br>
			kg : <input type="text" name="weight" size="3"><br>
			<input type="submit" value="Calc BMI">
			
		</form>
		
	</body>
</html>