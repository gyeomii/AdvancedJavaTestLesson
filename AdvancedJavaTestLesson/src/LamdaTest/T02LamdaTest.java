package LamdaTest;

public class T02LamdaTest {
	public static void main(String[] args) {
		//람다식을 사용하지 않는 경우
		LamdaTestInterface1 lam1 = new LamdaTestInterface1() {
			
			@Override
			public void test() {
				System.out.println("Hi");
				System.out.println("익명구현객체 방식");
			}
		};
		lam1.test();
		
		LamdaTestInterface1 lam2 = ()->{
			System.out.println("Hello");
			System.out.println("람다식 처리방식");
		};
		lam2.test();
		System.out.println("--------------------------");
	/*
	 	람다식 작성방법
	 	
	 	기본형식 : (자료형이름 매개변수명,...) -> {실행문들;}
	 	
	 	1) 매개변수의 '자료형이름'은 생략할 수 있다.
	 	ex) int a -> {System.out.println(a);}
	 	      a -> {System.out.println(a);}
	 	
	 	2) 매개변수가 1개일 경우에는 괄호'{}'를 생략할 수 있다.
	 		(단, '자료형이름'을 지정할경우에는 괄호를 생략할 수 없다.
	 	ex)	a -> {System.out.println(a);}
	 	
	 	3) '실행문'이 1개일 경우에는 '{}'를 생략할 수 있다.
	 		(이 때 문장의 끝을 나타내는 세미콜론도 생락한다.
	 	ex)	a -> System.out.println(a)
	 	
	 	4) 매개변수가 하나도 없으면 괄호'()'를 생략할 수 없다.
	 	ex)	() -> System.out.println("안녕")
	 	
	 	5) 반환값이 있을 경우에는 return명령을 사용한다.
	 	ex) (a,b) -> {return a+ b;}
	 	ex) (a,b) -> return a+ b
	 	
	 	6) 실행문에 return문만 있을 경우 return명령과 '{}'를 생략할 수 있다.
	 	ex) (a,b) -> a + b
	 */
	}
}
