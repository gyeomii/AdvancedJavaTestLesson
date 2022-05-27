package ReflectionTest;

import java.lang.reflect.Modifier;

public class T02ClassMetadateTest {
	public static void main(String[] args) throws ClassNotFoundException {
		//클래스 오브젝트 생성하기
		Class<?> clazz = Class.forName("ReflectionTest.SampleVO");
		
		System.out.println("심플 클래스명: " + clazz.getSimpleName());
		System.out.println("클래스명: " + clazz.getName());
		System.out.println("tkddnl 클래스명: " + clazz.getSuperclass().getName());
		
		//패키지 정보 가져오기
		Package pkg = clazz.getPackage();
		System.out.println("패키지정보 : " + pkg.getName());
		
		//해당클래스에서 구현하고 있는 인터페이스 목록
		Class<?>[] interfaces = clazz.getInterfaces();
		
		System.out.print("인터페이스 목록 : ");
		for (Class<?> inf : interfaces) {
			System.out.println(inf.getName());
		}
		System.out.println();
		
		//클래스의 접근제어자(flag bit값 반환됨)
		int modFlag = clazz.getModifiers();
		
		System.out.println("접근제한자 : " + Modifier.toString(modFlag));
	}
}
