package A02GenericEnumTest;

import java.util.ArrayList;
import java.util.List;

public class T07WildCardTest {
	// 회원정보 출력
	public void printMemberInfo(List<? extends Member> list) {
		/*
		 * extends 키워드를 이용한 상한제한(Upper Bounds)예제 list 안의 객체는 반드시 Member타입의 객체임을 보장할 수
		 * 있다.
		 */
		for (Member mem : list) {
			System.out.println(mem);
		}
	}

//	public void printMemberInfo2(List<? super Member> list) {
//
//		// super키워드를 이용한 하한제한(Lower Bounds)
//		// Member 타입의 변수를 이용하여 List로부터 객체를 꺼내올 수 있다.
//
//		for (Member obj : list) {// 컴파일 에러발생
//			System.out.println(obj);
//		}
//	}

//	// 회원정보 등록
//	public void registerMemberInfo(List<? extends Member> list) {
//
//		// Member 타입의 객체라고 항상 list에 추가할 수 있음을 보장할 수 없다. (Member타입 또는 Member를 상속한 그 어떤
//		// 타입을 의미하므로 아직 구체적인 타입이 정해지지 않음 컴파일 에러 발생
//
//		Member m = new Member("홍길동", 33);
//		list.add(m); // 등록 불가
//	}

	public void registerMemberInfo2(List<? super Member> list) {
		/*
		 * super 키워드를 이용한 하한 제한(Lower Bound) 예제 list는 Member타입의 객체를 포함한다는 것을 보장 할 수 있다.
		 * -> Member타입 또는 Member타입의 슈퍼타입을 담은 리스트를 의미하기 떄문
		 */
		Member m = new Member("홍길동", 33);
		list.add(m); // 등록 가능
	}

	public static void main(String[] args) {
		T07WildCardTest wc = new T07WildCardTest();
		List<Member> memList = new ArrayList<Member>();

		wc.registerMemberInfo2(memList);
		wc.printMemberInfo(memList);
	}

}

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
}