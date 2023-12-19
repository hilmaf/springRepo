package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	// 게시글 목록(화면)
	@GetMapping("/list")
	public String selectBoardList() {
		return "board/list";
	}
	
	// 게시글 작성(화면)
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	// 게시글 작성(처리)
	@PostMapping("/write")
	public String write(BoardVo vo) {
		// data
		
		// service
		int result = 1;
		
		// result
		if(result == 1) {
			return "board/list";
		} else {
			return "error";
		}
	}
	
	// 게시글 수정(화면)
	
	// 게시글 수정(처리)
	
	// 게시글 삭제(처리)
	
	// 게시글 상세조회(화면)
}
