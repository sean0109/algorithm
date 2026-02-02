package main.codingtest.baekjoon.gold;

/*
문제 : 미친로봇
알고리즘 : 백트래킹
난이도 : 골드 4
시간제한 : 1초
*/

import java.util.Scanner;

public class Solution_tier4_1405 {

/*
	[수학 힌트, 포인트]
	1. 어떤 사건이 연속으로 일어날 확률 은 "곱하기"
	- 즉, 해당 문제에서 로보트가 동쪽으로 이동하고, 이어서 남쪽으로 이동할 확률 = 동쪽 이동 확률 * 남쪽 이동 확률
	- A와 B가 동시에 일어날 확률 → P(A n B) = P(A) × P(B) (A, B 독립일 때)
	
	2. 서로 배반 사건(동시에 일어날 수 없는 사건)**일 때는 확률은 "더하기"
	- 해당 문제에서, 각각의 이동 경로가 단순할 확률 은 이동 경로가 단순할 경우의 수를 더해야 함.
	- A 또는 B가 일어날 확률 → P(A u B) = P(A) + P(B) (A, B가 서로 배반일 때)
*/

	// N 값 (몇번을 이동할 것인가)
	private int N;
	// dirProb , 4가지 방향의 확률(실수) 저장 배열
	private double[] dirProb = new double[4]; //문제의 입력 값 x 에 /100
	// visited 배열 저장
	private boolean[][] visited = new boolean[29][29];
	// dx 이동 좌표 배열
	private int[] dx = {1, -1, 0, 0};    // 동, 서, 남, 북
	// dy 이동 좌표 배열
	private int[] dy = {0, 0, -1, 1};    // 동, 서, 남, 북
	// 결과값 저장
	static double result = 0;

	// 확률을 누적
	private void solve_1() throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < 4; i++) {
			dirProb[i] = sc.nextInt() / 100.0;
		}

		visited[14][14] = true; // 시작 위치
		dfs(14, 14, 0, 1.0);

		System.out.println(result);
	}

	private void dfs(int x, int y, int depth, double prob) {
		if (depth == N) {
			result += prob;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, depth + 1, prob * dirProb[d]);
				visited[nx][ny] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Solution_tier4_1405().solve_1();
	}
}