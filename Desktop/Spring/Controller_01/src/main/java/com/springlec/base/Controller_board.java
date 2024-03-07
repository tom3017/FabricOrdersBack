package com.springlec.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class Controller_board {
	// "/" -> view.jsp 출력
	@GetMapping("/view")
	public String view() {
		return "board/view";
	}

	// Model 쓰는 방식 <<대체로 이거로 사용
	@GetMapping("/content")
	public String board_content(Model model) {
		model.addAttribute("id", "park");
		model.addAttribute("age", 30);
		return "board/content";
	}

	@GetMapping("/reply")
	public ModelAndView board_reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "Lee");
		mv.addObject("age", 25);
		mv.setViewName("board/reply");
		return mv;

	}
}
