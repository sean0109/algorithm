package main.codingtest.baekjoon.gold;

/*
문제 : 좋다
알고리즘 : 투포인터, 이분탐색, 정렬
난이도 : 골드 4
시간제한 : 2초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_tier4_1253 {

	private void solve_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		int left = 0;
		int right = 0;
		int sum = 0;
		int target = 0;
		int cnt  = 0;
		boolean flag = false;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for(int i = 0; i < n; i++){
			left = 0;
			right = n - 1;
			target = arr[i];

			// "좋은" 수 검증
			while(left < right){
				if(left == i){
					left ++;
					continue;
				}

				if(right == i){
					right--;
					continue;
				}

				sum = arr[left] + arr[right];
				if(sum < target){
					left ++;
				}else if(sum > target){
					right --;
				}else{
					cnt ++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier4_1253().solve_1();
	}
}