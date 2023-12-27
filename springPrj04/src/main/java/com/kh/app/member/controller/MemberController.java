package com.kh.app.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor

public class MemberController {
	
	
	private final MemberService service;

	// 회원가입
	@PostMapping("join")
	public String join(MemberVo vo) throws Exception {
		// service
		int result = service.join(vo);
		// result == view
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/member/login";
	}
	
	// 로그인
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession session) throws Exception {
		// service
		MemberVo loginMember = service.login(vo);
		// result == view
		if(loginMember==null) {
			throw new Exception("일치하는 회원정보 없음");
		}
		
		session.setAttribute("loginMember", loginMember);
		session.setAttribute("alertMsg", "로그인 성공");
		
		System.out.println(loginMember);
		
		return "redirect:/home";
	}
	
	// 회원 정보 수정(비밀번호, 닉네임)
	@PostMapping("edit")
	public String edit(MemberVo vo) throws Exception {
		int result = service.edit(vo);
		
		if(result != 1) {
			throw new Exception();
		}
		
		return "redirect:/home";
	}
	
	// 회원 탈퇴
	@GetMapping("quit")
	public String quit() {
		return "";
	}
	
	// 전체 회원 목록 조회(관리자 전용)
	@GetMapping("list")
	public String list(Model model) {
		List<MemberVo> voList = service.list();
		
		model.addAttribute("memberVoList", voList);
		
		return "member/list";
	}

	
}
