package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제 : 좌표 정렬하기
난이도 : 실버 5
알고리즘 : 정렬
시간제한 : 1초
*/

public class Solution_tier5_11650 {

	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int[n][2];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2)->{
			if(o1[0] != o2[0]) {
				return o1[0] - o2[0];
			}else{
				return o1[1] - o2[1];
			}
		});

		for(int [] obj : arr){
			sb.append(obj[0]).append(" ").append(obj[1]).append("\n");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier5_11650().solution_1();
	}
}