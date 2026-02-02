package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
	문제 : N과 M (6)
	알고리즘 : 백트래킹
	난이도 : 실버 3
	시간제한 : 1초
*/

public class Solution_tier3_15655 {

	// 조합 nCm
	// 배열 데이터 필요, 다음 요소 탐색 시작 start 변수 필요.

	private static int N, M;
	private static int[] arr;
	private static List<Integer> output = new ArrayList<>();

	private static StringBuilder sb = new StringBuilder();	// 출력
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		backTracking(0, 0);
		System.out.println(sb);

	}

	private static void backTracking(int depth, int startIndex) {
		if (depth == M) {
			for (Integer e : output) {
				sb.append(e).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = startIndex; i < N; i++) {
			output.add(arr[i]);
			backTracking(depth + 1, i + 1);
			output.remove(output.size() - 1);
		}
	}
}