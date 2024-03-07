package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.service.CalcService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AController {
	
	@Autowired
	CalcService service;
	
	
	//계산 입력 화면
	
	@GetMapping("/")
	public String input() throws Exception {
		System.out.println(">>> input()");
		return "input";
	}
	@PostMapping("addCalc")
	public String calc(HttpServletRequest request, Model model) throws Exception {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		
		int result1 = service.addition(num1, num2);
		int result2 = service.subtraction(num1, num2);
		int result3 = service.Multiplication(num1, num2);
		double result4 = service.division(num1, num2);
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("addition", result1);
		model.addAttribute("subtraction", result2);
		model.addAttribute("Multiplication", result3);
		model.addAttribute("division", result4);
		
		return "calcResult";
		
	
	}
	
	
	
	
	
	
}
