package com.kh.app.member.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.app.common.db.JDBCTemplate.*;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	private static final MemberDao dao = new MemberDao();
	public int join(MemberVo vo) {
		SqlSession ss = getSqlSession();
		
		int result = dao.join(vo,ss);
		
		if(result==1) {
			ss.commit();
		}
		
		ss.close();
		
		return result;
	}

	public MemberVo selectOne(MemberVo vo) {
		SqlSession ss = getSqlSession();
		
		MemberVo loginMem = dao.selectOne(vo,ss);
		
		ss.close();
		
		return loginMem;
	}

}
