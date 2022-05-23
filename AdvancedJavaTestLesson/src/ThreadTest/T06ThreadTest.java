package ThreadTest;

import javax.swing.JOptionPane;

//멀티스레드
public class T06ThreadTest {
	//입력 여부를 확인하기 위한 변수 선언
	//모든 스레드에서 공통으로 사용할 변수
	static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
		
	}
}

//입력을 처리하는 스레드 클래스
class DataInput extends Thread {
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		
		//입력이 완료되면 inputCheck변수를 true로 변경
		T06ThreadTest.inputCheck = true;
		
		System.out.println("입력값 : " + str);
	}
}

//카운트 다운을 처리하는 스레드 클래스
class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			//입력이 완료되었는지 검사하고 입력이 완료되면 run()을 종료시킨다. 즉 현재스레드를 종료시킨다.
			if(T06ThreadTest.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}