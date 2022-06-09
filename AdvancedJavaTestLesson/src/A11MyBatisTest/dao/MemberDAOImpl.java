package A11MyBatisTest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import A11MyBatisTest.vo.MemberVO;
import util.MyBatisUtil;


public class MemberDAOImpl implements IMemberDAO{
	
	private static IMemberDAO memDao;
	private SqlSession sqlSession;
	
	private MemberDAOImpl() {
		sqlSession = MyBatisUtil.getInstance();
	}
	
	public static IMemberDAO getInstance() {
		if(memDao == null) {
			memDao = new MemberDAOImpl();
		}
		return memDao;
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt = sqlSession.insert("",mv);
		return cnt;
	}

	@Override
	public int updatetMember(MemberVO mv) {
		int cnt = sqlSession.update("", mv);
		return 0;
		
	}

	@Override
	public int deleteMember(String memId) {
		return 0;
		
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<MemberVO>();

		return memList;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = false;
		
		return isExist;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		return memList;
	}
}




