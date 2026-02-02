package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
문제 : N과 M (5)
알고리즘 : 백트래킹
난이도 : 실버 3
시간제한 : 1초
*/

public class Solution_tier3_15654 {

	private int [] arr;	// 순열데이터
	private int M;		// depth
	private boolean[] visited;
	private List<Integer> output = new ArrayList<>();
	private StringBuilder sb = new StringBuilder();

	private void solve_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = Integer.parseInt(st.nextToken());
		arr = new int[cnt];
		M = Integer.parseInt(st.nextToken());	// depth
		visited = new boolean[cnt];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
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

		for(int i = 0; i < arr.length; i++) {
			if(!visited[i]){
				output.add(arr[i]);
				visited[i] = true;
				backtrack(depth + 1);
				output.remove(output.size() - 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier3_15654().solve_1();
	}
}