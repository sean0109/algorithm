package main.concept.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Comparable, Comparator 인터페이스

public class CompareEx1 {

	public static void main(String[] args) {
		
		class Student   { 
			
			String name;
			int age;
			
			public Student(String name, int age) {
				super();
				this.name = name;
				this.age = age;
			}

			/*@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}*/
		}
		
		Student student_a = new Student("Mike", 10);
		Student student_b = new Student("John", 8);
		Student student_c = new Student("TOM", 14);
		Student student_d = new Student("Jenny", 11);
		Student student_e = new Student("Alice", 21);
		
		// Comparable 인터페이스 익명 함수 구현
		Comparable compA = new Comparable<Student>() {

			@Override
			public int compareTo(Student o) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	
		Comparable<Student> compB = (Student s) -> { return 0; };
		
		Comparator<Student> compC = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				
				return o2.age - o1.age;
			}
			
		};
		
		// 1 . 익명 클래스 구현 방식
		TestClassA testclsA = new TestClassA(){

			@Override
			public void run() {
				System.out.println("익명 클래스 방식으로 객체 생성");
				
			}
		};
				
		TestClassA testClsA4 = new TestClassB();
		
		List<Student> list = new ArrayList<Student>();
		list.add(student_a);
		list.add(student_b);
		list.add(student_c);
		list.add(student_d);
		list.add(student_e);
		
		testclsA.run();
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i).name + " : " + list.get(i).age);
		}
		
		System.out.println("정렬 시작");
		Collections.sort(list, compC);
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i).name + " : " + list.get(i).age);
		}
		
		
	}
}


class TestClassA{
	public void run() {
		System.out.println("testClass A run 클래스");
	};
	
	public void plus() {
		
	}
}

class TestClassB extends TestClassA{
	public void runB() {
		
	};
	
}