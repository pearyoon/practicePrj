package com.kh.sty08.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			// 프로퍼티즈 객체 생성
			Properties prop = new Properties();
			// 파일 경로 얻기
			String filePath = JDBCTemplate.class.getResource("/db/info.properties").getPath();
			// prop에 파일 경로 로드해주기
			prop.load(new FileInputStream(filePath));
			// 키값으로 가져오기
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//클래스 로드
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			System.out.println("커넥션 얻기 실패");
			e.printStackTrace();
		}
		return conn;
	}
	// 반납
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 트랜잭션
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
