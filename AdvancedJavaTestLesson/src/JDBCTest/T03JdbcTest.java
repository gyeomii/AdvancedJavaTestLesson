package JDBCTest;

import java.sql.*;

public class T03JdbcTest {
	/*
	 * lprod_id: 101 , lprod_gu: N101, lprod_nm: 농산물 
	 * lprod_id: 102 , lprod_gu: N102, lprod_nm: 수산물 
	 * lprod_id: 103 , lprod_gu: N103, lprod_nm: 축산물
	 * 위 3개의 자료를 추가하기
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "KSG97";
			String password = "java";

			conn = DriverManager.getConnection(url, userId, password);
			/*
			stmt = conn.createStatement();
			
			String sql = "Insert into lprod (lprod_id, lprod_gu, lprod_nm)"
						  + " values (101,'N101','농산물')";
			
			int cnt = stmt.executeUpdate(sql);
			System.out.println("처리결과1 : " + cnt);
			
			sql = "Insert into lprod (lprod_id, lprod_gu, lprod_nm)"
					  + " values (102,'N102','수산물')";
			
			cnt = stmt.executeUpdate(sql);
			System.out.println("처리결과2 : " + cnt);

			sql = "Insert into lprod (lprod_id, lprod_gu, lprod_nm)"
					+ " values (103,'N103','축산물')";
			
			cnt = stmt.executeUpdate(sql);
			System.out.println("처리결과3 : " + cnt);
			*/
			String sql = "Insert into lprod (lprod_id, lprod_gu, lprod_nm)"
					  + " values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 101);
			pstmt.setString(2, "N101");
			pstmt.setString(3, "농산물");
			
			int cnt = pstmt.executeUpdate();
			System.out.println("처리결과 : " + cnt);
			
			pstmt.setInt(1, 102);
			pstmt.setString(2, "N102");
			pstmt.setString(3, "수산물");
			
			cnt = pstmt.executeUpdate();
			System.out.println("처리결과 : " + cnt);
			
			pstmt.setInt(1, 103);
			pstmt.setString(2, "N103");
			pstmt.setString(3, "축산물");
			
			cnt = pstmt.executeUpdate();
			System.out.println("처리결과 : " + cnt);
			
			System.out.println("INSERT 작업 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
			if (stmt != null) try {	stmt.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}

	}
}
