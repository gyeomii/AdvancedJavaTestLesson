package A07JavaIOTEST;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T03ByteArrayIOTest {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
//		//직접 복사하기
//		outSrc = new byte[inSrc.length];
//		
//		for (int i = 0; i < inSrc.length; i++) {
//			outSrc[i] = inSrc[i];
//		}
		
		//arraycopy 이용하기
//		outSrc = new byte[inSrc.length];
//		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length);

		//스트림 선언 및 객체 생성
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data; // 읽어온 자료를 저장할 변수
		
		// read() 메소드 : byte단위로 자료를 읽어와 int형으로 반환한다.
		//				   더 이상 읽어올 자료가 없으면 -1을 반환한다.
		while((data = bais.read()) != -1){
			baos.write(data);
		}
		
		//출력된 스트림 값을 배열로 반환하기
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc : " + Arrays.toString(inSrc));
		System.out.println("outSrc : " + Arrays.toString(outSrc));
		
		// 사용한 스트림 객체 닫아주기
		bais.close();
		baos.close();
	}
}
