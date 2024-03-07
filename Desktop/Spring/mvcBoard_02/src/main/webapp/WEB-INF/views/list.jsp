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
			<td>번호</td>
			<td>작성자</td>
			<td>내용</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td><a href="content_view?bId=${dto.bId}">${dto.bContent}</a></td>
			<td><a href = "delete?bId=${dto.bId}">X</a></td>
		</tr>
		</c:forEach>
		
		
	</table>
			<a href="write_view">글작성</a>


</body>
</html>