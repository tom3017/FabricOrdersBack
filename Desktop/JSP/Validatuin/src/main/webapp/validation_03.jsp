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
			if(form.id.value == ""){
				alert("아이디를 입력해 주세요.")
				form.id.focus()
				return false
			}
			if(form.id.value.length <4 || form.id.value.length > 12){
				alert("아이디는 4~12자 이내로 입력 가능합니다.")
				form.id.select()
				return
				
				
			}
				
		//아이디는 영문 소문자만 입력 가능
			for(i = 0; i < form.id.value.length; i++){
				let ch = form.id.value.charAt(i)
				if((ch<'a' || ch>'z') && (ch >'A' || ch <'Z')&&(ch>'0' || ch<'9')){	
				alert("아이디는 영문 소문자만 입력 가능합니다.")
				form.id.select()
				return
				}
			}
			
				
			if (form.passwd.value.length < 4 ){
				alert("비밀번호를 4자 이상으로 입력 가능합니다.")
				form.passwd.select()
				return
				
			}
			
		//비밀번호는 숫자만 입력 가능합니다.
			for(i = 0; i < form.passwd.value.length; i++){
				let chPasswd = form.passwd.value.charAt(i)			
				if(isNaN(chPasswd))
				alert("비밀번호는 숫자만 입력 가능합니다.")
				form.id.select()
				return
			}
			
			
			
			form.submit()
		}
	</script>
	<body>
		<form name = "loginForm" action="validation_process.jsp" method="post">
			아이디 : <input type="text" name = "id"> <br>
			비밀번호 : <input type="password" name = "passwd"> <br>
			<input type="button" value="OK" onclick = "checkLogin()">
		</form>
		
	</body>
</html>