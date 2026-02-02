package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 함수형 인터페이스를 활용하여 풀어보자
public class Solution_tier4_18258_plus {

	@FunctionalInterface
	interface QueueFunction {
		int function(Deque<Integer> deque, int input);
	}

	private QueueFunction makeFunction(String doWhat) {

		switch (doWhat) {
			case "push" :
				return (deque, input) -> {
					deque.offer(input);
					return 1;
				};
			case "pop" :
				return (deque, input) ->deque.isEmpty() ? -1 : (int)deque.poll();

			case "size" :
				return (deque, input) -> deque.size();

			case "empty" :
				return (deque, input) -> deque.isEmpty() ? 1 : 0;

			case "front" :
				return (deque, input) -> deque.isEmpty() ? -1 : (int)deque.peek();

			case "back" :
				return (deque, input) -> deque.isEmpty() ? -1 : (int)deque.peekLast() ;

			default : return null;
		}
	}

	private void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int cnt = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();

		for(int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String doWhat = st.nextToken();
			int data = 0;
			if(st.hasMoreTokens()) {
				data = Integer.parseInt(st.nextToken());
			}
			int output = makeFunction(doWhat).function(deque, data);
			if(!doWhat.equals("push")) {
				sb.append(output).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier4_18258_plus().solve();
	}
}


 