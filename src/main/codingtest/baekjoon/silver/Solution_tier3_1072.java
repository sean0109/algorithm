package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
	문제 : 게임
	알고리즘 : 수학, 이분탐색
	난이도 : 실버 3
	시간제한 : 2초
*/

public class Solution_tier3_1072 {

	private static void solve() {


	}


	private static void MyWorngAnswer() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Z = (int)Math.floor((double)Y / X * 100);		// *** 문제점 : 부동

		// 이분탐색 left, right 값 구하기
		int left = 1;
		// 탐색 최대 값 : 지금까지 한 게임 횟수만큼 더 하고, 다 이겼으면, 무조건 변하게 되있음
		int right = X;
		int answer = left;	// 정답

		// 최대로 더 할 수 있는 게임 회수만큼 했는데도 안 변하면 return
		if(((Y+X) * 100 / (X+X))  == Z){
			System.out.println(-1);
			return;
		}
		
		// 1 %가 변하는 최소 게임 회수 구하기
		while(left <= right){
			int mid = (right + left) / 2;

			// 새로운 승률 계산
			int nZ = (int)Math.floor((double)(Y + mid) / (X + mid) * 100);

			int increment = nZ - Z;

			if(increment >= 1){
				right = mid - 1;
				answer = mid;
			}else{
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception{
		solve();
	}
}