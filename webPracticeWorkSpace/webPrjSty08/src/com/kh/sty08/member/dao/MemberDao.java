package com.kh.sty08.member.dao;

import static com.kh.sty08.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.sty08.member.vo.MemberVo;

public class MemberDao {
	// 회원가입
	public int join(Connection conn, MemberVo vo) {
		String sql = "INSERT INTO TB_MEMBER ( NO ,ID ,PWD ,NICK ,ADDR ,PHONE ) VALUES ( SEQ_TB_MEMBER_NO.NEXTVAL ,? ,? ,? ,? ,? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 로그인
	public MemberVo selectOne(Connection conn, MemberVo vo) {
		String sql = "SELECT M.NO ,ID ,PWD ,NICK ,ADDR ,PHONE ,ENROLL_DATE ,MODIFY_DATE ,NAME AS GRADE FROM TB_MEMBER M JOIN GRADE G ON M.GRADE = G.NO WHERE STATUS = 'O' AND ID = ? AND PWD = ?";
		
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
				String nick = rs.getString("NICK");
				String addr = rs.getString("ADDR");
				String phone = rs.getString("PHONE");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String grade = rs.getString("GRADE");
				
				loginMember = new MemberVo();
				
				loginMember.setAddr(addr);
				loginMember.setEnrollDate(enrollDate);
				loginMember.setGrade(grade);
				loginMember.setId(id);
				loginMember.setModifyDate(modifyDate);
				loginMember.setNick(nick);
				loginMember.setNo(no);
				loginMember.setPhone(phone);
				loginMember.setPwd(pwd);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginMember;
	}
	// 정보 수정
	public int edit(MemberVo vo, Connection conn) {
		String sql = "UPDATE TB_MEMBER SET PWD = ?, NICK = ?, ADDR = ?, PHONE = ? WHERE NO = ? AND ID = ? AND STATUS = 'O'";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getNick());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getNo());
			pstmt.setString(6, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
