package com.kh.appSty06.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.appSty06.board.dao.BoardDao;
import com.kh.appSty06.board.vo.BoardVo;
import static com.kh.appSty06.common.JDBCTemplate.*;

public class BoardService {
	private final BoardDao dao = new BoardDao();

	public List<BoardVo> selectAllList() {
		Connection conn = getConnection();
		List<BoardVo> voList = dao.selectAllList(conn);
		
		close(conn);
		
		return voList;
	}

	public BoardVo selectOne(String no ,String isEdit) {
		Connection conn = getConnection();
		
		// 조회수  +1 업데이트 시켜주기
		int result = dao.updateHit(conn,no);
		
		if(result == 1 || "false".equals(isEdit)) {
			commit(conn);
			
		} else {
			rollback(conn);
		}
		
		BoardVo vo = vo = dao.selectOne(no,conn);
		
		close(conn);
		
		return vo;
	}

}
