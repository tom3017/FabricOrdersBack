package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.GetExchange;

import com.springlec.base.model.BDto;
import com.springlec.base.service.BDaoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BController {
	@Autowired
	BDaoService service;
	
	// 게시판 검색
	
	@GetMapping("/")
	public String list(Model model) throws Exception {
		List<BDto> listDao = service.listDao();
		model.addAttribute("list", listDao);
		
		return "list";
	}
	@GetMapping("write_view")
	public String write_view() throws Exception{
		return "write_view";
		
	}
	@PostMapping("write")
	public String write(HttpServletRequest request) throws Exception {
		service.writeDao(request.getParameter("name"), request.getParameter("telno"), request.getParameter("email"), request.getParameter("relation"), request.getParameter("address"));
		return "redirect:/";
	}
	
	@GetMapping("content_view")
	public String updateview(HttpServletRequest request, Model model) throws Exception {
		int seqno = Integer.parseInt(request.getParameter("seqno"));
		BDto contentDao = service.contentDao(seqno);
		model.addAttribute("content_view", contentDao);
		
		return "content_view";
		
	}
	
	
	@PostMapping("update")
	public String update(HttpServletRequest request) throws Exception {
		service.updateDao(Integer.parseInt(request.getParameter("seqno")),
				request.getParameter("name"),
				request.getParameter("telno"),
				request.getParameter("address"),
				request.getParameter("email"),
				request.getParameter("relation"));
		
		return "redirect:/";
		
		
	}
	@GetMapping("delete")
	public String delete(HttpServletRequest request, Model model) throws Exception{
		service.deleteDao(Integer.parseInt(request.getParameter("seqno")));
		return "redirect:/";
		
	}
	
	//주소록 조건 검색
	
	@PostMapping("listQuery")
	public String listQuery(HttpServletRequest request, Model model) throws Exception {
		List<BDto> listDao = service.listQuery(request.getParameter("query"),request.getParameter("content"));
		model.addAttribute("list", listDao);
		return "list";
		
	}
	
	
	
	
}
