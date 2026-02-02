package main.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 스택
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		int val = stack.pop();
		System.out.println(val);
		System.out.println("stack : " + stack);
		
		// 큐
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(2);
		queue.offer(1);
		queue.offer(3);
		int val_2 = queue.poll();
		System.out.println("val_2 : " + val_2);
		System.out.println("peek : " + queue.peek());
		System.out.println("queue : " + queue);
		
		// 덱큐
		Deque<Integer> deque = new LinkedList <>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addLast(6);
		deque.addLast(5);
		deque.addLast(4);

		System.out.println("deque size : " + deque.size());
		System.out.println("deque content : " + deque);
		while(!deque.isEmpty()) {
			System.out.println(deque.pollFirst());
		}	
	}

}
