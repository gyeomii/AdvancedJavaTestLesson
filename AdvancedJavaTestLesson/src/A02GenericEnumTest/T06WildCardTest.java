package A02GenericEnumTest;

import java.util.*;

public class T06WildCardTest {
	//장바구니 항목조회를 위한 메소드(모든타입)
	public static void displayCartItemInfo(Cart<?> cart) {
		System.out.println("< 모든 장바구니 항목 리스트 >");
		for (Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("--------------------");
	}
	
	//장바구니 항목조회를 위한 메소드2(음료와 그 하위)
	public static void displayDrinkItemInfo(Cart<? extends Drink> cart) {
		System.out.println("< 음료류 장바구니 항목 리스트 >");
		for (Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("--------------------");
	}
	
	//장바구니 항목조회를 위한 메소드3(고기류나 그 상위)
	public static void displayMeatItemInfo(Cart<? super Meat> cart) {
		System.out.println("< 음식류 장바구니 항목 리스트 >");
		for (Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) {
		
		Cart<Food> foodCart = new Cart<Food>();
		foodCart.addItem(new Meat("돼지고기", 5000));
		foodCart.addItem(new Meat("소고기", 10000));
		foodCart.addItem(new Juice("오렌지쥬스", 1500));
		foodCart.addItem(new Coffee("아메리카노", 2000));
		
		Cart<Meat> meatCart = new Cart<>();
		meatCart.addItem(new Meat("닭고기", 4000));
		meatCart.addItem(new Meat("물고기", 3500));
		
		Cart<Drink> drinkCart = new Cart<>();
		drinkCart.addItem(new Juice("포도쥬스", 1500));
		drinkCart.addItem(new Coffee("에스프레소", 1800));
		
		displayCartItemInfo(foodCart);
		displayCartItemInfo(meatCart);
		displayCartItemInfo(drinkCart);
		
//		displayDrinkItemInfo(foodCart);
//		displayDrinkItemInfo(meatCart);
		displayDrinkItemInfo(drinkCart);
		
		displayMeatItemInfo(foodCart);
		displayMeatItemInfo(meatCart);
//		displayMeatItemInfo(drinkCart);
	}
}

class Food {
	private String name;
	private int price;

	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + " (" + this.price + "원)";
	}
}

class Meat extends Food {
	
	public Meat(String name, int price) {
		super(name, price);
	}
}

class Drink extends Food {
	
	public Drink(String name, int price) {
		super(name, price);
	}
}

class Juice extends Drink{
	
	public Juice(String name, int price) {
		super(name, price);
	}
}

class Coffee extends Drink{

	public Coffee(String name, int price) {
		super(name, price);
	}
}

class Cart<T>{
	private List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}
	
	public void addItem(T item) {
		list.add(item);
	}
}