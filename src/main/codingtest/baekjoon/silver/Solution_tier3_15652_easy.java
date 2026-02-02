package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
문제 : N과 M (4) - 백트래킹
알고리즘 : 백트래킹
난이도 : 실버 3
시간제한 : 1초
*/

public class Solution_tier3_15652_easy {

	// 조합, 중복 허용 : start 변수 필요, visited 배열 불필요

	private static int N, M;
	private static List<Integer> output = new ArrayList<>();

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		backTracking(0, 1);

		System.out.println(sb);

	}

	private static void backTracking(int depth, int start) {
		if (depth == M) {
			for (int e : output) {
				sb.append(e).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++ ) {
			output.add(i);
			backTracking(depth + 1, i);
			output.remove(output.size() - 1);
		}
	}
}