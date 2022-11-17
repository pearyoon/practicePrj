package com.kh.app.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	public int join(MemberVo vo) {
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		int result = new MemberDao().join(ss,vo);
		
		return result;
	}

}
