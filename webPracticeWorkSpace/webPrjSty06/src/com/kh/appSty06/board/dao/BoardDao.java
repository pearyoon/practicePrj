package com.kh.appSty06.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.appSty06.board.vo.BoardVo;
import com.kh.appSty06.common.PageVo;

import static com.kh.appSty06.common.JDBCTemplate.*;

public class BoardDao {

	public List<BoardVo> selectAllList(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT B.NO ,M.NICK ,TITLE ,CONTENT ,HIT ,B.ENROLL_DATE ,B.MODIFY_DATE FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO WHERE B.STATUS = 'O' ORDER BY B.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		List<BoardVo> voList = new ArrayList<>();
		ResultSet rs = null;
		
		// pv 객체로 페이지 별 시작 게시물과 끝 게시물 가져오기
		/*
		 * 시작값 : (currentPage - 1) * boardLimit + 1
		 * 끝값 : 시작값 + boardLimit - 1
		 */
		
		int start = (pv.getCurrentPage() -1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
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

	public int selectCount(Connection conn) {
		String sql = "SELECT COUNT(*) AS CNT FROM BOARD WHERE STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

}
