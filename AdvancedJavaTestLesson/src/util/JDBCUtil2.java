package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * db.properties파일의 내용으로 DB정보를 설정하는 방법
 * 방법1)Properties 객체 이용하기
 * @author Gyeomii
 */
public class JDBCUtil2 {
	static Properties prop;
	//드라이버 로딩(옵션)
		static {
			prop = new Properties(); //객체 생성
			
			try {
				
				prop.load(new FileInputStream("res/db.properties"));
				
				Class.forName(prop.getProperty("driver"));
				
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("파일이 없거나 입출력 오류");
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
						prop.getProperty("url"),
						prop.getProperty("user"),
						prop.getProperty("password"));
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
