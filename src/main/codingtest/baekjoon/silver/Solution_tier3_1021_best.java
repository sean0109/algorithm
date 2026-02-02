package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* 
문제 : 회전하는 큐
알고리즘 : 자료구조, 덱
난이도 : 실버 3
시간제한 : 2초
*/

public class Solution_tier3_1021_best {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Deque<Integer> deque = new LinkedList<>();

		for(int i = 1; i <= N; i++){
			deque.offerLast(i);
		}

		st = new StringTokenizer(br.readLine());
		// index와 deque 의 사이즈로 탐색 방향 결정

		int calculateCount = 0;

		while(M-- > 0){

			// 유효성 검사 (탐색 강제 종료 조건) : deque가 비어있을 때
			if(deque.isEmpty()){
				break;
			}

			int target = Integer.parseInt(st.nextToken());

			// target의 index 확인
			int index = 0;
			for(int q : deque){
				if(q == target){
					break;
				}
				index ++;
			}

			int left = index;
			int right = deque.size() - index;

			// deque의 size와 index를 비교하여 2번 연산 할건지 3번 연산을 할건지 정하기
			if(left <= right){	// 왼쪽 처음부터의 거리가 더 짧을 경우

				for(int i = 0 ; i < left; i ++){
					deque.offerLast(deque.pollFirst());
				}

			}else{	// 오른쪽 끝에서부터의 거리가 더 짧을 경우
				for(int i = 0 ; i < right; i ++){
					deque.offerFirst(deque.pollLast());
				}
			}
			deque.pollFirst();
			calculateCount += Math.min(left, right);
		}
		System.out.println(calculateCount);
	}
}