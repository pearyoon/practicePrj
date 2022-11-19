package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	public int write(BoardVo vo, SqlSession ss) {
		return ss.insert("board-mapper.write",vo);
	}

	public List<BoardVo> selectListAll(SqlSession ss, Map<String, String> searchMap) {
		
		return ss.selectList("board-mapper.listAll",searchMap);
	}

}
