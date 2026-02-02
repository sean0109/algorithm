package main.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_tier2_2750 {
	
	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int lp = Integer.parseInt(br.readLine());
		
		int [] arr = new int[lp];
		
		for(int i = 0; i < lp; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		boolean swapped = false;
		// 버블정렬
		for(int i = 0; i < lp - 1; i ++) {
			swapped = false;
			for(int j = 0; j < lp - i - 1; j ++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) break;
		}
		
		for(int a : arr) {
			System.out.println(a);
		}
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier2_2750().solution_1();
	}
}