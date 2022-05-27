package AnnotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) {
		
		System.out.println("static 변수값 : " + PrintAnnotation.id);
		
		// reflection기능을 이용한 메서드 실행하기
		// 선언된 메서드 목록 가져오기
		Class<?> clazz = Service.class;
		
		Method[] declaredMthods = clazz.getDeclaredMethods();
		
		for(Method m : declaredMthods) {
			
			System.out.println(m.getName()); // 메서드명 출력
			
			Annotation[] annos = m.getDeclaredAnnotations();
			
			for(Annotation anno : annos) {
				if(anno.annotationType()
						.getSimpleName().equals("PrintAnnotation")) {
					PrintAnnotation printAnno = (PrintAnnotation) anno;
					for(int i=0; i<printAnno.count(); i++) {
						System.out.print(printAnno.value());
					}
				}
			}
			System.out.println(); // 줄바꿈 처리
		}
	}
}
