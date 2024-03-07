<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    사용자 ID : <%=session.getAttribute("userid") %><br>
    성명 : <%=session.getAttribute("name") %><br>
    전화번호 : <%=session.getAttribute("tel") %><br>
    주소 : <%=session.getAttribute("address") %><br>
    
    <%
    session.invalidate();
    
    %>
    
    상기의 정보로 입력되었습니다. 감사합니다.
    
</body>
</html>