package main.concept.innerclass;

public class InnerClassEx0 {
	
	public class InnerClass_test{
		
		void solution2() {
			
		}
	}
	
	
	public void solution() {	// 어디서든 접근 가능
		
		class Member {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		InnerClassEx0 innerClass = new InnerClassEx0();
		
		//InnerClass ic = new InnerClass_01_01().new InnerClass();
		
		//new InnerClass_01_01().solution();
		
	}

}
