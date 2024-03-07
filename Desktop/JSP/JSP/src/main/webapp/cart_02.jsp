<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 선택 저장 결과</title>
</head>
<body>

	<%
			request.setCharacterEncoding("utf-8");
			String qty = request.getParameter("quantity");
			String size = request.getParameter("size");
			String color = request.getParameter("color");
			
			String filename = "info.txt";
			
			PrintWriter writer = null;
			String result;
			
			
			
			
			try{
				String filePath = application.getRealPath("/" + filename);
				
				writer = new PrintWriter(filePath);
				writer.println("수량 :" + qty);
				writer.println("크기 :" + size);
				writer.println("색상 :" + color);
				
				out.print("저장이 되었습니다.");
				
				
				result = "success";
				
				
				
			}catch(IOException ioe){
				result = "fail";
				
			}finally{
				try{
					writer.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			response.sendRedirect("cart_03.jsp?result=" + result);
		
		
		
		
		
		%>
	



</body>
</html>