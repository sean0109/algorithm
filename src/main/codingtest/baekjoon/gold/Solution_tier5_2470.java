package main.codingtest.baekjoon.gold;

/*
문제 : 두 용액
알고리즘 : 이분탐색 , 투포인터
난이도 : 골드 5
시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_tier5_2470 {

	private void solve_1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;
		// 두 수의 합의 절대값이 가장 작은 값.
		int sum = 0;
		int save = arr[right];	// 저장할 sum
		int leftval = 0;
		int rightval = 0;

		while(left < right){
			sum = arr[left] + arr[right];
			if(Math.abs(sum) < save) {
				save  = Math.abs(sum);
				leftval = arr[left];
				rightval = arr[right];
			}

			if(sum > 0){
				right --;
			}else if (sum < 0){
				left ++;
			}else{
				return;
			}
		}
		System.out.println(leftval + " " + rightval);
	}


	public static void main(String[] args) throws Exception{
		new Solution_tier5_2470().solve_1();
	}
}