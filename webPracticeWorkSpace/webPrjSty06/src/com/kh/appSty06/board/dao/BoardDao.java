package com.kh.appSty06.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.appSty06.board.vo.BoardVo;
import static com.kh.appSty06.common.JDBCTemplate.*;

public class BoardDao {

	public List<BoardVo> selectAllList(Connection conn) {
		String sql = "SELECT B.NO ,M.NICK ,TITLE ,CONTENT ,HIT ,B.ENROLL_DATE ,B.MODIFY_DATE FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO WHERE B.STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		List<BoardVo> voList = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String writer = rs.getString("NICK"); 
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				BoardVo vo = new BoardVo();
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setHit(hit);
				vo.setModifyDate(modifyDate);
				vo.setNo(no);
				vo.setTitle(title);
				vo.setWriter(writer);
				
				voList = new ArrayList<>();
				
				voList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return voList;
	}

	public BoardVo selectOne(String no, Connection conn) {
		String sql = "SELECT B.NO ,M.NICK ,TITLE ,CONTENT ,HIT ,B.ENROLL_DATE ,B.MODIFY_DATE FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO WHERE B.STATUS = 'O' AND B.NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String writer = rs.getString("NICK");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String hit = rs.getString("HIT");
				String enroll_date = rs.getString("ENROLL_DATE");
				String modify_date = rs.getString("MODIFY_DATE");
				
				vo = new BoardVo();
				vo.setContent(content);
				vo.setEnrollDate(enroll_date);
				vo.setHit(hit);
				vo.setModifyDate(modify_date);
				vo.setNo(no);
				vo.setTitle(title);
				vo.setWriter(writer);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}

	public int updateHit(Connection conn, String no) {
		String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

}
