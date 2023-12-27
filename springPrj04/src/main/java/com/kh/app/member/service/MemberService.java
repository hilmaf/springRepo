package com.kh.app.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class MemberService {

	private final MemberDao dao;
	private final SqlSessionTemplate sst;
	
	public int join(MemberVo vo) throws Exception {
		// business logic
		String id = vo.getId();
		if(id != null & id.length() < 4) {
			throw new Exception("아이디는 4자 이상이어야 합니다.");
		}
		
		if(id != null && id.equalsIgnoreCase("admin")) {
			throw new Exception("아이디는 admin일 수 없습니다.");
		}
		
		return dao.join(sst, vo);
	}

	public MemberVo login(MemberVo vo) {
		// business logic
		
		return dao.login(sst, vo);
	}

	public List<MemberVo> list() {
		return dao.list(sst);
	}

	public int edit(MemberVo vo) {
		// business logic
		
		return dao.edit(sst, vo);
	}

}
