package main.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
문제 : 분해합
알고리즘 : 완전탐색, 브루트포스
시간제한 : 2초
난이도 : 브론즈 2
*/

public class Solution_tier2_2231 {
	
	private void solve_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int cons = 0;

		for(int i = 0; i < n; i++){
			sum = 0;
			sum = i + sumEach(i);
			if(sum == n){
				cons =i;
				break;
			}
		}

		System.out.println(cons);
	}

	private int sumEach(int i) {

		String number = Integer.toString(i);
		int sum = 0;

		for(char c : number.toCharArray()){
			int n = c - 48;
			sum += n;
		}
		return sum;
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier2_2231().solve_1();
	}
}