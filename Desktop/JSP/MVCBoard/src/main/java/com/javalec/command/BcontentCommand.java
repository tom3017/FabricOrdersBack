package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.dao.BDao;
import com.javalec.dto.BDto;

public class BcontentCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// write_view.jsp의 request 를 받아서 Table에 insert 한다.
		BDao dao = new BDao(); 
		BDto view = dao.infomation(request.getParameter("bId"));
		String bName = view.getbName();
		String bTitle = view.getbTitle();
		String bContent = view.getbContent();
		
		
		request.setAttribute("infomation_bName", bName);
		request.setAttribute("infomation_bTitle", bTitle);
		request.setAttribute("infomation_bContent", bContent);
		 
	}
}
