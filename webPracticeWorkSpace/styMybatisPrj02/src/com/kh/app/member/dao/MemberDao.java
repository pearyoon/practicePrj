package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public int join(MemberVo vo, SqlSession ss) {

		return ss.insert("member-mapper.join",vo);
	}

	public MemberVo selectOne(MemberVo vo, SqlSession ss) {
		
		return ss.selectOne("member-mapper.selectOne",vo);

	}

}
