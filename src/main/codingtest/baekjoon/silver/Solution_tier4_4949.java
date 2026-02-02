package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
	문제 : 균형잡힌 세상
	난이도 : 실버 4
	알고리즘 : 자료구조, 문자열, 스택
	시간제한 : 1초
*/

public class Solution_tier4_4949 {
	
	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
		
		while(!".".equals(inputString = br.readLine())) {
			doCheck(inputString);
		}
	}
	
	private void doCheck(String inputString) {
		
		Deque<Character> stack = new LinkedList<Character>();
		
		String checkData = inputString.replaceAll("[^\\[\\]\\(\\)]", "");
		
		Boolean flag = true;
		
		for(char c : checkData.toCharArray()) {
			if('[' == c || '(' == c) {
				stack.push(c);
			}
			
			if(']' == c ) {
				if(!stack.isEmpty() && stack.peek() == '[' ) {
					stack.pop();
				} else {
					flag = false; 
				}
			}
			
			if(')' == c) {
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}else {
					flag = false; 
				}
			}
		}
		
		if(stack.size() == 0 && flag == true) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	}


	private static class InputStringData{
		private final String input;
		private String yesOrNo;
		private final Stack<Character> testStack = new Stack<>();

		private InputStringData(String input) {
			this.input = input;
			this.yesOrNo = "no";
		}

		private InputStringData doTest(){

			for(Character c : input.toCharArray()){
				if(c == '('){
					testStack.push(c);
				}

				if(c == '['){
					testStack.push(c);
				}

				if(c == ')'){
					if(testStack.isEmpty()){
						yesOrNo = "no";
						return this;
					}
					if(testStack.peek() == '('){
						testStack.pop();
					}else{
						yesOrNo = "no";
						return this;
					}
				}

				if(c == ']'){
					if(testStack.isEmpty()){
						yesOrNo = "no";
						return this;
					}
					if(testStack.peek() == '['){
						testStack.pop();
					}else{
						yesOrNo = "no";
						return this;
					}
				}
			}

			if(testStack.isEmpty()){
				yesOrNo = "yes";
			}
			return this;
		}

		private String getYesOrNo() {
			return yesOrNo;
		}
	}
	
	// 객체 지향적 구현
	private static void solution_2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String readLine = "";
		while(!(readLine = br.readLine()).equals(".")){
			InputStringData inputStringData = new InputStringData(readLine);
			sb.append(inputStringData.doTest().getYesOrNo()).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static void main(String[] args) throws Exception{
		new Solution_tier4_4949().solution_1();
	}
}


 