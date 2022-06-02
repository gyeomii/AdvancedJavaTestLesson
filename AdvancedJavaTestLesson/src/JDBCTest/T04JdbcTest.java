package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	Lprod 테이블에 새로운 데이터를 추가하기
	
	lprod_gu와 lprod_nm은 직접 입력받아 처리하고
	lprod_id는 현재의 lprod_id들 중 제일 큰 값보다 1 증가된 값으로 한다.
	(기타사항 : lprod_gu도 중복되는지 검사한다.)
 */
public class T04JdbcTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "KSG97";
			String password = "java";

			conn = DriverManager.getConnection(url, userId, password);
			stmt = conn.createStatement();
			String sqlGetId = "select max(lprod_id) from lprod";
			rs = stmt.executeQuery(sqlGetId);
			int maxId = 0;
			while (rs.next()) {
				maxId = rs.getInt(1);
			}
			maxId++;
			
			String lprodGu = "";
			String lprodNm = "";
			int cnt = 0;
			String checkSql = "select count(*) as cnt from lprod where lprod_gu = ?";
			pstmt = conn.prepareStatement(checkSql);
			
			do {
				System.out.print("lprod_gu 입력 : ");
				lprodGu = sc.next();
				pstmt.setString(1, lprodGu);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					cnt = rs.getInt("cnt");
				}
				if (cnt > 0) {
					System.out.println("해당 lprod_gu 값이 존재합니다. 입력한값 : " + lprodGu);
					System.out.println();
				} 
			}while(cnt > 0);
			System.out.print("lprod_nm 입력 : ");
			lprodNm = sc.next();
			sc.close();
			
			String insertSql = "Insert into lprod (lprod_id, lprod_gu, lprod_nm)" + " values (?, ?, ?)";

			pstmt = conn.prepareStatement(insertSql);
			pstmt.setInt(1, maxId);
			pstmt.setString(2, lprodGu);
			pstmt.setString(3, lprodNm);

			int result = pstmt.executeUpdate();
			if(result > 0) {
			System.out.println("INSERT 작업 완료");
			}else {
				System.out.println("INSERT 작업 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
			if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}

	}
}
