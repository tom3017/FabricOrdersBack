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
			let regExpId = /^[a-zA-Z가-힣]+$/

			    let form = document.loginForm

			    let id = form.userid.value.trim()

			    // 빈 필드 검사
			    if (!regExpId.test(id)) {
			        alert("ID는 영문 또는 한글만 입력해주세요.")
			        form.userid.select()
			        return false;
			    }

			    form.submit()
			    return true; // 폼이 전송되어야 하는 경우 true 반환
			}
	</script>
	<body>
		<h2>아래의 항목을 입력후 확인 버튼을 누르세요!</h2><br>
		
		<form name="loginForm" action="update02.jsp" method="post">
			
			사용자 ID : <input type="text" name="userid" size="10"><br>
			<input type="submit" value="확인" onclick="checkLogin()">
			
		</form>
		
	</body>
</html>