package com.kh.member.service;

import java.sql.Connection;

import com.kh.member.common.JDBCTemplate;
import com.kh.member.dao.MemberDao;
import com.kh.member.vo.MemberVo;

public class MemberService {

	public int join(MemberVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().join(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public MemberVo login(MemberVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo loginMem = new MemberDao().login(vo,conn);
		
		JDBCTemplate.close(conn);
		
		return loginMem;
	}
	
}
