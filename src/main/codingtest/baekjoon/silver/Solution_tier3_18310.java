package main.codingtest.baekjoon.silver;

/*
문제 : 안테나
알고리즘 : 수학, 그리디 알고리즘, 정렬
난이도 : 실버 3
시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_tier3_18310 {
	

	private void solve_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int bestDist = arr[(n-1) / 2];
		System.out.println(bestDist);
	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier3_18310().solve_1();
	}
}