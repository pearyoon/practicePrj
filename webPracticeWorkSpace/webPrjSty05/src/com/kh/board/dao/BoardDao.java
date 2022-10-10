package com.kh.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.kh.board.vo.BoardVo;
import com.kh.member.common.JDBCTemplate;

public class BoardDao{

	public List<BoardVo> selectList(Connection conn) {
		
		String sql = "SELECT B.NO, M.NICK, TITLE, CONTENT FROM BOARD B JOIN MEMBER M ON B.MEM_NO = M.NO ORDER BY B.NO";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> voList = voList = new ArrayList<BoardVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String writerNick = rs.getString("NICK");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				
				BoardVo vo = new BoardVo();
				
				vo.setContent(content);
				vo.setNo(no);
				vo.setTitle(title);
				vo.setMemNo(writerNick);
				
				
				
				voList.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("dao 예외 발생");
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);	
		}
		return voList;
	}

	public int write(Connection conn, BoardVo vo) {
		String sql = "INSERT INTO BOARD (NO, MEM_NO,TITLE, CONTENT) VALUES (SEQ_BOARD_NO.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemNo());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



}
