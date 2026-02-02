package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_tier4_10866 {
	
	private void solution_1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int lp = Integer.parseInt(br.readLine());
		

		Deque<Integer>deque = new ArrayDeque<Integer>();
		
		for(int i = 0 ; i < lp; i ++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.hasMoreTokens() == true ? st.nextToken() : "";
			int data = st.hasMoreTokens() == true ? Integer.parseInt(st.nextToken()) : 0;
			
			switch(command) {
			case "push_front" :
				
				deque.offerFirst(data);
				break;
				
			case "push_back" :
				
				deque.offerLast(data);
				break;
				
			case "pop_front" :
				
				
				if(!deque.isEmpty()) {
					sb.append(deque.pollFirst());
				}else {
					sb.append(-1);
				}
				sb.append('\n');
				break;
				
			case "pop_back" :
				
				if(!deque.isEmpty()) {
					sb.append(deque.pollLast());
				}else {
					sb.append(-1);
				}
				sb.append('\n');
				break;
				
			case "size" :
				
				sb.append(deque.size()).append('\n');
				break;
				
			case "empty" :
				
				if(!deque.isEmpty()) {
					sb.append(0);
				}else {
					sb.append(1);
				}
				sb.append('\n');
				break;
				
			case "front" :
				
				if(!deque.isEmpty()) {
					sb.append(deque.peekFirst());
				}else {
					sb.append(-1);
				}
				sb.append('\n');
				break;
				
			case "back" :
				
				if(!deque.isEmpty()) {
					sb.append(deque.peekLast());
				}else {
					sb.append(-1);
				}
				sb.append('\n');
				break;
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier4_10866().solution_1();
	}
}


 