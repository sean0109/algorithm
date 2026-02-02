package main.codingtest.baekjoon.gold;

/*
	문제 : 카드 정렬하기
	알고리즘 : 자료구조, 그리디알고리즘, 우선순위큐
	난이도 : 골드 4
	시간제한 : 2초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_tier4_1715 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> cards = new PriorityQueue<>();	// 우선순위 큐 사용

		for(int i = 0; i < N; i++){
			cards.offer(Integer.parseInt(br.readLine()));
		}
		
		if(N <= 1){
			System.out.println(0);	// 카드 뭉치가 1개 이하면 비교할거 없으므로 비교 횟수는 0번
			return;
		}

		int sum = 0;	// 누적 비교 회수
		int plus = 0;	// 새롭게 만들어지는 카드 뭉치
		
		// 카드뭉치가 2개 이상
		while(cards.size() > 1){
			plus = cards.poll() + cards.poll();
			sum += plus;
			if(cards.isEmpty()){
				break;
			}
			cards.offer(plus);
		}
		System.out.println(sum);
	}
}