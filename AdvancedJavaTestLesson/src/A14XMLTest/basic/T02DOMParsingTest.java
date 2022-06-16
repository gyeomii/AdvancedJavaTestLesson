package A14XMLTest.basic;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class T02DOMParsingTest {
	public void parse() throws ParserConfigurationException {

		// DOM Document 객체 생성
		// XML문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
	}
}
