package com.javalec.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.command.BCommand;
import com.javalec.command.BListCommand;
import com.javalec.command.BWriteCommand;
import com.javalec.command.BcontentCommand;
import com.javalec.command.SsignInsertCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// Session
		
		HttpSession session = request.getSession();

		BCommand command = null;
		String viewPage = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {
		case ("/list.do"):
			session.setAttribute("test", "AAA");
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
		case ("/write_view.do"):
			viewPage = "write_view.jsp";
			break;
		case("/write.do"):
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;
		case("/content_view.do"):
			viewPage = "content_view.jsp";
			break;
		case("/content.do"):
			command = new BcontentCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;
		case("/sign.do"): // 회원 가입 페이지
//			command.execute(request, response);
			viewPage ="sign.jsp";
			break;
		case("/signInsert.do"):
			command = new SsignInsertCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;
			
		default:
			break;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);

	} // actionDo()

}// End
