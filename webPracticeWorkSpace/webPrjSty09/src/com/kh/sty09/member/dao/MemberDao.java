package com.kh.sty09.member.dao;

import static com.kh.sty09.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sty09.member.vo.MemberVo;

public class MemberDao {

	public MemberVo selectOne(MemberVo vo, Connection conn) {
		String sql = "SELECT NO, ID, PWD, NAME, ENROLL_DATE FROM MEMBER_TEMP WHERE ID = ? AND PWD = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				loginMember= new MemberVo();
				
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setName(name);
				loginMember.setNo(no);
				loginMember.setEnrollDate(enrollDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginMember;
		
	}

	public int join(MemberVo vo, Connection conn) {
		String sql = "INSERT INTO MEMBER_TEMP ( NO ,ID ,PWD ,NAME ) VALUES ( SEQ_MEMBER_TEMP_NO.NEXTVAL , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<MemberVo> selectList(Connection conn) {
		String sql = "SELECT NO, ID, PWD, NAME, ENROLL_DATE, STATUS FROM MEMBER_TEMP";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> voList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String enrollDate = rs.getString("ENROLL_DATE");
				String status = rs.getString("STATUS");
				
				MemberVo vo = new MemberVo();
				
				vo.setEnrollDate(enrollDate);
				vo.setId(id);
				vo.setName(name);
				vo.setNo(no);
				vo.setPwd(pwd);
				vo.setStatus(status);
				
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

	public int updateOne(MemberVo vo, Connection conn) {
		String sql = "UPDATE MEMBER_TEMP SET PWD = ? , NAME = ? WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public MemberVo selectOneByNo(MemberVo vo, Connection conn) {
		String sql = "SELECT NO, ID, PWD, NAME, ENROLL_DATE FROM MEMBER_TEMP WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo updateMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dataNo = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				updateMember = new MemberVo();
				
				updateMember.setNo(dataNo);
				updateMember.setId(id);
				updateMember.setPwd(pwd);
				updateMember.setName(name);
				updateMember.setEnrollDate(enrollDate);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return updateMember;
	}

}
