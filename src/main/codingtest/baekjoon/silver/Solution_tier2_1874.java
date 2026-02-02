package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_tier2_1874 {

	private int pointer = 1;

	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> tempStack = new Stack<Integer>();

		int loop = Integer.parseInt(br.readLine());
		Boolean flag = true;

		for(int i = 0; i < loop; i ++) {
			int inputData = Integer.parseInt(br.readLine());
			flag = doCommand(tempStack, inputData, sb);
			if(!flag) break;
		}

		if(!flag) {
			System.out.println("NO");
		}else {
			System.out.println(sb);
		}

	}

	private boolean doCommand(Stack<Integer> tempStack, int inputData, StringBuilder sb) throws Exception{

		int peekData = tempStack.empty() == true ? 0 : tempStack.peek();

		Boolean flag = true;

		if(peekData < inputData) {

			while(peekData < inputData) {
				tempStack.push(pointer);
				pointer ++;
				peekData = tempStack.empty() == true ? 0 : tempStack.peek();
				sb.append("+").append('\n');
			}
		}

		if(peekData == inputData) {
			tempStack.pop();
			sb.append("-").append('\n');
		}

		if(peekData > inputData) {
			flag = false;
		}

		return flag;
	}


	public static void main(String[] args) throws Exception{
		new Solution_tier2_1874().solution_1();
	}
}


 