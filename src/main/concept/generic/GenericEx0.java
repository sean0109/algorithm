package main.concept.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericEx0 {

	public static void main(String[] args) {
		
		// 1. 제네릭 타입과 다형성에 대해서 알아보자
		
		FruitBox<Map<String, Object>> mapBox = new FruitBox<>();
		
		FruitBox<Integer> intBox = new FruitBox<>();
		
		FruitBox<Double> doubleBox = new FruitBox<>();
		
		FruitBox<String> StringBox = new FruitBox<>();
		
		// 제네릭에서 할당 받을 수 있는 타입은 참조형 reference 타입
		
		FruitBox<Fruit> box = new FruitBox<Fruit>();
		// 제네릭 타입은 다형성의 원리가 그대로 적용된다.
		box.add(new Banana());
		box.add(new Apple());
		//box.add(new Tomato());	-> error : 제네릭 타입이 맞지 않기 때문
		System.out.println(box.fruits.size());	//--> 2
		
		FruitBox<SummerFruit> box2 = new FruitBox<>();
		box2.add(new Orange());
		box2.add(new Watermelon());
		
	}

}

interface SummerFruit {
	
}

class Orange implements SummerFruit{
	
}

class Watermelon implements SummerFruit{
	
}



class Fruit {
	
	
}

class Apple extends Fruit{
	
}

class Banana extends Fruit{
	
}

class Tomato {
	
}



class FruitBox<T>{
	
	List<T> fruits = new ArrayList<>();
	
	public void add(T fruit) {
		fruits.add(fruit);
	}
	
}

