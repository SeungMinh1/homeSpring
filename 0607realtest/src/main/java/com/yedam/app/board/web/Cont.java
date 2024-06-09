package com.yedam.app.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cont {
	
	
	@GetMapping("data")
	public String bod() {
		
		return "tables-data";
	}

	
	
}
