package com.kh.appSty07.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.kh.appSty07.common.JDBCTemplate.*;
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

}
