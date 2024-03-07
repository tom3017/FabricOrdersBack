package com.javalec.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sum100_01S
 */
@WebServlet("/Sum100_01S")
public class Sum100_01S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sum100_01S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int total = 0;
		int total2 = 0;
		
		for(int i = 1; i <= 100; i ++) {
			total += i;
		}
		
		request.setAttribute("result", total);
		
		
		for(int j = 100; j <= 200; j++) {
			total2 += j;
		}
		
		request.setAttribute("result2", total2);
		
		RequestDispatcher rd2 = request.getRequestDispatcher("sum100_01.jsp");
		
		rd2.forward(request, response);
		
	}

}
