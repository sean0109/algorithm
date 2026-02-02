package main.concept.anonymous;


/*
	익명 클래스와 함수형 인터페이스의 개념
*/

public class AnonymousEx0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 일반적인 방식 : 이름있는 클래스 생성
		Class_A test_1 = new Class_A();
		
		// 익명클래스 생성 방식 : Class_A를 상속한 익명의 클래스를 생성하고, 그 인스턴스를 참조변수 test2에 할당
		Class_A test_2 = new Class_A() {
			
		};
		
		// 일반적인 방식 : Inteface_A를 구현한 Class_B의 객체를 Interface_A 타입으로 참조변수 test_3가 참조. ( 다형적 참조. 다형성 )
		Interface_A test_3 = new Class_B();
		
		// 익명클래스 생성 방식 : Interface_A 언터페이스를 상속받아 구현한 익명의 클래스를 생성하고, 그 인스턴스를 Interface_A 타입의 참조변수 test_4에 할당
		Interface_A test_4 = new Interface_A() {

			@Override
			public void run(String name, int age) {
				// TODO Auto-generated method stub
				
			}
		};
		
		// 람다 방식 : Interface_A가 함수형 인터페이스이므로, 람다 표현식으로 익명 구현체를 만들어 할당 가능
		Interface_A test_5 = (name, age) -> {};
		
		
		
		// 컴파일 에러 : 추상 클래스 또는 인터페이스는 객체 생성 불가. 
		//Abastract_A test_6 = new Abastract_A();
		
		// 익명 클래스 생성 방식으로 하면 가능함. 추상클래스를 익명 클래스로 구현하여 인스턴스 생성.
		Abastract_A test_7 = new Abastract_A() {
				
		};
		
	}
}

class Class_A {

}

interface Interface_A {
	
	// 추상 메소드
	void run(String a, int b);	

	// 정적 메소드
	public static void doMethod () {
		
	};
	
	// 디폴트 메소드
	default void doDefault() {
		System.out.println("이것은 디폴트 메소드 입니다.");
	};
	
}

class Class_B implements Interface_A{

	@Override
	public void run(String name, int age) {
		// TODO Auto-generated method stub
		System.out.println("이름은 : " + name + ", 나이는 : " + age + " 입니다.");
	}
}

abstract class Abastract_A {
	
}

// 함수형 인터페이스 (추상메소드가 하나인 인터페이스)
interface Interface_B {
	void run();
}


