package com.kh.appSty07.member.service;

import static com.kh.appSty07.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.appSty07.member.dao.MemberDao;
import com.kh.appSty07.member.vo.MemberVo;

public class MemberService {
	
	private static final MemberDao dao = new MemberDao();
	
	public int join(MemberVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.join(vo,conn);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
}
