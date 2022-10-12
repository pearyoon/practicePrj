package com.kh.appSty06.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.appSty06.board.dao.BoardDao;
import com.kh.appSty06.board.vo.BoardVo;
import com.kh.appSty06.common.PageVo;

import static com.kh.appSty06.common.JDBCTemplate.*;

public class BoardService {
	private final BoardDao dao = new BoardDao();

	public List<BoardVo> selectAllList(PageVo pv) {
		Connection conn = getConnection();
		List<BoardVo> voList = dao.selectAllList(conn,pv);
		
		close(conn);
		
		return voList;
	}

	public BoardVo selectOne(String no ,boolean isEdit) {
		Connection conn = getConnection();
		
		int result = 0;

		if(!isEdit) {
			result = dao.updateHit(conn,no);
		};
		
		if(result == 1) {
			commit(conn);
			
		} else {
			rollback(conn);
		}
		
		BoardVo vo = vo = dao.selectOne(no,conn);
		
		close(conn);
		
		return vo;
	}
	// 총 게시글 개수
	public int selectCount() {
		Connection conn = getConnection();
		
		int result = dao.selectCount(conn);
		
		close(conn);
		
		return result;
	}

	public int edit(BoardVo vo) {
		Connection conn = getConnection();
		
		int result = dao.edit(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
