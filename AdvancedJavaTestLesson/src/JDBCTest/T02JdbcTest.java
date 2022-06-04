package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02JdbcTest {
/*
	문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
	
	문제2) lprod_id값을 2개 입력받아서 두 값 중 작은 값부터 큰 값 사이의 자료를 출력하시오
 */
	public static void main(String[] args) {
		//JDBC작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
//		System.out.print("lprod_id값을 입력하세요: ");
//		int lprodId = sc.nextInt();
		
		System.out.println("lprod_id를 입력하세요");
		System.out.print("작은 수 : ");
		int num1 = sc.nextInt();
		System.out.print("큰 수 : ");
		int num2 = sc.nextInt();
		
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB에 접속(Connection객체 생성)
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "KSG97";
			String password = "java";
			
			conn = DriverManager.getConnection(url, userId, password);
			// 3. Statement 객체 생성 -> Connection객체를 이용한다.
			stmt = conn.createStatement();
			// 4. SQL문을 Statement객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장
//			String sql1 = "select * from lprod where lprod_id > " + lprodId; //실행할 쿼리문
			String sql2 = "select * from lprod where lprod_id between " + min + " and " + max ; //실행할 쿼리문
			// SQL문이 select인 경우 executeQuery()메소드를 사용
			// 그 외에는 executeUpdate()를 사용
//			rs = stmt.executeQuery(sql1);
			rs = stmt.executeQuery(sql2);
			// 5. ResultSet객체에 저장되어있는 데이터를 반복문과 next()메소드를 이용하여 차례대로 읽어서 처리한다.
			System.out.println("===실행한 쿼리문===");
//			System.out.println(sql1);
			System.out.println(sql2);
			System.out.println("===쿼리문 실행결과===");
			//rs.next() => ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고
			//  		   그곳에 데이터가 있으면 true, 없으면 false를 반환한다.
			while(rs.next()) {
				//컬럼의 자료를 가져오는 방법
				// 1. rs.get자료형이름("컬럼명")
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				// 2. rs.get자료형이름(컬럼번호) -> 컬럼번호는 1부터 시작
				System.out.println("lprod_gu : " + rs.getString(2));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("========================");
			}
			System.out.println("출력 끝");
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//6. 종료 (사용했던 자원을 모두 반납한다.)
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
