package JavaIOTEST;

import java.io.*;

public class T08FileReaderTest {
	public static void main(String[] args) {

		//FileReader fr = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			
			//fr = new FileReader("d:/D_Other/testChar.txt");
			fis = new FileInputStream("d:/Others/testChar.txt");
			isr = new InputStreamReader(fis);
			
			int data = 0;
			
			while((data = isr.read()) != -1) {
				System.out.print((char) data);
			}
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				//fr.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
