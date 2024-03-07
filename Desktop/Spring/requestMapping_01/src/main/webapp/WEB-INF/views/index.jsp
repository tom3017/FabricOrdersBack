<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Get<br>
	
	<form action="studentGet" method="get">
		student id : <input type="text" name="id">
		<input type="submit" value = "전송">
	
	</form>
	
	
	Post<br>
	
	<form action="studentPost" method="post">
		student id : <input type="text" name="id">
		<input type="submit" value = "전송">
	
	</form>
	
</body>
</html>