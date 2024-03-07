package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.service.annotation.GetExchange;

import com.springlec.base.model.MDto;
import com.springlec.base.service.MDaoService;

@Controller
public class MController {
	@Autowired
	MDaoService service;
	
	//게시판 검색
	
	@GetExchange("/")
	public String list(Model model) throws Exception {
		List<MDto> listdao = service.listDao();
		model.addAttribute("list", listdao);
		
		return "list";
	}
}
