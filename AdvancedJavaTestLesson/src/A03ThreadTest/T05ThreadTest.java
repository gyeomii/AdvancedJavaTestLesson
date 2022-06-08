package A03ThreadTest;

import javax.swing.JOptionPane;

//단일스레드에서 사용자 입력 처리하기
public class T05ThreadTest {
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		System.out.println("입력값 : " + str);

		for (int i = 10; i >= 1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
