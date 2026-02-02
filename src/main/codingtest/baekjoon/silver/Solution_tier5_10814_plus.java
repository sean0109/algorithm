package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
문제 : 나이순 정렬
난이도 : 실버 5
알고리즘 : 정렬, 집합과맵
시간제한 : 3초
*/

public class Solution_tier5_10814_plus {

	// Map 이용해서 풀기, Comparator 사용
	private static void solve() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<Map<String, Object>> students = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			Map<String, Object> student = new HashMap<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			student.put("age", age);
			student.put("name", name);

			students.add(student);
		}

		students.sort(new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				return (int)o1.get("age") - (int)o2.get("age");
			}
		});

		//students.sort((o1, o2) -> (int)o1.get("age") - (int)o2.get("age"));

		for(Map<String, Object> student : students) {
			sb.append(student.get("age")).append(" ").append(student.get("name")).append("\n");
		}

		System.out.println(sb);
	}

	// 2차원 배열을 이용해서 풀기
	private static void solve2( ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[][] students = new String[n][2];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students[i][0] = st.nextToken();
			students[i][1] = st.nextToken();
		}

		// comparator
		Arrays.sort(students, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

		for(String[] student : students) {
			sb.append(student[0]).append(" ").append(student[1]).append("\n");
		}
		System.out.println(sb);
	}

	private static class Student {
		private String name;
		private int age;
	}

	// Student 클래스를 만들어서 풀기
	private static void solve3() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		class Student {
			private String name;
			private int age;
		}

		Student[] students = new Student[n];

		for(int i = 0; i < n; i++) {
			Student student = new Student();
			StringTokenizer st = new StringTokenizer(br.readLine());
			student.age = Integer.parseInt(st.nextToken());
			student.name = st.nextToken();
			students[i] = student;
		}

		List<Student> sortedList = Arrays.stream(students)
				.sorted(Comparator.comparingInt(o -> o.age))
				.collect(Collectors.toList());  // before java 11

		for(Student student : sortedList) {
			sb.append(student.age).append(" ").append(student.name).append("\n");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception{

		
	}
}
 