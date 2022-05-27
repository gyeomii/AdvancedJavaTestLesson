package AnnotationTest;

public class Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("method1");
	}

	@PrintAnnotation(value="%")
	public void method2() {
		System.out.println("method2");
	}

	@PrintAnnotation(value="#", count=25)
	public void method3() {
		System.out.println("method3");
	}
}
