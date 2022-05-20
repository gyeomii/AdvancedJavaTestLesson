package GenericEnumTest;

import java.util.ArrayList;
import java.util.List;

public class T05WildCardTest {
	/*
	 * 와일드 카드(Wild Card)<?> - 제너릭 타입을 이용한 타입
	 * 안전한 코드를 위해 사용하는 특별한 종류의 인수(Argument)
	 * 변수선언, 객체생성 및 메소드를 정의 할 때 사용
	 * 
	 * <? extends T> : 와일드카드의 상한 제한. T와 그 자손들만 가능 
	 * <? super T> : 와일드카드의 하한 제한. T와 그 조상들만 가능 
	 * <?> : 모든타입이 가능 <? extends Object>와 동일.
	 */
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple("사과1"));
		fruitBox.add(new Grape("포도1"));
		
		appleBox.add(new Apple("사과2"));
		appleBox.add(new Apple("사과3"));
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
		
	}
}

class Juicer{
	static void makeJuice(FruitBox<? extends Fruit> box) {
		String fruitListStr = "";
		
		int cnt = 0;
		for (Object f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			}else {
				fruitListStr += " + " + f;
			}
			cnt++;
		}
		System.out.println("(" + fruitListStr + ")" + "쥬스 완성");
	}
	
}

class Fruit {
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}
}

class Apple extends Fruit {
	public Apple(String name) {
		super("사과");
	}
}

class Grape extends Fruit {
	public Grape(String name) {
		super("포도");
	}
}

class FruitBox<T> {
	private List<T> fruitList;

	public FruitBox() {
		fruitList = new ArrayList<T>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
}
