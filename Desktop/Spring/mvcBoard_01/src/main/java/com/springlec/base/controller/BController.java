package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.model.BDto;
import com.springlec.base.service.BDaoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BController {
	
	@Autowired
	BDaoService service;
	
	
	
	// 게시판 검색
	@GetMapping("/")
	public String list(Model model) throws Exception{
		List<BDto> listDao = service.listDao();
		model.addAttribute("list", listDao);
		
		return "list";
		
	}
	// 게시판 입력 화면
	
	@GetMapping("write_view")
	public String writeview() throws Exception {
		return "write_view";
	}
	
	//게시판 입력 실행
	@PostMapping("write")
	public String write(HttpServletRequest request) throws Exception {
		service.writeDao(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"));
		return "redirect:/";
		
	}
	
	@GetMapping("content_view")
	public String updateview(HttpServletRequest request, Model model) throws Exception {
		int bId = Integer.parseInt(request.getParameter("bId"));
		BDto contentDao = service.contentDao(bId);
		model.addAttribute("content_view", contentDao);
		
		
		return "content_view";
		
	}
	@PostMapping("update")
	public String update(HttpServletRequest request) throws Exception{
		service.updateDao(Integer.parseInt(request.getParameter("bId")),
						  request.getParameter("bName"),
						  request.getParameter("bTitle"),
						  request.getParameter("bContent"));
		return "redirect:/";
		
	}
	
	@GetMapping("delete")
	public String delete(HttpServletRequest request, Model model) throws Exception{
		service.deleteDao(Integer.parseInt(request.getParameter("bId")));
		return "redirect:/";
		
	}
	
	
	
}
