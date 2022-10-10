package com.kh.appSty06.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.appSty06.board.dao.BoardDao;
import com.kh.appSty06.board.vo.BoardVo;
import static com.kh.appSty06.common.JDBCTemplate.*;

public class BoardService {
	public BoardDao dao = new BoardDao();

	public List<BoardVo> selectAllList() {
		Connection conn = getConnection();
		List<BoardVo> voList = dao.selectAllList(conn);
		
		close(conn);
		
		return voList;
	}

	public BoardVo selectOne(String no) {
		Connection conn = getConnection();
		BoardVo vo = dao.selectOne(no,conn);
		
		close(conn);
		
		return vo;
	}

}
