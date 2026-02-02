package main.concept.lamda;

public class LamdaEx0 {
	
	// main Method
	public static void main(String[] args) {
		
		// 익명 클래스(객체)로 표현
		MyFunction function_1 = new MyFunction() {
			 public void run() {
				System.out.println("test");
			}
		};
		 
		
		function_1.run();
		
		// 람다 형식
		MyFunction function_2 = () -> System.out.println("람다 방식");
		
	}
	

}

// 일반 구현 클래스 방식, 상속받아서 Override
class TestClass implements MyFunction {

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}

class TestClass_2 {
	
	static void main() {
		System.out.println("test222");
	}
	
}


