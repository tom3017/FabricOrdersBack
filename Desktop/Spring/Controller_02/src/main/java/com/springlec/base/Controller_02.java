package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Controller_02 {
		@GetMapping("/view")
		public String view2() {
			return "test/view";
		}
	}
