package com.kh.app.member.service;

import java.util.List;
import java.util.Map;

import com.kh.app.common.page.PageVo;
import com.kh.app.member.vo.MemberVo;

public interface MemberService {
	
	// 회원가입
	public int join(MemberVo vo);
	
	// 로그인
	public MemberVo login(MemberVo vo);
	
	// 회원조회+검색+페이징
	public List<MemberVo> selectMemberList(Map searchMap, PageVo pv);
	
	// 회원세부조회
	public MemberVo selectMemberOne(int memberNo);
	
	// 회원정보수정
	public int updateMember(MemberVo vo);
	
	// 회원탈퇴
	public int deleteMember(MemberVo vo);
	
	// 회원 수 조회
	public int selectCount();
}
