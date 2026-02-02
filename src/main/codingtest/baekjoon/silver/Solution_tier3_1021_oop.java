package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


/* 
문제 : 회전하는 큐
알고리즘 : 자료구조, 덱
난이도 : 실버 3
시간제한 : 2초
*/

public class Solution_tier3_1021_oop {
	private static class RotationQueue {

		private Deque<Integer> deque;

		private int moveLeft;           // 2번연산 : 왼쪽으로 한칸 이동 시킴
		private int moveRight;          // 3번연산 : 오른쪽으로 한칸 이동 시킴

		private RotationQueue(Integer[] arr) {
			//this.deque = deque;
			this.deque = new LinkedList<>(Arrays.asList(arr));
		}

		private void calculation(int target){

			// 1. 현재 큐에서 target의 탐색 방향을 결정

			Deque<Integer> copyDeque = new LinkedList<>(deque);

			int leftCnt = -1;   // 2번연산 왼쪽이동 연산 수행 카운트 :  target이 바로 왼쪽 첫번째에 있을때는 이동시킬 필요가 없으므로 -1에서 시작
			int peekLeft = 0;

			int rightCnt = 0;   // 3번연산 오른쪽이동 연산 수행 카운트
			int peekRight = 0;

			String calWay = "";

			while(!copyDeque.isEmpty()){
				peekLeft = copyDeque.peekFirst();
				peekRight = copyDeque.peekLast();

				copyDeque.pollFirst();
				copyDeque.pollLast();

				leftCnt ++;
				rightCnt ++;

				if(peekLeft == target){
					calWay = "LEFT";
					break;
				}

				if(peekRight == target){
					calWay = "RIGHT";
					break;
				}

			}

			// 2. 왼쪽에 있을경우
			if("LEFT".equals(calWay)){
				// 2번 연산 수행 : 계산량 만큼 진행 후,  poll
				for(int i = 0; i < leftCnt; i++){
					deque.addLast(deque.pollFirst());
					moveLeft ++;
				}
				deque.pollFirst();


				// 3. 오른쪽에 있을 경우
			}else {
				// 3번 연산 수행 : 계산량 만큼 진행후, poll
				for(int i = 0; i < rightCnt; i++){
					deque.addFirst(deque.pollLast());
					moveRight ++;
				}
				deque.pollFirst();
			}

		}
	}


	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];

		for(int i = 0; i < N; i++ ) {
			arr[i] = i+1;
		}

		st = new StringTokenizer(br.readLine());
		RotationQueue rotationQueue = new RotationQueue(arr);

		for(int i = 0; i < M; i++) {
			rotationQueue.calculation(Integer.parseInt(st.nextToken()));
		}

		System.out.println(rotationQueue.moveRight + rotationQueue.moveLeft);
	}
}