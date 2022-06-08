package A03ThreadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//리스트 동기화 예제
public class T18SyncCollectionTest {
//Vector, Hashtable등 예전부터 존재하던 Collection 클래스들은 내부에 동기화 처리가 되어있다.
// 그런데, 최근에 새로 구성된 Collection 클래스들은 동기화 처리가 되어있지 않다.
//그래서 동기화가 필요한 경우에는 동기화 처리를 한 후 사용해야 한다.

	// 동기화 처리를 하지 않은 경우
	private static List<Integer> list1 = new ArrayList<>();
	
	//동기화 처리를 한 경우
	private static List<Integer> list2 = Collections.synchronizedList(list1); 

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					list2.add(i);
				}
			}
		};
		
		Thread[] ths = new Thread[] {
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r)
		};
		
		for(Thread th : ths) {
			th.start();
		}
		for(Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("list2의 개수: " + list2.size());
	}
}
