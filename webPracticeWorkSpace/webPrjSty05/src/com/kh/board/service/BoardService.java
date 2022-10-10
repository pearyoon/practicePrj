package com.kh.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.board.dao.BoardDao;
import com.kh.board.vo.BoardVo;
import com.kh.member.common.JDBCTemplate;

public class BoardService {

	public List<BoardVo> selectList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> voList = new BoardDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public int write(BoardVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().write(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
}
