package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;


@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//전체조회
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	//단건조회
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.boardInfo(boardVO);
		model.addAttribute("board", findVO);
		return "board/boardInfo";
	}
	
	//등록-페이지
	@GetMapping("boardInsert")
	public String boardInsertForm(Model model) {
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardInsert";
	}
	
	//등록-처리
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO baordVO) {
		boardService.boardInsert(baordVO);
		return "redirect:boardList";
	}
	
	//수정-페이지
	@GetMapping("boardUpdate")
	public String boardUpdateForm(Integer bno, Model model) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(bno);
		
		BoardVO findVO = boardService.boardInfo(boardVO);
		model.addAttribute("board", findVO);
		return "board/boardUpdate";
	}
	
	//수정-처리
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(@RequestBody BoardVO baordVO) {
		return boardService.boardUpdate(baordVO);
	}
	
	
	
	//삭제
	@GetMapping("boardDelete")
	public String boardDelete(BoardVO boardVO) {
		
		boardService.boardDelete(boardVO.getBno());
		
		return "redirect:boardList";
	}
	
	
}
