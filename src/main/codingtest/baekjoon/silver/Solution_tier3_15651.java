package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
문제 : N과 M (3)
알고리즘 : 백트래킹
난이도 : 실버 3
시간제한 : 1초
*/

public class Solution_tier3_15651 {
	// 백트래킹 : 순열과 조합
	// 중복 체크 : visited 배열 (공통)
	// 순열인지 조합인지 : 조합이면 탐색시 탐색 시작 변수 필요 start

/*
    [문제 조건]
    1부터 N까지 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.

    // => 순열, start 변수 필요 없음, 중복체크 안함. (visited 체크 불필요)

*/

	private static int N, M;
	private static List<Integer> output = new ArrayList<>();
	private static int depth;

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		backtracking(0);
		System.out.println(sb);
	}

	private static void backtracking(int depth) {

		if (depth == M) {
			for (int i : output) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			output.add(i);
			backtracking(depth + 1);
			output.remove(output.size() - 1);
		}
	}
}