package com.kh.appSty07.member.dao;

import static com.kh.appSty07.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.appSty07.member.vo.MemberVo;

public class MemberDao {

	public int join(MemberVo vo, Connection conn) {
		
		String sql = "INSERT INTO TB_MEMBER ( NO ,ID ,PWD ,NICK )VALUES ( SEQ_TB_MEMBER_NO.NEXTVAL ,? ,? ,?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public MemberVo login(MemberVo vo, Connection conn) {
		
		String sql = "SELECT NO ,ID ,PWD ,NICK ,ENROLL_DATE ,MODIFY_DATE ,STATUS FROM TB_MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
		
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
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				loginMember = new MemberVo();
				
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setNo(no);
				loginMember.setEnrollDate(enrollDate);
				loginMember.setModifyDate(modifyDate);
				loginMember.setNick(nick);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginMember;
	}

}
