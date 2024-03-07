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
			    let regExpName = /^[가-힣]+$/
			    let regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		    	let regExpAddress = /^[가-힣0-9\s]+$/

			    let form = document.loginForm

			    let id = form.userid.value.trim()
			    let name = form.name.value.trim()
			    let phone = form.phone.value.trim()
			    let address = form.address.value.trim()

			    // 빈 필드 검사
			    if (id === '' || name === '' || phone === '' || address === '') {
			        alert("모든 필드를 입력해주세요.")
			        return false; // 폼 전송을 중지하기 위해 false를 반환합니다.
			    }

			    if (!regExpId.test(id)) {
			        alert("ID는 영문 또는 한글만 입력해주세요.")
			        form.userid.select()
			        return false;
			    }
			    if (!regExpName.test(name)) {
			        alert("성명은 한글만 입력해주세요.")
			        form.name.select()
			        return false;
			    }
			    if (!regExpPhone.test(phone)) {
			        alert("전화번호는 자릿수를 체크해주세요")
			        form.phone.select()
			        return false;
			    }
			    if (!regExpAddress.test(address)) {
			        alert("주소는 한글과 숫자만 입력해주세요")
			        form.address.select()
			        return false;
			    }

			    form.submit()
			    return true; // 폼이 전송되어야 하는 경우 true 반환
			}
	</script>
	<body>
		<h2>아래의 항목을 입력후 확인 버튼을 누르세요!</h2><br>
		
		<form name="loginForm" action="insert02.jsp" method="post">
			
			사용자 ID : <input type="text" name="userid" size="10"><br>
			성명 : <input type="text" name="name" size="10"><br>
			전화번호 : <input type="text" name="phone" size="20"><br>
			주소 : <input type="text" name="address" size="30"><br>
			<input type="button" value="확인" onclick="checkLogin()">
			
		</form>
		
	</body>
</html>