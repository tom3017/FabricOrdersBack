<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis 주소록 리스트</title>
</head>
<body>
	<h1>MyBatis 주소록 리스트 조건 검색</h1>
	<form action="listQuery" method="post">
	검색 선택 : 
	<select name="query">
		<option value="NAME">이름</option>
		<option value="TELNO">전화번호</option>
		<option value="ADDRESS">주소</option>
		<option value="RELATION">관계</option>
	</select> &nbsp;&nbsp;&nbsp;
	<input type="text" name="content" size="30">
	<input type="submit" value="검색">
	</form>
	<table width="500" cellpadding="0" cellspacing="0" border="2">
		<tr>
			<th bgcolor="#808080">번호</th>
			<th bgcolor="#808080">이름</th>
			<th bgcolor="#808080">전화번호</th>
			<th bgcolor="#808080">주소</th>
			<th bgcolor="#808080">전자우편</th>
			<th bgcolor="#808080">관계</th>
		</tr>
		<tr>
		<c:set var="cnt" value="0"/>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><a href="content_view?seqno=${dto.seqno}">${dto.seqno}</a></td>
			<td>${dto.name}</td>
			<td>${dto.telno}</td>
			<td>${dto.email }</td>
			<td>${dto.relation}</td>
			<td>${dto.address}</td>
		</tr>
		<c:set var="cnt" value="${cnt=cnt+1 }"/>
		</c:forEach>
	</table>
	<br><br>
	<p>검색 결과는 <b>${cnt }</b>명 입니다.</p>
		<tr>
			<td colspan="5"> <a href="write_view">주소록 등록</a> </td>
		</tr>


</body>
</html>