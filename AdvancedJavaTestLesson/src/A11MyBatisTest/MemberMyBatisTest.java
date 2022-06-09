package A11MyBatisTest;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import A11MyBatisTest.vo.MemberVO;

public class MemberMyBatisTest {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		// mybatis를 이용하여 DB자료를 처리하는 작업 순서
		// 1.mybatis의 환경설정파일을 읽어와 실행시킨다.
		try {
			// 1-1. xml문서 읽어오기
			// 설정파일의 인코딩 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("mybatis-config.xml");

			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체를 생성하기
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rd);
			// AutoCommit false설정
			sqlSession = sessionFactory.openSession(false);
			rd.close();// Reader 객체 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 2.실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
		// 2-1. INSERT작업 연습
		System.out.println("INSERT작업 시작");
		System.out.println("       :       ");

		// 1) 저장할 데이터를 VO에 담는다.
		MemberVO mv = new MemberVO();
		mv.setMemId("f001");
		mv.setMemName("강감찬");
		mv.setMemTel("6666-6666");
		mv.setMemAddr("대한민국");

		// 2) SqlSession객체를 이용하여 해당 쿼리문을 실행한다.
		// 형식) mybatis.insert("namespace값.id값", 파라미터 객체);
		// 반환값 : 성공하면 int값이 반환
		int cnt = sqlSession.insert("memberTest.insertMember", mv);

		if (cnt > 0) {
			System.out.println("INSERT작업 성공");
			sqlSession.commit();//커밋하기
			System.out.println("COMMIT 완료");
		} else {
			System.out.println("INSERT작업 실패");
		}
		System.out.println("---------------");

	}
}
