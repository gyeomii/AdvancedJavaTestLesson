package JavaIOTEST;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class T07FileWriterTest {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//콘솔(표준입출력 장치)과 연결된 입력용 문자 스트림 생성
		//InputStreamReader => 바이트 기반 스트림을 문자기반 스트림으로 변환해주는 보조 스트림
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:/Others/testChar.txt");
			
			int data;
			
			System.out.println("아무거나 입력하세요.");
			
			//콘솔에서 입력할 때 끝 표시는 ctrl + z키를 누른다.
			while((data = isr.read()) != -1) {
				fw.write(data);
			}
			
			System.out.println("작업 끝");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
