package main.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. List의 인터페이스 구현 객체 생성 및 용법
		List list2 = new LinkedList();
		
		List list3 = new ArrayList();
		
		ArrayList arrayList = new ArrayList();
		
		
		for (int i = 0; i < 100; i++) {
		    list2.add(0, "data"); // 앞 노드만 끼워넣으면 됨. 성능 up
		}
		
		for(int i = 0; i < list2.size(); i ++) {
			System.out.println(i + " :" + list2.get(i));
		}
		
		System.out.println("/////////////////////////////////////////////");
		
		for (int i = 0; i < 100; i++) {
		    list3.add(0, "data"); // 앞에 계속 삽입.(매번 배열 전체를 뒤로 밀어야 함) 성능 down
		}
		
		for(int i = 0; i < list2.size(); i ++) {
			System.out.println(i + " :" + list2.get(i));
		}
		
		// 2. 연결 리스트
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		linkedList.add(10);
		linkedList.push(11);
		linkedList.addFirst(12);
		linkedList.addLast(13);
		linkedList.offerLast(14);
		System.out.println("linkedList : " + linkedList);
		linkedList.pop();
		System.out.println("linkedList : " + linkedList);
		linkedList.pollFirst();
		System.out.println("linkedList : " + linkedList);
		linkedList.poll();
		System.out.println("linkedList : " + linkedList);
		
		// 3. deque : double ended queue
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		deque.add(10);
		deque.push(11);
		deque.addFirst(12);
		deque.addLast(13);
		deque.offerLast(14);
		System.out.println("deque : " + deque);
		deque.pop();
		System.out.println("deque : " + deque);
		deque.pollFirst();
		System.out.println("deque : " + deque);
		deque.poll();
		System.out.println("deque : " + deque);
		
		
	}
	
	

}
