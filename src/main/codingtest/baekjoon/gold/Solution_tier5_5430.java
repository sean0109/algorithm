package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* 
	문제 : AC
	난이도 : 골드 5
	알고리즘 : 구현, 자료구조, 문자열, 파싱, 덱
	시간제한 : 1초
*/

public class Solution_tier5_5430 {
	
	private void solution_1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int lp = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < lp; i ++) {
			String command = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String inputData = br.readLine();
			StringTokenizer st = new StringTokenizer(inputData.replace("[", "").replace("]", "").replaceAll(",", " "));
			
			Deque<Integer> deque = new LinkedList<Integer>();
			
			for(int j = 0; j < size; j ++) {
				deque.offerLast(Integer.parseInt(st.nextToken()));
			}
			
			// 연산 방향 기억 
			String direction = "first";	// first, last
			String error = "";
			
			outer:	// 2중 포문을 빠져나올 라벨
			for(char c : command.toCharArray()) {
				
				switch (c) {
					case 'R' :
						
						direction = "first".equals(direction) ? "last" : "first";
						break;
						
					case 'D' :
						// 비어있을 경우 error 
						if(deque.isEmpty()) {
							error = "error"; 
							break outer;	// outer for문 바로 바깥으로 빠져나옴
						}
						
						if("first".equals(direction)) {
							deque.pollFirst();
							
						}else {
							deque.pollLast();
						}
						
						break;
				}
			}
			// error에 걸릴 경우 "error" 출력
			if("error".equals(error)) {
				sb.append(error);
			}else {
				sb.append("[");
				// 연산방향 기억해 놓고, 하나씩 꺼내기
				switch(direction) {
					// 연산방향 "first" 일경우 앞에서 꺼내면서 , 추가
					case "first" : 
						while(deque.size() != 0) {
							sb.append(deque.pollFirst());
							if(deque.size() != 0) {
								sb.append(",");
							}
						}
					break;
					// 연산방향 "last" 일경우 뒤에서 꺼내면서 , 추가
					case "last" :
						while(deque.size() != 0) {
							sb.append(deque.pollLast());
							if(deque.size() != 0) {
								sb.append(",");
							}
						}
					break;
				}
				sb.append("]");
			}
			sb.append('\n');	// 한줄 띄우고 다음 명령어 실행할 준비
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier5_5430().solution_1();
	}
}