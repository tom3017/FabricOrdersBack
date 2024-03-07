<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration</h1>
	
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>User ID : </td>
				<td><input type="text" name="userid" value="${userid }" size="20" readonly="readonly"> </td>
			</tr>					
			<tr>
				<td>Password : </td>
				<td><input type="text" name="password" value="${password }" size="20" readonly="readonly"> </td>
			</tr>					
		</table>
	</form>
</body>
</html>