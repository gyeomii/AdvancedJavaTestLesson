package JavaIOTEST;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11BufferedIOTest {
	public static void main(String[] args) {
		// 입출력 성능향상을 위해 버퍼를 이용하는 보조스트림
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("D:/Others/bufferTest.txt");

			// 버퍼의 크기를 지정하지 않으면 기본으로 버퍼의 크기가 8KB(8192Byte)로 설정된다.

			// 버퍼의 크기가 5인 스트림 생성
			bos = new BufferedOutputStream(fos, 5);

			for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}

			bos.flush();// 작업을 종료하기전에 남아있는 데이터를 모두 출력시킨다.
						// close시 자동으로 호출됨
			System.out.println("출력 작업 끝");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
