package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
문제 : 소트인사이트
난이도 : 실버 5
알고리즘 : 문자열, 정렬
시간제한 : 2초
*/

public class Solution_tier5_1427 {
	
	// 선택 정렬 방식
	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int index = 0;
	
		int [] arr = new int[input.length()];
		
		for(char c : input.toCharArray()) {
			arr[index++] = c - 48;	// 아스키코드 0 값 빼줌
		}
		
		// 선택 정렬 방식
		for(int i = 0; i < arr.length - 1; i ++) {
			int maxIndex = i;
			
			for(int j = i + 1; j < arr.length; j ++) {
				if(arr[maxIndex] < arr[j]) {
					maxIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = temp;
		}
		
		// 출력
		for(int n : arr) {
			System.out.print(n);
		}
	}
	
	// sort 함수 이용
	private void solution_2() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int index = 0;
	
		Integer [] arr = new Integer[input.length()];
		
		for(char c : input.toCharArray()) {
			arr[index++] = c - 48;	// 아스키코드 0 값 빼줌
		}
		
		
		
		/*Comparator<Integer> comp = new Comparator<Integer>() {
		
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		};*/
		
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		
		// 출력
		for(int n : arr) {
			System.out.print(n);
		}
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier5_1427().solution_1();
	}
}