package A03ThreadTest;

public class T08ThreadPriorityTest {
	public static void main(String[] args) {
		System.out.println("최대우선순위 : " + Thread.MAX_PRIORITY);
		System.out.println("최소우선순위 : " + Thread.MIN_PRIORITY);
		System.out.println("보통우선순위 : " + Thread.NORM_PRIORITY);
		
		Thread[] ths = new Thread[] {
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest2()
		};
		
		//우선순위는 start()메소드 호출전에 설정
		for (int i = 0; i < ths.length; i++) {
			if(i == 5) {
				ths[i].setPriority(1);
			}else {
				ths[i].setPriority(10);
			}
		}
		for (Thread th : ths) {
			th.start();
		}
		
		//우선순위 출력
		for(Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 대문자를 출력하기 위한 스레드
class ThreadTest1 extends Thread {
	@Override
	public void run() {
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			
			// 아무것도 하지 않는 반복문(시간때우기용)
			for(long i=1; i<=1000000000L; i++) {}
		}
	}
}

// 소문자를 출력하기 위한 스레드
class ThreadTest2 extends Thread {
	@Override
	public void run() {
		for(char ch='a'; ch<='z'; ch++) {
			System.out.println(ch);
			
			// 아무것도 하지 않는 반복문(시간때우기용)
			for(long i=1; i<=1000000000L; i++) {}
		}
	}
}
