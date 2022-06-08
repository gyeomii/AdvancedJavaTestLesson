package SingletonTest.member2.service;

import java.util.List;

import SingletonTest.member2.vo.MemberVO;


/**
 * Service객체는 DAO에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고,
 * 받아온 결과 자료를 Controller에게 보내주는 역할을 한다.
 * 
 * 보통 DAO의 메서드 구조와 같게 만든다.
 */
public interface IMemberService {
	/**
	 * MemberVO에 담긴 데이터를 DB에 INSERT하는 메소드
	 * @param mv DB에 INSERT할 데이터가 저장된 MemberVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환, 실패하면 0이 반환됨
	 */
	public int registMember(MemberVO mv);
	
	/**
	 * 하나의 MemberVO 데이터를 이용하여 DB를 UPDATE하는 메소드
	 * @param mv UPDATE할 회원정보가 들어있는 MemberVO객체
	 * @return 작업 성공시 1, 작업실패 : 0
	 */
	public int updatetMember(MemberVO mv);
	
	/**
	 * 회원ID를 매개변수로 받아서 그 회원정보를 삭제하는 메소드
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * DB의 mymember테이블에 존재하는 전체 레코드를 가져와 List에 담아서 반환하는 메소드
	 * @return MemberVO객체를 담고 있는 List 객체
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 주어진 회원ID를 이용하여 회원정보가 존재하는지 체크하기 위한 메소드
	 * @param memId 체크할 회원ID
	 * @return 해당 회원ID의 회원정보가 존재하면 true, 없으면 false
	 */
	public boolean checkMember(String memId);
	
	/**
	 * 주어진 회원정보를 이용하여 해당 회원정보를 검색하는 메소드
	 * @param mv 검색에 사용할 회원정보
	 * @return 검색된 회원정보를 담은 List
	 */
	public List<MemberVO> searchMember(MemberVO mv);
}