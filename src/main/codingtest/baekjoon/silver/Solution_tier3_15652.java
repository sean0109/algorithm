package main.codingtest.baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
문제 : N과 M (4) - 백트래킹
알고리즘 : 백트래킹
난이도 : 실버 3
시간제한 : 1초
*/

public class Solution_tier3_15652 {

	private int N;
	private int M;
	private boolean[] visited;
	private List<Integer> output = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	private int lastLeaf;

	private void solve_1() throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		backtrack(0);
		System.out.println(sb);
	}

	private void backtrack(int depth) throws Exception {

		if(depth == M){
			for(int i : output){
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}

		for(int i = 1; i <= N; i++){
			lastLeaf = output.isEmpty() ? 0 : output.get(output.size() - 1);

			if(i >= lastLeaf){
				output.add(i);
				backtrack(depth + 1);
				output.remove(output.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier3_15652().solve_1();
	}
}