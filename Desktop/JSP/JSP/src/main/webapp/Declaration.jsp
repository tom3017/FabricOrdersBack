<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Declaration </title>
	</head>
	<body>
	
<%-- 	<%! 
	
	public int sum(int num1, int num2){/* <%!> 사용 할일은 메소드를 작성 할때 사용한다. */
		return num1 + num2;
	}
	%>
	
	
	
	<%
	
	out.print("sum = " + sum(12,13)+"<br>");
	
	
	%>
	
	12 + 13 = <%=sum(12, 13) %>	 --%>
	
	<%!
	
	public int suq(int a, int b, int c){
		for(int i = 0; i <= b; i++){
			c = a * i;
			
		}
		
		return c; 
	}
	
	%>
	
	
	
	
	
	
	
	</body>
</html>