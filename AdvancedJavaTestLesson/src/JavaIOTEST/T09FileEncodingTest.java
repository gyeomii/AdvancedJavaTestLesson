package JavaIOTEST;

public class T09FileEncodingTest {
/*
	인코딩 방식
	
	한글 인코딩 방식은 크게 UTF-8과 EUC-KR방식 두가지로 나뉜다.
	원래 한글 윈도우는 CP949방식을 사용했는데, 윈도우를 개발한 마이크로소프트에서
	EUC-KR방식에서 확장하였기 때문에 MS949라고도 부른다.
	한글 Windows 메모장에서 말하는 ANSI인코딩이란, CP949(Code Page 949)를 말한다.
	CP949는 EUC-KR의 확장이며, 하위 호환성이 있다.
	
	- MS949 => 윈도우의 기본 한글 인코딩 방식(ANSI계열)
	- UTF-8 => 유니코드 UTF-8 인코딩 방식
			   (영문자 및 숫자: 1byte, 한글: 3byte) => 가변적
	- US-ASCII => 영문 전용 인코딩 방식
	
	ANSI는 영어를 표기하기 위해 만든 코드로 규격 자체에 한글이 없었다가
	나중에 여기에 EUC-KR, CP949 라는 식으로 한글이 포함되었다.
 	
 	- 유니코드(UNICODE)
 	서로 다른 문자 인코딩을 사용하는 컴퓨터간의 문서교환에 어려움을 겪게 되고,
 	이런 문제점을 해결하기위해 전세계의 모든 문자를 통일된 문자집합(CharSet)으로 표현하였다.
 	처음엔 2byte(65536)로 표현했지만, 부족해져서 21bit(약 200만 문자)로 확장되었다.
 */
	public static void main(String[] args) {
		
	}
}
