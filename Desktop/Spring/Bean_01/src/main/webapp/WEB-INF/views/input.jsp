<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계산기</h3>
	<form action="addCalc" method="post">
		<table border="1">
			<tr>
				<td>첫번째숫자 :</td>
				<td><input type="text" name="num1" size="10"></td>
			</tr>
			<tr>
				<td>두번째숫자 :</td>
				<td><input type="text" name="num2" size="10"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="계산"></td>
			</tr>


		</table>



	</form>
</body>
</html>