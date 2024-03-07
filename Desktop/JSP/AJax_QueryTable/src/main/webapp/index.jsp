<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX MySQL Table Query</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="queryTable.js"></script>
</head>
<body>
	<h2>AJAX MySQL Table Query</h2>
	<input type="text" id="name" placeholder="성명 입력">
	<button id="queryButton">검색</button>
	
	<!-- js 가 만들어 주는 부분 -->
	<div id="result"></div>
</body>
</html>