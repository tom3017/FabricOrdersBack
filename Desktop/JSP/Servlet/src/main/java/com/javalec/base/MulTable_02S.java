package com.javalec.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MulTable_02S
 */
@WebServlet("/MulTable_02S")
public class MulTable_02S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MulTable_02S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(request.getParameter("num1"));
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>" + num1 + "단 -결과화면");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		for(int j = 0; j <3; j++) {
			for(int i = 1; i<=9; i++) {
				out.print((num1 + j) + "X" + i + "=" + ((num1 + j) * i));
			
				
			
			}
			out.print("<br>");
		}
			
		out.print("</body>");
		
		out.print("</html>");
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
