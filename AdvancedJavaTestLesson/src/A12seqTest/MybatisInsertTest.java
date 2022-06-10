package A12seqTest;

import org.apache.ibatis.session.SqlSession;

import A12seqTest.vo.MemberVO2;
import util.MyBatisUtil;

public class MybatisInsertTest {
	public static void main(String[] args) {
		
		
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		
		MemberVO2 mv = new MemberVO2();
		mv.setMemName("채희진");
		mv.setMemTel("3333-3333");
		mv.setMemAddr("대구시 수성구");
		
		int cnt = sqlSession.insert("member2.insertMember", mv);
		
		if(cnt > 0) {
			System.out.println("등록 성공...");
			
			System.out.println("memId => " + mv.getMemId());
		}
		
		
		
		
		
	}
}
