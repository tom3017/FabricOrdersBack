<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h2>수정</h2>
	<form action="content.do" method="post">
		<table border="0">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="20" value="${bName }"> </td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" value="${bTitle }"> </td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name ="bContent" rows="10" cols="50" value="${bContent }"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="수정"><a href="list.do">목록보기</a>
			</tr>
		</table>
	</form>
</body>
</html>