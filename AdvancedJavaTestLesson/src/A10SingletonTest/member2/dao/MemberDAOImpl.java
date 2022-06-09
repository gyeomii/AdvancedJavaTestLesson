package A10SingletonTest.member2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import A10SingletonTest.member2.vo.MemberVO;
import util.JDBCUtil3;

public class MemberDAOImpl implements IMemberDAO{
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int cnt=0;
	
	private static IMemberDAO memDao;
	
	private MemberDAOImpl() {
		
	}
	
	public static IMemberDAO getInstance() {
		if(memDao == null) {
			memDao = new MemberDAOImpl();
		}
		return memDao;
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		try {
			conn = JDBCUtil3.getConnection();

			String sql = "INSERT INTO mymember (mem_id, mem_name, mem_tel, mem_addr, reg_dt) VALUES ( ?, ?, ?, ?, sysdate)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int updatetMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();

			String sql = "UPDATE mymember SET mem_name = ?, mem_tel = ?, mem_addr = ? WHERE mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();

			String sql = "Delete from mymember WHERE mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO mv = new MemberVO();
				mv.setMemId(rs.getString("mem_id"));
				mv.setMemName(rs.getString("mem_name"));
				mv.setMemTel(rs.getString("mem_tel"));
				mv.setMemAddr(rs.getString("mem_addr"));
				
				memList.add(mv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return memList;
	}

	@Override
	public boolean checkMember(String memId) {
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

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil3.getConnection();
			
			//and를 쓰기위해 1=1을 사용(다이나믹 쿼리 위함)
			String sql = "select * from mymember where 1=1";
//			갖고온게 null이 아니고 빈칸이 아니면
			if (mv.getMemId() != null && !mv.getMemId().equals("")) {
				sql += " and mem_id = ?";
			}
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				sql += " and mem_name like '%' || ? || '%' ";
			}
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				sql += " and mem_tel = ?";
			}
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				sql += " and mem_addr like '%' || ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			//값이 존재할 때 index변수를 사용하여 ? 에 데이터 삽입
			int index = 1;
			if (mv.getMemId() != null && !mv.getMemId().equals("")) {
				pstmt.setString(index++, mv.getMemId());
			}
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				pstmt.setString(index++, mv.getMemName());
			}
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				pstmt.setString(index++, mv.getMemTel());
			}
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				pstmt.setString(index++, mv.getMemAddr());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mv2 = new MemberVO();
				mv2.setMemId(rs.getString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));
				
				memList.add(mv2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return memList;
	}
}
