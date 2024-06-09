package com.yedam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class Cont {
	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}

}