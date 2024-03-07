package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class Controller_01 {
	@GetMapping("/view")
	public String view() {
		return "board/view";
	}
}
