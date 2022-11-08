package com.kh.sty09.member.service;

import static com.kh.sty09.common.JDBCTemplate.close;
import static com.kh.sty09.common.JDBCTemplate.commit;
import static com.kh.sty09.common.JDBCTemplate.getConnection;
import static com.kh.sty09.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.sty09.member.dao.MemberDao;
import com.kh.sty09.member.vo.MemberVo;

public class MemberService {
	
	private static final MemberDao dao = new MemberDao();
	
	public MemberVo selectOne(MemberVo vo) {
		Connection conn = getConnection();
		
		MemberVo loginMember = dao.selectOne(vo,conn);
		
		close(conn);
		
		return loginMember;
	}

	public int join(MemberVo vo) {
		Connection conn = getConnection();
		
		int result = dao.join(vo,conn);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public List<MemberVo> selectList() {
		Connection conn = getConnection();
		
		List<MemberVo> voList = dao.selectList(conn);
		
		close(conn);
		
		return voList;
	}
	
}
