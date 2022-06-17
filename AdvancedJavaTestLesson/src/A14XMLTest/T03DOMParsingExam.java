package A14XMLTest;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class T03DOMParsingExam {
	public void parse() throws Exception {
		// DOM Document 객체 생성하기 위한 팩토리 생성
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = dbf.newDocumentBuilder();

		String svcKey = "Grid_20150827000000000227_1"; // 레시피 재료 정보 조회 서비스
		String apiKey = "1df7e8571e8df3f8cbc9b87691ca7d3e4d04f03c593d477e52bf67b03f0b6e1c"; // 개인별 발급.
		String startIdx = "1"; // 레시피 재료 시작 순번
		String endIdx = "5"; // 레시피 재료 종료 순번
		String recipeId = "195428"; // 래시피가 궁금한 음식 ID

		URL url = new URL("http://211.237.50.150:7080/openapi/" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/"
				+ endIdx + "?RECIPE_ID=" + recipeId);
		System.out.println(url.toString());
		System.out.println();
		// DOM 파서로부터 입력받은 파일을 파싱하도록 요청
		Document document = builder.parse(url.toString());

		// 루트엘리먼트 가져오기
		Element root = document.getDocumentElement();
		System.out.println("루트 엘리먼트 태그명 : " + root.getTagName());
		System.out.println();
		// 전체 레시피 수를 가져오기
		String totalCnt = root.getElementsByTagName("totalCnt").item(0).getTextContent();

		// 마지막 인덱스를 전체 레시피수로 설정
		endIdx = totalCnt;

		url = new URL("http://211.237.50.150:7080/openapi/" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/" + endIdx
				+ "?RECIPE_ID=" + recipeId);

		document = builder.parse(url.toString());

		root = document.getDocumentElement();

		String code = root.getElementsByTagName("code").item(0).getTextContent();

		if (code.contentEquals("INFO-000")) {
			NodeList rowNodeList = root.getElementsByTagName("row");
			for (int i = 0; i < rowNodeList.getLength(); i++) {
				Element element = (Element) rowNodeList.item(i);
				String rowNum = element.getElementsByTagName("ROW_NUM").item(0).getTextContent().trim();
				String irTypeName = element.getElementsByTagName("IRDNT_TY_NM").item(0).getTextContent().trim();
				String irDntNm = element.getElementsByTagName("IRDNT_NM").item(0).getTextContent().trim();
				String irCpcty = element.getElementsByTagName("IRDNT_CPCTY").item(0).getTextContent().trim();

				String str = String.format("%3s %8s %7s  %10s %7s", rowNum, recipeId, irTypeName ,irDntNm, irCpcty);
				System.out.println(str);
				System.out.println("-------------------------------------------------------------------");
			}
		}

	}

	public static void main(String[] args) throws Exception {
		new T03DOMParsingExam().parse();
	}
}
