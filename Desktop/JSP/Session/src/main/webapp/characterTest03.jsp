<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		request.setCharacterEncoding("utf-8");
		String food = request.getParameter("animal");
		session.setAttribute("ANIMAL", "animal");
	%>
		당신은 <%=session.getAttribute("FOOD") %> 와
		<%=session.getAttribute("ANIMAL") %>을 좋아하는 성격입니다.
		
		<% session.invalidate(); %><!-- 세선을 안쓸경우에 쓰는 코드 이걸 안쓰면 서버에 저장 값이 남아있음 -->
	
	
	
	
	
	
	
	
	
	
	
	</body>
</html>