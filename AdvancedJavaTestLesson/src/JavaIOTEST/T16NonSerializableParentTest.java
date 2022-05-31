package JavaIOTEST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T16NonSerializableParentTest {
/*
	부모클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우
	부모객체의 필드값 처리 방법에 대하여
	
	1. 부모클래스가 Serializable 인터페이스를 구현하도록 해야한다.
	2. 자식클래스에 writeObject()와 readObject() 메소드를 이용하여
	   부모객체의 필드값을 처리할 수 있도록 직접 구현한다.
 */
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/Others/nonSerializableTest.bin"));
		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		oos.writeObject(child);
		oos.flush();
		oos.close();
		//////////////////////////////////////
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/Others/nonSerializableTest.bin"));
		child = (Child) ois.readObject();//역직렬화
		
		System.out.println("부모이름 : " + child.getParentName());
		System.out.println("자식이름 : " + child.getChildName());
		
		ois.close();
		
	}
}
//Serializable을 구현하지 않은 부모클래스
class Parent{
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}

class Child extends Parent implements Serializable{
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	//직렬화 될 때 자동으로 호출됨
	//접근제한자가 private가 아니면 자동으로 호출되지 않음
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(getParentName());
		out.defaultWriteObject();
	}
	/**
	 * 역직렬화가 될 때 자동으로 호출됨
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		setParentName(in.readUTF());
		in.defaultReadObject();
	}
}