package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 
[문제]
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 
이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 
가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다. 
둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.

[출력]
첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.

[예제 입력 1]
10 15
5 1 3 5 10 7 4 9 2 8

[예제 출력 1]
2

*/

public class Solution_tier4_1806 {
	
	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> tempList = new ArrayList();
		int answer = 0;
		
		
		int length = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		
		int[] intArray_1 = new int[length];
		StringTokenizer st_2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < length; i ++) {
			intArray_1[i] = Integer.parseInt(st_2.nextToken());
		}
		
		int count = 0;
		
		for(int i = 0; i < length; i ++) {
			answer = intArray_1[i];
			
			if(answer > 15) {
				tempList.add(1);
				break;
			}
			count = 1;
			for(int j = i+1; j < length; j ++) {
				answer += intArray_1[j];
				count ++;
				if(answer >= sum) {
					tempList.add(count);
					break;
				}
			}
		}
		
		if(tempList.size() == 0) {
			System.out.println(0);
		}else {
			Collections.sort(tempList);
			System.out.println(tempList.get(count));
		}
	}
	
	private void solution_2() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int [] intArr_1 = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < intArr_1.length; i ++) {
			intArr_1[i] = Integer.parseInt(st.nextToken());
		}
		
		// 투 포인터를 이용
		int left = 0; int right = 0; int sum = 0;
		int minLen= intArr_1.length + 1;
		
		//right이 배열의 끝까지 갈 때 까지
		while(right < intArr_1.length) {
			sum += intArr_1[right++];
			
			// 조건을 만족할 때마다 왼쪽 포인터 줄이기 (최소 길이 찾기)
			while(sum >= s) {
				minLen = Math.min(minLen, right - left);
				sum -= intArr_1[left++];
			}
		}
		
		int answer = (minLen == intArr_1.length + 1) ? 0 : minLen;
		
		System.out.println("answer : " + answer);
		
		
	}
	
		
	public static void main(String[] args) throws Exception{
		
		//new Solution_1806().solution_1();
		new Solution_tier4_1806().solution_2();
	}
	
}


 