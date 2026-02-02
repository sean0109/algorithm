package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
문제 : 나이순 정렬
난이도 : 실버 5
알고리즘 : 정렬, 집합과맵
시간제한 : 3초
*/

public class Solution_tier5_10814 {

	//  Member 클래스를 써서 정렬 Collections.sort()를 써서 정렬
	public void solution_1() throws Exception {

		class Member {
			 int age;
			 String name;
			 
			 private Member(int age, String name){
				 this.age = age;
				 this.name = name;
			 }
		 }
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loop = Integer.parseInt(br.readLine());
		List<Member> tempList = new ArrayList();
		
		for(int i = 0; i < loop; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			tempList.add(new Member(age, name));
		}
		
		// 정렬 : 익명 클래스
		Collections.sort(tempList, new Comparator<Member>() {
		
			@Override
			public int compare(Member o1, Member o2) {
				return o1.age - o2.age;
			}
		});
		
		
		// 람다식 표현
		//Collections.sort(tempList, (Member a, Member b) -> a.age - b.age);
		
		
		for(int i = 0; i < tempList.size(); i ++) {
			System.out.println(tempList.get(i).age + " " + tempList.get(i).name);
		}
	}
	
	// 2차원 배열을 써서, Arrays.sort() 를 써서 정렬
	public void solution_2() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [][] memberArr = new String[n][2];
		
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			memberArr[i][0] = st.nextToken();
			memberArr[i][1] = st.nextToken();
		}
		
		// 정렬
		Arrays.sort(memberArr, new Comparator<String[]>(){

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		// 람다식 표현
		//Arrays.sort(memberArr, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

		// 출력
		for(int i = 0; i < memberArr.length; i ++) {
			System.out.println(memberArr[i][0] + " " + memberArr[i][1]);
		}
	}

	public static void main(String[] args) throws Exception{
		
		new Solution_tier5_10814().solution_1();
		//new Solution_10814().solution_2();;
		
	}
}
 