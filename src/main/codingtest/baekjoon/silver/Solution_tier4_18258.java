package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
문제 : 큐2
난이도 : 실버4
알고리즘 : 자료구조, 큐
시간제한 : 1초
*/

public class Solution_tier4_18258 {
	
	private void solution_1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> deque_1 = new LinkedList<Integer>();
		
		int loop = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < loop; i ++) {
			String command = br.readLine();
			doCommand_1(deque_1, command, sb);
		}
		
		System.out.println(sb);
	}
	
	private void doCommand_1(Deque<Integer> deque, String command, StringBuilder sb) throws Exception{
		
		StringTokenizer st = new StringTokenizer(command);
		String commandName = st.nextToken();
		int commandData = 0;
		
		if(st.hasMoreTokens()) {
			commandData = Integer.parseInt(st.nextToken());
		}
				
		if("push".equals(commandName)) {
			
			deque.offerFirst(commandData);
		}
		
		if("pop".equals(commandName)) {
			sb.append((deque.isEmpty() == true) ? -1 : deque.pollLast()).append('\n');
		}
		
		if("size".equals(commandName)) {
			sb.append(deque.size()).append('\n');
			
		}
		
		if("empty".equals(commandName)) {
			sb.append((deque.isEmpty() == true) ? 1 : 0).append('\n');
		}
		
		if("front".equals(commandName)) {
			sb.append((deque.isEmpty() == true) ? -1 : deque.peekLast()).append('\n');
		}
		
		if("back".equals(commandName)) {
			sb.append((deque.isEmpty() == true) ? -1 : deque.peekFirst()).append('\n');
		}
	}
	
	// 배열로 구현
	private static void solution_2() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		System.out.println(Integer.MAX_VALUE);
		
		int[] queue = new int[2000001];
		int front = 0;
		int rear = 0;
		
		
		int loop = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < loop; i ++) {
			//String fullCommand = br.readLine()
			StringTokenizer st = new StringTokenizer( br.readLine());
			String commandName = st.nextToken();
			int commandData = 0;
			if(st.hasMoreTokens()) {
				commandData = Integer.parseInt(st.nextToken());
			}
			
			if("push".equals(commandName)) {
				//deque.offerFirst(commandData);
				queue[rear++] = commandData;
			}
			
			if("pop".equals(commandName)) {
				//sb.append((deque.isEmpty() == true) ? -1 : deque.pollLast()).append('\n');
				//queue[front++];
				sb.append(queue[front++]);
			}
			
			if("size".equals(commandName)) {
				//sb.append(deque.size()).append('\n');
			}
			
			if("empty".equals(commandName)) {
				//sb.append((deque.isEmpty() == true) ? 1 : 0).append('\n');
			}
			
			if("front".equals(commandName)) {
				//sb.append((deque.isEmpty() == true) ? -1 : deque.peekLast()).append('\n');
			}
			
			if("back".equals(commandName)) {
				//sb.append((deque.isEmpty() == true) ? -1 : deque.peekFirst()).append('\n');
			}
		}	
	}
	
	
		
	public static void main(String[] args) throws Exception{
		//new Solution_18258().solution_1();	// deque 이용
		
		new Solution_tier4_18258().solution_2();	// 배열 이용
		
	}
}


 