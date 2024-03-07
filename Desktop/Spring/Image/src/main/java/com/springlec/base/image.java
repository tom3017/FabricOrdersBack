package com.springlec.base;

import org.springframework.web.bind.annotation.GetMapping;

public class image {
	
	@GetMapping("/")
	public String imgae() {
		System.out.println("선유");
		return "index";
	}
	
	
}
