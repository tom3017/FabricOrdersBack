package com.javalec.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CharacterTest_01S
 */
@WebServlet("/CharacterTest_01S")
public class CharacterTest_01S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterTest_01S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] food = request.getParameterValues("food");
		PrintWriter out = response.getWriter();
		
		
		
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>" + "성격테스트");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>성격 테스트</h1><br><br>");
		out.print(name + "님의 성격 테스트 결과<br><br>");
		out.print(color + "을(를) 좋아하는 당신은 " + animal);
		if(food == null) {
			out.print("을(를) 좋아하며 중식집 메뉴는 좋아하지 않는 성격입니다.");
		}else {
			out.print(" 그리고 ");
			for(int i=0; i<food.length-1; i++) {
				out.print(food[i] + "과(와) ");
			}
			out.print(food[food.length-1]);
			out.print("을(를) 좋아하는 성격입니다.");
		}
		out.print("<br><br>--------------------------<br>");
		out.print("저장 되었습니다!");
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
