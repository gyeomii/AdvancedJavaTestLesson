package A08JDBCTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import util.JDBCUtil3;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128),    -- 주소
    reg_dt DATE DEFAULT sysdate, -- 등록일
    CONSTRAINT MYMEMBER_PK PRIMARY KEY (mem_id)
);

*/
public class T05MemberInfoTest {

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private Scanner scan = new Scanner(System.in);
	private static Logger SQL_LOGGER = Logger.getLogger("log4jexam.sql.Query");
	private static Logger PARAM_LOGGER = Logger.getLogger("log4jexam.sql.Parameter");
	private static Logger RESULT_LOGGER = Logger.getLogger(T05MemberInfoTest.class);
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("-----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("     1. 자료 입력");
		System.out.println("     2. 자료 삭제");
		System.out.println("     3. 자료 수정");
		System.out.println("   4. 전체 자료 출력");
		System.out.println("     5. 작업 끝.");
		System.out.println("-----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				displayMemberAll();
				break;
			case 5: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 5);
	}

	// 회원정보 추가 메소드
	private void insertMember() {
		String memId = "";
		boolean isExist = false; // 중복체크용

		do {
			System.out.println();
			System.out.println("추가할 회원정보를 입력하세요");
			System.out.print("Member ID      >> ");

			memId = scan.next();

			isExist = checkMember(memId);

			if (isExist == true) {
				System.out.println("Member ID가 '" + memId + "'인 회원이 존재합니다.");
				System.out.println("다시 입력하세요");
			}

		} while (isExist);

		System.out.print("Member Name    >> ");
		String memName = scan.next();

		System.out.print("Member Tel     >> ");
		String memTel = scan.next();

		scan.nextLine(); // 입력 버퍼 지우기

		System.out.print("Member Address >> ");
		String memAddr = scan.nextLine();

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "INSERT INTO mymember (mem_id, mem_name, mem_tel, mem_addr, reg_dt) VALUES ( ?, ?, ?, ?, sysdate)";
			
			SQL_LOGGER.info("SQL : " + sql);			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);

			PARAM_LOGGER.debug("memId : " + memId + ", memName : " + memName 
								+ ", memTel : " + memTel + ", memAddr : " + memAddr);
			
			int cnt = pstmt.executeUpdate();
			
			RESULT_LOGGER.error("cnt : " + cnt);
			
			if (cnt > 0) {
				System.out.println("<<'" + memId + "'" + "회원 추가작업 성공>>");
			} else {
				System.out.println("<<'" + memId + "'" + "회원 추가작업 실패>>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * PK인 memId의 중복을 체크하는 메소드
	 * 
	 * @param memId
	 * @return 존재하면 true, 없으면 false
	 */
	private boolean checkMember(String memId) {
		boolean isExist = false;

		try {
			// Connection 객체 생성
			conn = JDBCUtil3.getConnection();
			// sql문 작성
			String sql = "select count(*) as cnt from mymember where mem_id = ?";
			// PrepareStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			// 쿼리를 실행하여 ResultSet을 반환받음
			rs = pstmt.executeQuery();
			// rs에서 자료 출력
			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				isExist = true;
			} else {
				isExist = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		// 중복여부 반환 (true : 중복, false : 중복아님)
		return isExist;
	}

	// 회원정보를 삭제하기 위한 메소드
	private void deleteMember() {
		String memId = "";
		boolean isExist = false; // 중복체크용

		do {
			System.out.println();
			System.out.println("삭제할 회원정보를 입력하세요");
			System.out.print("Member ID      >> ");

			memId = scan.next();

			isExist = checkMember(memId);

			if (isExist != true) {
				System.out.println("Member ID가 '" + memId + "'인 회원이 존재하지 않습니다.");
				System.out.println("다시 입력하세요");
			}
		} while (!isExist);

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "Delete from mymember WHERE mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("<<'" + memId + "'" + "회원 삭제작업 성공>>");
			} else {
				System.out.println("<<'" + memId + "'" + "회원 삭제작업 실패>>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 회원정보를 수정하기 위한 메소드
	 */
	private void updateMember() {
		String memId = "";
		boolean isExist = false; // 중복체크용

		do {
			System.out.println();
			System.out.println("수정할 회원정보를 입력하세요");
			System.out.print("Member ID      >> ");

			memId = scan.next();

			isExist = checkMember(memId);

			if (isExist != true) {
				System.out.println("Member ID가 '" + memId + "'인 회원이 존재하지 않습니다.");
				System.out.println("다시 입력하세요");
			}
		} while (!isExist);

		System.out.print("Member Name    >> ");
		String memName = scan.next();

		System.out.print("Member Tel     >> ");
		String memTel = scan.next();

		scan.nextLine(); // 입력 버퍼 지우기

		System.out.print("Member Address >> ");
		String memAddr = scan.nextLine();

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "UPDATE mymember SET mem_name = ?, mem_tel = ?, mem_addr = ? WHERE mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("<<'" + memId + "'" + "회원 수정작업 성공>>");
			} else {
				System.out.println("<<'" + memId + "'" + "회원 수정작업 실패>>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}

	// 전체 회원 정보를 출력하는 메소드
	private void displayMemberAll() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("ID\t이름\t 전화번호\t주소");
		System.out.println("-----------------------------------------------------------");

		try {
			conn = JDBCUtil3.getConnection();
			
			
			stmt = conn.createStatement();
			
			String sql = "select * from mymember";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				System.out.println(memId + "\t" + memName + "\t " + memTel + "\t" + memAddr + "\t");
			}
			System.out.println("-----------------------------------------------------------");
			System.out.println("출력 작업 완료");
			
		} catch (SQLException e) {
			System.out.println("회원자료 가져오기 실패");
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

	}

	public static void main(String[] args) {
		T05MemberInfoTest memObj = new T05MemberInfoTest();
		memObj.start();
	}

}
