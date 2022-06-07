package JavaMVCTest.member.service;

import java.util.List;

import JavaMVCTest.member.dao.IMemberDAO;
import JavaMVCTest.member.dao.MemberDAOImpl;
import JavaMVCTest.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDAO memDao;

	public MemberServiceImpl() {
		memDao = new MemberDAOImpl();
	}

	@Override
	public int registMember(MemberVO mv) {
		int cnt = memDao.insertMember(mv);
		/*
		 * service는 dao들로 작업을 처리하는 과정을 하나로 묶은것 (비즈니스 로직)
		 * 한 트랜잭션의 단위
		 * - 주민등록번호 암호화 처리하기
		 * - 해당 사용자에 회원정보 등록 완료 메일 발송하기
		 */
		return cnt;
	}

	@Override
	public int updatetMember(MemberVO mv) {
		int cnt = memDao.updatetMember(mv);
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = memDao.deleteMember(memId);
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = memDao.getAllMemberList();
		return memList;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = memDao.checkMember(memId);
		return isExist;
	}

}
