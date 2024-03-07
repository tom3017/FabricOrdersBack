<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC 게시판</title>
</head>
<body>
	<h1>게시판 검색</h1>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td bgcolor="#808080">영화 이미지</td>
			<td bgcolor="#808080">영화 제목</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.title}</td>
		</tr>
		</c:forEach>
		<tr>
		</tr>
	</table>


</body>
</html>