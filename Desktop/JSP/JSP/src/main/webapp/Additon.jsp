<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Addition</title>
	</head>
	<body>
		<%
			int a = 2;
			int b = 20;
			int add = a + b;
			int sub = a - b;
			int mul = a * b;
			int div = a / b;
			
			for(int i = 2; i <= 9; i++){
				out.print(a + "X" + i + "=" + (a*i) + "<br>");
			}
			
			
			
			
		%>
		<%=a %> + <%=b %> = <%=add %><br>
		<%=a %> - <%=b %> = <%=sub %><br>
		<%=a %> * <%=b %> = <%=mul %><br>
		<%=a %> / <%=b %> = <%=div %><br>
		<!--  -->
		<%
			int sum = 0;
			for(int i = 1; i <= 100; i++){
				sum = (sum + i);  
			}
			out.print("1 + 2 + 3 + ..... + 99 + 100 =" + sum);
		
		%>
		
		
		
		
		
		
	</body>
</html>