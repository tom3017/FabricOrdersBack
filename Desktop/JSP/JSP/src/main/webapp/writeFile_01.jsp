<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<h2>Write File</h2>
	<form action="writeFile_02.jsp" method="post">
		이름 : <input type="text" name="name">
		제목 : <input type="text" name="title">
		<textarea rows="5" cols="30"></textarea>
		<input type="submit" value="저장">
		<%
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			String filename = "file.txt";
			
			PrintWriter writer = null;
			String result;
			
			
			
			
			try{
				String filePath = application.getRealPath("/" + filename);
				
				writer = new PrintWriter(filePath);
				writer.println("제목 :" + title);
				writer.println("글쓴이 :" + name);
				writer.println(content);
				
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
			
			response.sendRedirect("writeFile_03.jsp?result=" + result);
		
		
		
		
		
		%>
		
		
		
		
		
		
	
	
	
	</form>