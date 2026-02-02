package main.codingtest.baekjoon.silver;

/*
	제목 : N 과 M (2)
	알고리즘 : 백트래킹
	난이도 : 실버 3
	시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_tier3_15650 {

	private static int N, M;	// 조합
	//private static boolean[] visited;
	private static List<Integer> output = new ArrayList<>();

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());   // depth

		//visited = new boolean[N + 1];
		int start = 1;
		backTrack(0, start);
		System.out.println(sb.toString());
	}

	private static void backTrack(int depth, int start) {

		if (depth == M) {
			for (int data : output) {
				sb.append(data).append(" ");
			}
			sb.append("\n");
			return; // 탐색 종료
		}

/*
		for (int i = start; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output.add(i);
				backTrack(depth + 1, i + 1);    // 미래 탐색
				// 과거 되돌아가서 탐색
				visited[i] = false;
				output.remove(output.size() - 1);
			}
		}
*/
		// 방문 여부 visited 체크 할 필요 없음
		for (int i = start; i <= N; i ++) {
			output.add(i);
			backTrack(depth + 1, i + 1); // 다음 요소 탐색
			
			// 회귀 탐색
			output.remove(output.size() - 1);
		}
	}
}