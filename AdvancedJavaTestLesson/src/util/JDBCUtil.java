package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	//드라이버 로딩(옵션)
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	/**
	 * Connection 연결
	 * @return Connection 객체
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", "KSG97", "java");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	/**
	 * 자원 반납
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) try { rs.close(); } catch (SQLException e) {}
		if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
		if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
		if (conn != null) try { conn.close(); } catch (SQLException e) {}
	}
	
}
