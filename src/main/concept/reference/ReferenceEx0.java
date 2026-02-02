package main.concept.reference;

public class ReferenceEx0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = new String("test");
		// test는 문자열 리터럴이니까 string constant pool에 저장됨
		// new String("test")
		// -> 상수 풀에 있는 test 값을 복사해서 heap 영역에 새 string 객체 생성
		// -> 이 객체는 불변(immutable) String 객체지만, 메모리 상으로는 상수 풀에 있는 test랑 다른 객체
		// 변수 a는 그 새롭게 만든 heap 객체의 주소값을 참조함
		String b = a;
		// 이제 b도 같은 주소를 참조함. 즉 a와 b는 지금까지는 같은 heap 객체를 가리키고 있음
		
		a =  "test2";
		// test2 상수 풀에 존재하는지 확인. 없으면 새로 만들고
		// 변수 a가 이제 상수 풀에 있는 test2의 주소값을 참조 하게 됨. (주소값 변경 )
		// 이전에 a가 가리키던 String@0x123 객체와는 더 이상 연결 없음
		
		System.out.println(a);
		System.out.println(b);
		
		Person personA = new Person("Alice");
		// Person 클래스의 객체를 하나 Heap 메모리에 생성함
		Person personB = personA;
		// personA와 psersonB는 동일한 주소의 객체를 공유하고 있기때문에
		//personB.name = "Bob";
		// 어느 쪽에서 값을 바꿔도, 결국 같은 객체의 속성을 수정하는 것
		
		personB.name = "Bob";
		
		System.out.println(personA.name);
		
		System.out.println(personB.name);
		
		Man manA = new Man("Tom");
		Man manB = manA;
		
		manA = new Man("Jerry");
		
		System.out.println(manA.name);
		System.out.println(manB.name);
		
		
	}

}

class Person{
	String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}
}

class Man{
	
	final String name;
	
	public Man(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}

