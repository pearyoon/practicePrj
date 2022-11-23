package com.kh.app.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.common.page.PageVo;
import com.kh.app.member.vo.MemberVo;

public interface MemberDao {
	// 회원가입
	public int join(SqlSession ss ,MemberVo vo);
	
	// 로그인
	public MemberVo login(SqlSession ss, MemberVo vo);
	
	// 회원조회 + 검색 + 페이징
	public List<MemberVo> selectMemberList(SqlSession ss, Map searchMap, PageVo pv);
	
	// 회원세부조회
	public MemberVo selectMemberOne(SqlSession ss, int memberNo);
	
	// 회원수정
	public int updateMember(SqlSession ss, int memberNo);
	
	// 회원탈퇴
	public int updateMember(SqlSession ss, MemberVo vo);
}
