<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1부터 100 까지의 합은 <%=request.getAttribute("result") %> <br>
	1부터 100 까지의 합은 ${result } 입니다. <br> 
	100부터 200 까지의 합은 ${result2} 입니다.
</body>
</html>