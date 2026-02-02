package main.concept.lamda;

// 함수형 인터페이스는 추상 메서드가 하나만 있는것 
interface MyFunction {
	void run();		// 추상 메서드 하나 public abstract 생략
	
	default void walk() {
		
	}
}
