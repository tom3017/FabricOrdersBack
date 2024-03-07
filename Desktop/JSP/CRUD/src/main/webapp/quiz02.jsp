<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<script type="text/javascript">
		function checkLogin() {

			    let form = document.loginForm

			    form.submit()
			    return true; // 폼이 전송되어야 하는 경우 true 반환
			}
	</script>
	<body>
		<h2>아래의 항목을 입력후 확인 버튼을 누르세요!</h2><br>
		
		<form name="loginForm" action="quiz03.jsp" method="post">
			
			성명 : <input type="text" name="name" size="10"><br>
			전화번호 : <input type="text" name="tel" size="20"><br>
			주소 : <input type="text" name="address" size="30"><br>
			전자우편 : <input type="text" name="email" size="30"><br>
			관계 : <input type="text" name="relation" size="30"><br>
			<input type="button" value="확인" onclick="checkLogin()">
			
		</form>
		
	</body>
</html>