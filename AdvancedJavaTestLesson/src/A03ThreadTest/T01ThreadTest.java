package A03ThreadTest;

public class T01ThreadTest {
/*
 * 싱글 스레드 프로그램
 */
	public static void main(String[] args) {
		for (int i = 0; i <= 200; i++) {
			System.out.print("*");
		}
		for (int i = 0; i <= 200; i++) {
			System.out.print("$");
		}
	}
}
