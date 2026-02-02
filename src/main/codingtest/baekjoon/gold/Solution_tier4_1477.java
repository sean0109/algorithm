package main.codingtest.baekjoon.gold;

/*
	문제 : 휴게소 세우기
	알고리즘 : 이분 탐색, 매개 변수 탐색
	난이도 : 골드 4
	시간제한 : 2초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_tier4_1477 {

	private void solve_1() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// 휴게소 개수
		int M = Integer.parseInt(st.nextToken());	// 더 지으려고 하는 휴게소 개수
		int L = Integer.parseInt(st.nextToken());	// 고속도로의 길이

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+2];

		arr[0] = 0;
		int i = 1;
		while(st.hasMoreTokens()){
			arr[i++] = Integer.parseInt(st.nextToken());
		}
		arr[N+1] = L;

		// 1. 기존에 설치된 휴게소들 위치를 오름 차순 정렬
		Arrays.sort(arr);

		// 2. 이진 탐색 시작
		int left = 1;
		int right = L;
		int minLen = 0;	// answer

		while(left <= right){
			int mid = (left + right) / 2;	// 거리가 최소가 되도록 가정 하는 길이
			int need = 0;	// 휴게소 설치 개수

			for(int j = 0; j < arr.length - 1; j++){
				need += (arr[j+1] - arr[j] - 1) / mid;
			}

			if (need > M) {
				left = mid + 1;
			} else {
				minLen = mid;
				right = mid - 1;
			}
		}
		System.out.println(minLen);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier4_1477().solve_1();
	}
}