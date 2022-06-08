package A03ThreadTest;

public class T09ThreadDaemonTest {
	public static void main(String[] args) {
		Thread th= new AutoSaveThread();
		
		th.setDaemon(true);
		
		th.start();
		
		try {
			for (int i = 1; i <= 21; i++) {
				System.out.println("작업" + i);
				Thread.sleep(1000);
			}

		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("메인스레드 종료");
	}
}

class AutoSaveThread extends Thread{

	public void save() {
			System.out.println("작업 내용을 저장합니다");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			save(); // 저장기능 호출
		}
	}
	}
