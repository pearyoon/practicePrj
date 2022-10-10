package com.kh.appSty06.member.service;

import java.sql.Connection;

import com.kh.appSty06.common.JDBCTemplate;
import com.kh.appSty06.member.vo.MemberVo;

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

	public MemberVo selectOne(MemberVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo loginMember = new MemberDao().selectOne(vo,conn);
		
		JDBCTemplate.close(conn);
		
		return loginMember;
	}
	
}
