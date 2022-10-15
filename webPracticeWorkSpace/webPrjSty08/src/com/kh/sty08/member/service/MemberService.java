package com.kh.sty08.member.service;

import java.sql.Connection;

import static com.kh.sty08.common.JDBCTemplate.*;
import com.kh.sty08.member.dao.MemberDao;
import com.kh.sty08.member.vo.MemberVo;

public class MemberService {
	private static final MemberDao dao = new MemberDao();
	public int join(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.join(conn,vo);
		
		if(result != 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	public MemberVo selectOne(MemberVo vo) {
		
		Connection conn = getConnection();
		
		MemberVo loginMember = dao.selectOne(conn, vo);
		
		close(conn);
		
		return loginMember;
	}

}
