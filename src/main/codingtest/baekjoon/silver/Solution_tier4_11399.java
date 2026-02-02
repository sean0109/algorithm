package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 

문제 : ATM
난이도 : 실버 4
알고리즘 : 그리디 알고리즘, 정렬
시간제한 : 1초

*/

public class Solution_tier4_11399 {
	
	// 1. 삽입 정렬
	private void solve_1() throws Exception {
		System.out.println("삽입 정렬");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[count];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i = 1; i < arr.length; i ++) {
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j --;
			}
			
			arr[j + 1] = key;

		}
		
		int sum = 0;
		int total = 0;
		for (int n : arr) {
           sum += n;
           total += sum;
		}
		
		System.out.println(total);		
	}
	
	// 2. 버블 정렬
	private void solve_2() throws Exception{
		System.out.println("버블 정렬");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[count];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		boolean swapped = false;
		
		for(int i = 0; i < arr.length - 1; i ++) {
			
			swapped = false;
			
			for(int j = 0; j <arr.length - i - 1; j ++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp; 
					swapped = true;
				}
			}
			if(!swapped) break; 
		}
		
		int sum = 0;
		int total = 0;
		for (int n : arr) {
           sum += n;
           total += sum;
		}
		
		System.out.println(total);	
	}
	
	// 3. 선택 정렬
	private void solve_3() throws Exception{
		System.out.println("선택정렬");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[count];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i = 0 ; i < arr.length - 1; i ++) {
			int minIndex = i;
			
			for(int j = i + 1; j < arr.length; j ++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		int sum = 0;
		int total = 0;
		for (int n : arr) {
           sum += n;
           total += sum;
		}

		System.out.println(total);
	}
	

	public static void main(String[] args) throws Exception{
		//new Solution_11399().solve_1();
		//new Solution_11399().solve_2();
		new Solution_tier4_11399().solve_3();
	}
}