package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	// 게시글 목록
	@GetMapping("/board/list")
	public String getBoardList() {
		
		// service
		List<BoardVo> voList = service.getBoardList();
		System.out.println(voList);
		
		return "board/list";
	}
	
}