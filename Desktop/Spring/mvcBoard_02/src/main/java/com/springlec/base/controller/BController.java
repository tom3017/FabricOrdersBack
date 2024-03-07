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
	
	@GetMapping("write_view")
	public String write_view() throws Exception{
		return "write_view";
	}
	
	@PostMapping("write")
	public String write(HttpServletRequest request) throws Exception{
		service.writeDao(request.getParameter("bName"), request.getParameter("bContent"));
		return "redirect:/";
	}
	@GetMapping("delete")
	public String delete(HttpServletRequest request, Model model) throws Exception{
		service.deleteDao(Integer.parseInt(request.getParameter("bId")));
		return "redirect:/";
		
	}
	
}
