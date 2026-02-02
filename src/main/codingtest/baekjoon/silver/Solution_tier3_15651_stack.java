package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/* 
문제 : N과 M (3)
알고리즘 : 백트래킹
난이도 : 실버 3
시간제한 : 1초
*/

// 깊이 탐색이니까 스택 자료구조를 사용해서 문제를 해결해 보자
public class Solution_tier3_15651_stack {

	private static int N,M;
	private static int depth;

	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dfs();
		System.out.println(sb);
	}

	static class DfsFrame {
		final int depth;
		final List<Integer> output;

		public DfsFrame(int depth, List<Integer> output) {
			this.depth = depth;
			this.output = output;
		}
	}

	private static void dfs() {

		DfsFrame dfsFrame = new DfsFrame(0, new ArrayList<>());
		Stack<DfsFrame> stack = new Stack<>();

		stack.push(dfsFrame);

		while(!stack.isEmpty()) {

			DfsFrame now = stack.pop();
			int nowDepth = now.depth;
			List<Integer> nowOutput = now.output;

			if (nowDepth == M) {
				for (int i : nowOutput) {
					sb.append(i).append(" ");
				}
				sb.append("\n");
				continue;	//해당 탐색 종료
			}

			for(int i = N; i >= 1; i--) {

				List<Integer> newOutput = new ArrayList<>(nowOutput);

				newOutput.add(i);
				stack.push(new DfsFrame(nowDepth + 1,newOutput));
			}
		}
	}
}
