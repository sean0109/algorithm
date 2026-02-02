package main.concept.interfaceImpl.ex0;

// 금융결제원에서 제공하는 interface를 상속받지 않고 개별적으로 구현 
public class KakaoBank {
	public void kakaoWithDraw(int price) {
		System.out.println("Kakao은행만의 인출 로직...");
		System.out.println(price + " 원을 인출하다.");
	}
	
	
	public static void main(String[] args) {
		System.out.println("123");
		
		Bank testBank = new KBBank();
		testBank.deposit(100);
		testBank.withDraw(0);
		//testBank.KBBankLogic();	// 불가
		
		
	}
	
}
