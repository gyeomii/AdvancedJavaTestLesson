package JavaIOTEST;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T06FileStreamTest {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream("D:/Others/out.txt");
			
			for(char ch = 'a'; ch <= 'z'; ch++) {
				try {
					fos.write(ch);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
