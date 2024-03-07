package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.service.TDaoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TController {
	@Autowired
	TDaoService service;

	@GetMapping("/")
	public String menu() throws Exception {
		return "input";

	}

	@PostMapping("write")
	public String write(HttpServletRequest request, Model model) throws Exception {
		service.writeDao(request.getParameter("id"), request.getParameter("product"));
//		service.writeDao2(request.getParameter("id"));
		return "complete";
		
	}
}