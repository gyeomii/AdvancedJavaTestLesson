package LamdaTest;

@FunctionalInterface
public interface LamdaTestInterface1 {
	// 반환값이 없고 매개변수도 없는 추상메소드 선언
	public void test();
}

@FunctionalInterface
interface LamdaTestInterface2 {
	// 반환값이 없고 매개변수가 있는 추상메소드 선언
	public void test(int a);
}

@FunctionalInterface
interface LamdaTestInterface3 {
	// 반환값과 매개변수가 있는 추상메소드 선언
	public void test(int a, int b);
}
