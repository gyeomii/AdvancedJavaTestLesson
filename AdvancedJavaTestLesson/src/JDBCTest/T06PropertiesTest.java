package JDBCTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 외부의 properties파일을 읽어와 Properties객체로 처리하기
 * @author Gyeomii
 */
public class T06PropertiesTest {
	public static void main(String[] args) {
		
		// 읽어온 정보를 저장할 Properties객체 생성하기
		Properties prop = new Properties();
		
		try {
			// 파일 읽기를 수행할 FileInputStream객체 생성
			FileInputStream fis = new FileInputStream("res/db.properties");
			// Properties객체로 파일 내용 읽기
			prop.load(fis);// 파일 내용을 읽어와 속성명과 값으로 분류한 후 Properties객체에 담아준다.
			//읽어온 자료 출력하기
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + " : " + value);
			}
			System.out.println("출력 완료");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
