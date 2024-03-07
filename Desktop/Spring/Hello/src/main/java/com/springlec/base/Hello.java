package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
	
	@GetMapping("/")
	public String hello() {
		System.out.println("Hello world");
		return "index";
	}
	
}
