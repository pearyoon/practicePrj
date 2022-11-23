package com.kh.app.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.common.page.PageVo;
import com.kh.app.member.vo.MemberVo;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int join(SqlSession ss, MemberVo vo) {
		return ss.insert("memberMapper.join",vo);
	}

	@Override
	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("memberMapper.login",vo);
	}

	@Override
	public List<MemberVo> selectMemberList(SqlSession ss, Map searchMap, PageVo pv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo selectMemberOne(SqlSession ss, int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(SqlSession ss, int memberNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(SqlSession ss, MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
