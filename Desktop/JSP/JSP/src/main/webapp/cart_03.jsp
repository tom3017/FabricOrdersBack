<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 선택 저장 결과</h1>


<%
	

	String str = request.getParameter("result");
	if(str.equals("success")){
		out.print("저장 되었습니다.");
	}else{
		out.print("저장되지 않았습니다.");
	}
	
%>
	  <form action="cartRead_04.jsp" method="post">
	<input type="submit" name="save" value="저장결과 불러오기">
	</form>

</body>
</html>