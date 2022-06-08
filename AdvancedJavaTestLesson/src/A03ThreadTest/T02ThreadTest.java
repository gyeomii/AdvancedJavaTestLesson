package A03ThreadTest;

public class T02ThreadTest {
	/*
	 * 멀티 스레드 프로그램
	 */
	public static void main(String[] args) {
		// 방법1 : Thread클래스를 상속한 class의 인스턴스를 생성한 후 인스턴스의 start()메소드를 호출한다.
		MyThread1 th1 = new MyThread1();
		th1.start();

		// 방법2
		// Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성한 후
		// 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자의 매개변수로 넘겨준다.
		// 이 때 생성된 Thread 객체의 인스턴스의 start()메소드를 호출한다.
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();

		// 방법3
		// 익명클래스를 이용하는 방법
		// Runnable 인터페이스를 구현한 익명클래스를 이용하여 Thread객체를 생성한다.
		Thread th3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					System.out.print("@");
					try { // Thread.sleep(밀리세컨드); 1초 = 1000ms
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		th3.start();
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.print("*");
			try { // Thread.sleep(밀리세컨드); 1초 = 1000ms
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class MyThread2 implements Runnable { // 다중상속이 안되기 때문에 이미 상속을 받은 클래스는 Runnable 을 implements 하여 사용

	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.print("$");
			try { // Thread.sleep(밀리세컨드); 1초 = 1000ms
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}