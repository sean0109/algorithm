package main.codingtest.baekjoon.bronze;

/*
	문제 : 피보나치 수 5
	알고리즘 : 수학, 구현, 다이나믹 프로그래밍 (DP)
	시간제한 : 1초
	난이도 : 브론즈 2
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_tier2_10870 {

	private void solve_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n+1];

		for(int i = 0; i < arr.length; i ++){
			if(i == 0){
				arr[i] = 0;
			}else if(i == 1){
				arr[i] = 1;
			}else {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
		}
		System.out.println(arr[n]);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier2_10870().solve_1();
	}
}