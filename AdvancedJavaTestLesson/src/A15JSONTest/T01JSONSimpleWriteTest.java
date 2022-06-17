package A15JSONTest;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class T01JSONSimpleWriteTest {
	/*
	 * JSON : JavaScript Object Notation
	 * 
	 * - JSON에서 value값으로 가능한 데이터 타입 1.String 2.number 3.object(JSON object) 4.array
	 * 5.boolean 6.null
	 */
	public static void main(String[] args) throws Exception {
		// JSON데이터 생성하기
		JSONObject mv = new JSONObject();

		mv.put("name", "홍길동");
		mv.put("job", "의적");
		mv.put("age", 30);
		mv.put("addr", "조선");

		// JSONArray 데이터 생성
		JSONArray memList = new JSONArray();

		JSONObject mv2 = new JSONObject();
		mv2.put("name", "이순신");
		mv2.put("job", "장군");
		mv2.put("age", 34);
		mv2.put("addr", "조선");
		memList.add(mv2);
		
		mv2 = new JSONObject();
		mv2.put("name", "강감찬");
		mv2.put("job", "장군");
		mv2.put("age", 20);
		mv2.put("addr", "부산시 해운대구");
		memList.add(mv2);
  
		mv2 = new JSONObject();     // 형이 틀려서 내가 고쳐줌 ㅋ
		mv2.put("name", "이몽룡");
		mv2.put("job", "암행어사");
		mv2.put("age", 29);
		mv2.put("addr", "조선");
		memList.add(mv2);

		mv2 = new JSONObject();     // 형이 틀려서 내가 고쳐줌 ㅋ
		mv2.put("name", "정도전");
		mv2.put("job", "유학자");
		mv2.put("age", 52);
		mv2.put("addr", "성균관");
		memList.add(mv2);
		
		mv.put("memList", memList);
		
		FileWriter fw = new FileWriter("./myJsonFile.txt");
		fw.write(mv.toString());
		fw.flush();
		fw.close();
	}
}
