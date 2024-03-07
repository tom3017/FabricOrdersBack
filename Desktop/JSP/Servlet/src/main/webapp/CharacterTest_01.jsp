<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="CharacterTest_01S" method="post">
		<h1>성격 테스트</h1>
		당신의 성격을 테스트 합니다. 데이터를 입력한 후 확인 버튼을 눌러주세요.<br>
		이름은? 
			<input type="text" name="name"><br>
		좋아하는 색은?
			<input type="radio" name="color" value="노랑" checked="checked">노랑
			<input type="radio" name="color" value="빨강">빨강
			<input type="radio" name="color" value="파랑">파랑<br>
		좋아하는 동물은?<select name="animal">
                <option>거북이</option>
                <option>사자</option>
                <option>호랑이</option>
            </select><br>
        좋아하는 음식은?
       		<input type="checkbox" name="food" value="짜장면">짜장면
       		<input type="checkbox" name="food" value="짬뽕">짬뽕
       		<input type="checkbox" name="food" value="탕수육">탕수육<br>
       		<input type="submit" value="확인">
			
			
		</form>
	
	</body>
</html>