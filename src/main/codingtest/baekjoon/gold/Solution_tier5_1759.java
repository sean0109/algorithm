package main.codingtest.baekjoon.gold;

/*
문제 : 암호만들기
알고리즘 : 백트래킹 / 브루트포스
난이도 : 골드 5
시간제한 : 2초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_tier5_1759 {

	private int L;	// depth
	private int C;	// 문자 개수
	private boolean[] visited;	// 탐색여부 체크
	private Character [] charArray;
	private List<Character> output = new ArrayList<Character>();
	StringBuilder sb = new StringBuilder();

	private void solve_1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		charArray = new Character[C];
		visited = new boolean[C];

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < C; i ++){
			charArray[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(charArray);

		backtrack(0, 0);
		System.out.println(sb);
	}

	private void backtrack(int depth, int fromIndex) {

		if(depth == L){
			if(validation(output)){
				for(char c : output){
					sb.append(c);
				}
				sb.append('\n');
			}
			return;
		}

		for(int i = fromIndex; i < C; i ++){
			output.add(charArray[i]);
			backtrack(depth + 1, i+1);
			output.remove(output.size() - 1);
		}
	}

	private boolean validation(List<Character> output) {
		int moum = 0;
		int zaum = 0;

		for(char c : output){
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
				moum++;
			}else{
				zaum++;
			}
		}

		if(moum > 0 && zaum > 1){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier5_1759().solve_1();
	}
}