<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 선택</title>
</head>
<body>
    <form action="cart_02.jsp" method="post">
        수량 : <input type="text" name="quantity"><br>
        크기 : <input type="radio" name="size" value="대" checked="checked"> 대
              <input type="radio" name="size" value="중"> 중
              <input type="radio" name="size" value="소"> 소<br>
        색상 :<select name="color">
                <option>베이지</option>
                <option>브라운</option>
                <option>카키</option>
            </select><br>
        <input type="submit" value="저장">
	
    </form>
</body>
</html>
