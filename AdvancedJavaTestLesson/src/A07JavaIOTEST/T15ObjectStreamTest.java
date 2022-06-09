package A07JavaIOTEST;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T15ObjectStreamTest {
	public static void main(String[] args) {
		
		// Member 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "경기");
		Member mem3 = new Member("이몽룡", 40, "부산");
		Member mem4 = new Member("성춘향", 50, "서울");
		
		ObjectOutputStream oos = null;
		
		try {
			// 객체를 파일에 저장하기
			
			// 출력용 스트림 객체 생성	
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/Others/memObj.bin")));
			
			// 쓰기 작업 시작..
			oos.writeObject(mem1); // 직렬화
			oos.writeObject(mem2); // 직렬화
			oos.writeObject(mem3); // 직렬화
			oos.writeObject(mem4); // 직렬화
			
			System.out.println("쓰기 작업 완료");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				oos.close(); // 스트림 닫기
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		///////////////////////////////////////////////
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/Others/memObj.bin")));
			
			Object obj = null;
			// readObject() 호출시 역직렬화 발생함.
			while((obj = ois.readObject()) != null) {
				// 마지막에 다다르면 EOF 예외가 발생함.
				
				// 읽어온 데이터를 원래의 객체형으로 변환후 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("---------------------------------");
			}
			
	   }catch(ClassNotFoundException ex) {
			ex.printStackTrace();
	   }catch(IOException ex) {
			//ex.printStackTrace();
		   System.out.println("출력 완료....");
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Member implements Serializable {
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할수 있도록
	// 제한하고 있음. 
	/*
		transient -> 직렬화가 되지 않을 멤버변수에 지정한다.
					 직렬확가 되지 않는 멤버변수는 기본값으로 저장된다.
					 (참조형 변수: null, 숫자형 변수: 0)
					 *static 필드도 직렬화가 되지 않는다.
	 */
	private transient String name;
	private transient int age;
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
