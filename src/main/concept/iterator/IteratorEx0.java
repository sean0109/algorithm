package main.concept.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEx0 {
	
	// Iterator의 용례에 대해서 알아보자
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1. 사용자 정의 클래스에 iterator 쓰기
		Student student_A = new Student("John", 13);
		Student student_B = new Student("Mina", 21);
		Student student_C = new Student("Mike", 20);
		Student student_D = new Student("Linda", 15);
		Student student_E = new Student("Henry", 17);
		
		List<Student> list = new ArrayList<Student>();
		list = List.of(student_A, student_B, student_C, student_D, student_E);
		
		list.stream().forEach(x->System.out.println("name : " + x.name + ", age : " + x.age));
		
		StudentGroup studentGroup_A = new StudentGroup(list);
		
		while(studentGroup_A.hasNext()) {
			Student temp_student = studentGroup_A.next();
			System.out.println(temp_student.name + ", " + temp_student.age);
		}
		
	}

}


class Student {
	
	String name;
	int age;

	public Student(String name, int age) {
		//super();
		this.name = name;
		this.age = age;
	}
}

class StudentGroup implements Iterator<Student>{
	
	List<Student> list;
	int index = 0;
	
	public StudentGroup(List<Student> list) {
		this.list = list;
		
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return index < list.size();
		
	}
	
	@Override
	public Student next() {
		// TODO Auto-generated method stub
		
		return list.get(index++);
		
	}
}

