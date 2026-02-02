package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_tier2_1406 {
	
	private void solution_1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String init = br.readLine();
		Deque<Character> deque = new ArrayDeque<>();
		Stack<Character> stack = new Stack<>();
		
		for(char c : init.toCharArray()) {
			deque.offerLast(c);
		}
		
		int lp = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < lp; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Character command = st.hasMoreTokens() == true ? st.nextToken().charAt(0) : ' ';
			Character input = st.hasMoreTokens() == true ? st.nextToken().charAt(0) : ' ';
			
			switch(command) {
			case 'L' :
				
				if(!deque.isEmpty()) {
					stack.push(deque.pollLast());
				}
				break;
				
			case 'D' :
				
				if(!stack.isEmpty()) {
					deque.offerLast(stack.pop());
				}
				break;
				
			case 'B' :
				
				if(!deque.isEmpty()) {
					deque.pollLast();
				}
				break;
				
			case 'P' :
				
				deque.offerLast(input);
				break;
				
			}
			
		}
		
		while(stack.size() != 0) {
			deque.offerLast(stack.pop());
		}
		
		while (deque.size() != 0) {
			sb.append(deque.pollFirst());
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier2_1406().solution_1();
	}
}