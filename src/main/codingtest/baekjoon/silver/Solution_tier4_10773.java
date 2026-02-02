package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
	문제 : 제로
	난이도 : 실버 4
	알고리즘 : 구현, 자료구조, 스택
	시간제한 : 1초
*/

public class Solution_tier4_10773 {
	
	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		//int [] tempArr = new int[100001];
		Stack<Integer> tempStack = new Stack<>();
		
		int loop = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < loop; i ++) {
			int command = Integer.parseInt(br.readLine());
			
			if(command == 0) {
				tempStack.pop();
			}else {
				tempStack.push(command);
			}
		}
		
		int size = tempStack.size();
		
		for(int i = 0; i < size; i ++) {
			answer += tempStack.pop();
		}
		System.out.println(answer);
	}
	
	
		
	public static void main(String[] args) throws Exception{
		new Solution_tier4_10773().solution_1();
	}
}


 