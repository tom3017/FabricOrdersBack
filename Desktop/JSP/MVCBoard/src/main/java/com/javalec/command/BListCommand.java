package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.dao.BDao;
import com.javalec.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// Dao 로 요청해서 Dto를 생성한다.
		
		HttpSession session = request.getSession();
		
		BDao dao = new BDao();
		
		ArrayList<BDto> dtos = dao.list();
		request.setAttribute("list", dtos);
		
	
	}

}
