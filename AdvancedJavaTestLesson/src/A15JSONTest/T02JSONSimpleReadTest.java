package A15JSONTest;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class T02JSONSimpleReadTest {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("./src/A15JSONTEST/myJsonFile.txt");
		JSONParser jsonParser = new JSONParser();
		
		Object obj = jsonParser.parse(fr);
		JSONObject jsonobj = (JSONObject) obj;
		
		String name = (String) jsonobj.get("name");
		String job = (String) jsonobj.get("job");
		long age = (long) jsonobj.get("age");
		String addr = (String) jsonobj.get("addr");
		
		System.out.println("name : " + name);
		System.out.println("job : " + job);
		System.out.println("age : " + age);
		System.out.println("addr : " + addr);
		
		JSONArray memList = (JSONArray) jsonobj.get("memList");
		System.out.println("----------------------------------");
		
		Iterator<JSONObject> it = memList.iterator();
		
		JSONObject jsonObj2 = null;
		while(it.hasNext()) {
			jsonObj2 = it.next();
			String str = String.format("이름 : %s,\t직업 : %6s,\t나이 : %d,\t주소 : %s\n",
					jsonObj2.get("name"),jsonObj2.get("job"),jsonObj2.get("age"),jsonObj2.get("addr"));
			System.out.println(str);
		}
		
	}
}
