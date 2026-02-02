package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


/* 
문제 : 회전하는 큐
알고리즘 : 자료구조, 덱
난이도 : 실버 3
시간제한 : 2초
*/

public class Solution_tier3_1021 {
	
	private void solution_1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int data = Integer.parseInt(st.nextToken());
		int lp = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i = 1; i <= data; i ++) {
			deque.offerLast(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int calCount = 0;
		
		for(int i = 0; i < lp; i ++) {
			int target = Integer.parseInt(st.nextToken());
			String command = findFastWay(deque, target);
			
			while(deque.peekFirst() != target) {
				
				switch (command) {
				case "first" : 
					deque.offerLast(deque.pollFirst());
					
					break;
					
				case "last" :
					deque.offerFirst(deque.pollLast());
					
					break;
				}
				calCount++;
			}			
			deque.pollFirst();
		}
		System.out.println(calCount);
	}
	
	private String findFastWay(LinkedList deque, int target) {
		
		int left = 0; int right = deque.size()-1;
		int leftCount = 0; int rightCount = 0;
		
		for(int i = 0; i < deque.size(); i ++) {
			
			int getFirst = (int)deque.get(left++);
			
			if(getFirst == target) {
				break;
			}else {
				leftCount++;
			}
			
			int getRight = (int)deque.get(right--);
			
			if(getRight == target) {
				break;
			}else{
				rightCount++;
			}
		}
		
		return leftCount <= rightCount ? "first" : "last";
		
	}
	
	// indexOf를 써서 target 위치를 파악해서 탐색방향 결정
	private void solution_2() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int data = Integer.parseInt(st.nextToken());
		int lp = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i = 1; i <= data; i ++) {
			deque.offerLast(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int calCount = 0;
		
		for(int i = 0; i < lp; i ++) {
			
			int target = Integer.parseInt(st.nextToken());
			int targetIndex = deque.indexOf(target);
			int halfIndex = deque.size() / 2;
			
			// 타겟의 인덱스가 중간지점보다 앞에 있을때, 
			if(targetIndex <= halfIndex) {
				while(deque.peekFirst() != target) {
					deque.offerLast(deque.pollFirst());
					calCount++;
				}
			}else {
				while(deque.peekFirst() != target) {
					deque.offerFirst(deque.pollLast());
					calCount++;
				}
			}
			deque.pollFirst();
		}
		
		System.out.println(calCount);

	}

	public static void main(String[] args) throws Exception{
		new Solution_tier3_1021().solution_1();
		new Solution_tier3_1021().solution_2();
	}
}