<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>log In</h1>
	
	<form action="loginCheck" method="post">
		<table border="1">
			<tr>
				<td>User ID : </td>
				<td><input type="text" name="userid" size="20"> </td>
			</tr>					
			<tr>
				<td>Password : </td>
				<td><input type="password" name="password" size="20"> </td>
			</tr>					
			<tr>
				<td colspan="2"><input type="submit" value="Log In"> </td>
			</tr>					
		</table>
	</form>
</body>
</html>