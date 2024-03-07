<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX MySQL Table Update</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="Update.js"></script>
</head>
<body>
	<h2>AJAX MySQL Table Update</h2>
	<input type="text" id="name" placeholder="성명 입력">
	<button id="queryButton">검색</button>
	<div id="result"></div>
	<br>
	<div>
	
		학번 : <input type="text" id="scode" ><br>
		성명 : <input type="text" id="sname"><br>
		학과 : <input type="text" id="sdept"><br>
		전화번호 : <input type="text" id="sphone"><br>
		주소 : <input type="text" id="saddress"><br>
	
	</div>
	<br>
	<button type="button" id="submitBtn">수정</button>
	<button type="button" id="insertBtn">입력</button>
	<button type="button" id="deleteBtn">삭제</button>
</body>
</html>