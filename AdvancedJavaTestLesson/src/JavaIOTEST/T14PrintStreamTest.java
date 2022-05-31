package JavaIOTEST;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 프린터기능 보조 스트림
 */
public class T14PrintStreamTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = 
			new FileOutputStream("d:/Others/print.txt");
		
		/*
		    PrintStream은 모든 자료형을 출력할 수 있는 기능을 제공하는
		    OuputStream의 서브 클래스이다. 
		*/
		PrintStream out = new PrintStream(fos);
		out.print("안녕하세요. PrintStream 입니다.\n");
		out.println("안녕하세요. PrintStream 입니다.2");
		out.println("안녕하세요. PrintStream 입니다.3");
		out.println(out);  // 객체 출력
		out.println(3.14);
		//System.out.println();
		
		out.close();
		
		/*
		   PrintWriter가 PrintStream보다 다양한 언어의 문자를 처리하는데
		   적합하다. 
		*/
		PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(fos, "UTF-8"));
		pw.print("안녕하세요. PrintWriter 입니다.\n");
		pw.println("안녕하세요. PrintWriter 입니다.2");
		pw.println("안녕하세요. PrintWriter 입니다.3");
		pw.println(pw);
		
		pw.close();
	}
}
