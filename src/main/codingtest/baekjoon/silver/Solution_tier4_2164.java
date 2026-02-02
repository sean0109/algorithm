package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
	문제 : 카드2
	난이도 : 실버 4
	알고리즘 : 자료구조, 큐
	시간제한 : 2초
*/

public class Solution_tier4_2164 {
	
	private void solution_1() throws Exception {
		Scanner sc = new Scanner(System.in);
		int lp = sc.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i = 1; i < lp+1 ; i ++) {
			deque.offer(i);
		}
		
		int flag = 0;
		
		while(deque.size() != 1) {
			
			switch(flag) {
				case 0 :
					deque.poll();
					flag = 1;
					break;
				case 1 :
					deque.offer(deque.poll());
					flag = 0;
					break;
			}
		}
		
		System.out.println(deque.peek());
		
		sc.close();
		
	}

	private static void solution_2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Integer> input = new ArrayList<>();

		for(int i = 1; i < n+1; i++) {
			input.add(i);
		}

		Cards myCards = new Cards(input);

		while(myCards.getCardDeck().size() > 1){
			myCards.disCard().moveCard();
		}
		System.out.println(myCards.getCardDeck().pop());

	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier4_2164().solution_1();
	}
}

class Cards{

	private final Deque<Integer> cardDeck;  // 카드 덱

	public Cards(List<Integer> cardDeck) {
		this.cardDeck = new ArrayDeque<>(cardDeck);
	}

	public Deque<Integer> getCardDeck() {
		// 방어적 복사 (외부에서 변경 안되도록)
		return  new ArrayDeque<>(this.cardDeck);
	}

	// 카드 버리기
	public Cards disCard(){
		if(!this.cardDeck.isEmpty()){
			this.cardDeck.pollFirst();
		}
		return this;
	}

	// 제일 위에 카드 아래로 옮기기
	public Cards moveCard(){
		if(!this.cardDeck.isEmpty()){
			this.cardDeck.offerLast(this.cardDeck.pollFirst());
		}
		return this;
	}
}

 