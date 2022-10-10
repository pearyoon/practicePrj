package com.kh.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.member.common.JDBCTemplate;
import com.kh.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) {
		PreparedStatement pstmt = null;
		String sql="INSERT INTO MEMBER ( NO , ID , PWD , NICK , ADDR , HOBBY ) VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? , ? )";
		int result = 0;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getHobby());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public MemberVo login(MemberVo vo, Connection conn) {
		String sql = "SELECT NO, ID, PWD, NICK, ADDR, HOBBY, ENROLL_DATE, MODIFY_DATE, STATUS FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMem = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String no = rs.getString("NO");
				String nick = rs.getString("NICK");
				String addr = rs.getString("ADDR");
				String hobby = rs.getString("HOBBY");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				loginMem = new MemberVo();
				loginMem.setAddr(addr);
				loginMem.setEnrollDate(enrollDate);
				loginMem.setHobby(hobby);
				loginMem.setId(id);
				loginMem.setModifyDate(modifyDate);
				loginMem.setNick(nick);
				loginMem.setNo(no);
				loginMem.setPwd(pwd);
				loginMem.setStatus(status);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return loginMem;
	}

}
