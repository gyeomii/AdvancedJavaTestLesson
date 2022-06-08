package A03ThreadTest;

import java.util.Random;

public class T11DisplayCharacterTest {
	static String strRank = "";
//3명의 스레드가 각각 알파벳 대문자를 출력하고
//출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
	public static void main(String[] args) {
		DisplayCharacter[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("홍기동"),
				new DisplayCharacter("일지매"),
				new DisplayCharacter("성춘향")
		};
		for(Thread th : disChars) {
			th.start();
		}
		
		for(Thread th : disChars) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 끝");
		System.out.println("----------");
		System.out.println();
		System.out.println(" 경기 결과 ");
		System.out.println(" 순위 : " +  strRank);
	}
}

//문자열 출력 스레드
class DisplayCharacter extends Thread {
	private String name;
	Random rnd = new Random();
	int randomTime = rnd.nextInt(301) + 200;

	public DisplayCharacter(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력문자: " + ch);
			try {
				Thread.sleep(randomTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("출력 끝");
		T11DisplayCharacterTest.strRank += (name + " ");
	}

}