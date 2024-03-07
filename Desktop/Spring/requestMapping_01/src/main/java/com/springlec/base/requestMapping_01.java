package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class requestMapping_01 {
	
	@GetMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@GetMapping("studentGet")
	public String goStudentId(@RequestParam("id") String id, Model model) {
//		model.addAttribute("id", id);
//		return "student/studentId";
		if(id.equals("abc")) {
			return "redirect:studentOK";
		}
			return "redirect:studentNG";
		
		
		
		
	}
	
	
	@PostMapping("studentPost")
	public String goStudentPost(@RequestParam("id") String id, Model model) {
		if(id.equals("abc")) {
			return "redirect:studentOK";
		}
			return "redirect:studentNG";
		
	}
	
	
	
	@GetMapping("studentOK")
	public String studentOK() {
		return "student/studentOK";
	}
	
	
	
	@GetMapping("studentNG")
	public String studentNG() {
		return "student/studentNG";
	}
	
}
