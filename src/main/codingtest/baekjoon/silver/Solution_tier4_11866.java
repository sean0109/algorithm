package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
	문제 : 요세푸스 문제 0
	난이도 : 실버 4
	알고리즘 : 구현, 자료구조, 큐
	시간제한 : 2초
*/

public class Solution_tier4_11866 {
	
	private void solution_1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lp = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i = 1; i < lp+1; i ++) {
			deque.offerLast(i);
		}
		
		sb.append("<");
		
		while(deque.size() != 0) {
			
			for(int i = 1; i <= count; i ++) {
				
				if(i < count) {
					deque.offerLast(deque.pollFirst());
					
				}else {
					sb.append(deque.pollFirst());
					if(deque.size() != 0) {
						sb.append(", ");
					}
				}
			}
		}
		
		sb.append(">");
		
		System.out.println(sb);
	}

	private void solution_2() throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int c = sc.nextInt();

		Deque<Integer> deque = new ArrayDeque<>();

		for(int i = n; i > 0; i --) {
			deque.offer(i);
		}
		sb.append("<");
		while(!deque.isEmpty()) {
			for(int i = 1; i < c + 1; i ++){
				if(i < c){
					deque.offerFirst(deque.pollLast());
				}else{
					sb.append(deque.pollLast());
				}
			}
			if(!deque.isEmpty()) sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier4_11866().solution_1();
	}
}


 