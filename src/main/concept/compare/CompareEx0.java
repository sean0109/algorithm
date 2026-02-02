package main.concept.compare;

import java.util.Comparator;
import java.util.List;

public  class CompareEx0 {
	
	/*
			
			comParable과 comparator 모두 interface
			즉,comparable 혹은 comparator를 사용하고자 한다면 인터페이스 내에 선언된 메소드를 반드시 구현
			
	 */
	public static void main(String[] args) {
		
		Student studentA = new Student(17, 2);
		Student studentB = new Student(18, 1);
		
		int flag = studentA.compareTo(studentB);
		
		if(flag > 0) {
			
			System.out.println("studentA 객체가 studentB 객체보다 큽니다.");
			
		}else if(flag == 0) {
			System.out.println("studentA 객체가 studentB 객체와 크기가 같습니다");
		}else {
			System.out.println("studentA 객체가 studentB 객체보다 작습니다.");
		}
	}
}

class User {
    private String name;
    private int age;
    private List<String> hobbies;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getHobbies() { return hobbies; }
}


class Student implements Comparable<Student>{
	
	int age;
	int classNumber;
	
	Student(int age, int classNumber){
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
		
		//return 0;
	}
}

class Teacher implements Comparator<Teacher>{
	
	int age;
	int classNumber;
	
	@Override
	public int compare(Teacher o1, Teacher o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

