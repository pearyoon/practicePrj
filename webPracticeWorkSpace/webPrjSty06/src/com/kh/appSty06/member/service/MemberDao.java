package com.kh.appSty06.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.appSty06.common.JDBCTemplate;
import com.kh.appSty06.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) {
		String sql = "INSERT INTO MEMBER ( NO , ID , PWD , NICK , ADDR , HOBBY ) VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? , ? )";
		
		PreparedStatement pstmt = null ;
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

	public MemberVo selectOne(MemberVo vo, Connection conn) {
		String sql = "SELECT NO ,ID ,PWD ,NICK ,ADDR ,HOBBY ,ENROLL_DATE ,MODIFY_DATE ,STATUS FROM MEMBER WHERE ID = ? AND PWD = ?";
		
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
				String hobby = rs.getString("HOBBY");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				loginMember = new MemberVo();
				
				loginMember.setAddr(addr);
				loginMember.setEnrollDate(enrollDate);
				loginMember.setHobby(hobby);
				loginMember.setId(id);
				loginMember.setModifDate(modifyDate);
				loginMember.setStatus(status);
				loginMember.setNick(nick);
				loginMember.setPwd(pwd);
				loginMember.setNo(no);
				
				System.out.println(loginMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return loginMember;
	}

}
