package com.kh.app.board.service;

import static com.kh.app.common.db.JDBCTemplate.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

public class BoardService {
	private static BoardDao dao = new BoardDao();
	public int write(BoardVo vo) {
		SqlSession ss = getSqlSession();
		
		int result = dao.insertOne(vo,ss);
		
		if(result==1) {
			ss.commit();
		}
		
		ss.close();
		
		return result;
	}

	public List<BoardVo> selsectList(Map<String, String> searchMap) {
		SqlSession ss = getSqlSession();
		
		List<BoardVo> voList = dao.selectList(ss,searchMap);
		
		ss.close();
		
		return voList;
	}
	
}
