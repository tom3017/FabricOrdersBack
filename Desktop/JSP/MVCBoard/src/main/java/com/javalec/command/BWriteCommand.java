package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// write_view.jsp의 request 를 받아서 Table에 insert 한다.
		 String bName = request.getParameter("bName");
		 String bTitle = request.getParameter("bTitle");
		 String bContent = request.getParameter("bContent");
		
		 BDao dao = new BDao();
		 dao.write(bName, bTitle, bContent);
		 
	
	}

}
