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
				int num1, num2, result;
				String math;
				
				request.setCharacterEncoding("utf-8");
				
				num1 = Integer.parseInt(request.getParameter("num1"));
				num2 = Integer.parseInt(request.getParameter("num2"));
				math = request.getParameter("Math");
				
				if(math.equals("add")){
					result = num1 + num2;
					out.print("두수" +num1+ "와" +num2+"의 <br>합은" +(double)result+ "입니다.");
				}else if(math.equals("sub")){
					result = num1 - num2;
					out.print("두수" +num1+ "와" +num2+"의 <br>뺄셈은" +(double)result+ "입니다.");
				}else if(math.equals("mul")){
					result = num1 * num2;
					out.print("두수" +num1+ "와" +num2+"의 <br>곱은" +(double)result+ "입니다.");
				}else if(math.equals("div")){
					result = num1 / num2;
					out.print("두수" +num1+ "와" +num2+"의 <br>나눗셈은" +(double)result+ "입니다.");
				}else{
					result = 0;
				}
				
			%>
	</body>
</html>