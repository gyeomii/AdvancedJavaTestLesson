package JavaMVCTest.member.dao;

import JavaMVCTest.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 조회한 후
 * 서비스에 전달하는 DAO의 인터페이스
 * @author gyeomii
 */
public interface IMemberDAO {
	
	public int insertMember(MemberVO mv);
	
}
