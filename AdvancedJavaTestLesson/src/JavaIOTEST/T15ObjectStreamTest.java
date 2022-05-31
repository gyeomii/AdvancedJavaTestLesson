package JavaIOTEST;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T15ObjectStreamTest {
	public static void main(String[] args) {
		//Member인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "경기");
		Member mem3 = new Member("이몽룡", 40, "부산");
		Member mem4 = new Member("성춘향", 50, "서울");
		
		ObjectOutputStream oos = null;
		
		try {
			//객체를 파일에 저장하기
			
			//출력용 스트림 객체 생성
			oos = new ObjectOutputStream(new FileOutputStream("D:/Others/memObj.bin"));
			
			//쓰기 작업 시작
			oos.writeObject(mem1); // 직렬화
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			System.out.println("작업 완료");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();// 스트림닫기
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class Member implements Serializable {
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할수 있도록
	// 제한하고 있음. 
	
	private String name;
	private int age;
	private String addr;
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}
