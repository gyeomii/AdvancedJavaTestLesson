package ThreadTest;

public class T13ThreadStopTest {
	public static void main(String[] args) {
		/*ThreadStopEx1 th = new ThreadStopEx1();
		th.start();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		//th.stop(); // 비추천
		th.setStop(true); // 플래그값을 이용한 스레드 중지하기
		*/
		
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();

		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		th2.interrupt();
		
	}
}

class ThreadStopEx1 extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while(!stop) {
			System.out.println("스레드 처리 중...");
		}
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}

// interrupt()를 이용하여 스레드클래스 멈추게 하기
class ThreadStopEx2 extends Thread {
	@Override
	public void run() {
		/*// 방법1 => sleep()이나 join() 등을 사용했을 때 interrupt()를
		//          호출하면 InterruptedException이 발생한다.
		try {
			while(true) {
				System.out.println("스레드 처리 중...");
				Thread.sleep(1);
			}
		}catch(InterruptedException ex) {}
		*/
		
		// 방법2 => interrupt()가 호출 되었는지 검사하기
		while(true) {
			System.out.println("스레드 처리 중...");
			/*// 검사방법1 => 스레드의 인스턴스객체용 메서드를 이용하는 방법
			if(this.isInterrupted()) {
				System.out.println("인스턴스용 isInterruped() 호출됨");
				break;
			}*/
			
			// 검사방법2 => 스레드의 정적 메서드를 이용하는 방법
			if(Thread.interrupted()) {
				System.out.println("정적 메서드 호출됨.");
				break;
			}
		}
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}



