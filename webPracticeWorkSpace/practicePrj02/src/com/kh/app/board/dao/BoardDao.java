package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	public int insertOne(BoardVo vo, SqlSession ss) {
		return ss.insert("boardMapper.write",vo);
	}

	public List<BoardVo> selectList(SqlSession ss, Map<String, String> searchMap) {

		return ss.selectList("boardMapper.selectList",searchMap);
	}

}
