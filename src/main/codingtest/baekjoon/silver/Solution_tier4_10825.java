package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
	문제 : 국영수
	난이도 : 실버 4
	알고리즘 : 정렬
	시간제한 : 1초
*/

public class Solution_tier4_10825 {
	
	// 1. 배열 사용
	private void solve_1() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cnt = Integer.parseInt(br.readLine());
		
		String[][] score = new String[cnt][4];
		
		
		for(int i = 0; i < cnt; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			score[i][0] = st.nextToken();	// 이름
			score[i][1] = st.nextToken();	// 국어 점수
			score[i][2] = st.nextToken();	// 영어 점수
			score[i][3] = st.nextToken();	// 수학 점수
			
		}
		
		Arrays.sort(score, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				
				String o1_name = o1[0];
				String o2_name = o2[0];
				int o1_kor = Integer.parseInt(o1[1]);
				int o2_kor = Integer.parseInt(o2[1]);
				int o1_eng = Integer.parseInt(o1[2]);
				int o2_eng = Integer.parseInt(o2[2]);
				int o1_mat = Integer.parseInt(o1[3]);
				int o2_mat = Integer.parseInt(o2[3]);
				
				if(o1_kor == o2_kor && o1_eng == o2_eng && o1_mat == o2_mat) {
					return o1_name.toCharArray()[0] - o2_name.toCharArray()[0];
				
				}else if(o1_kor == o2_kor && o1_eng == o2_eng ) {
					return o2_mat - o1_mat;
				
				}else if(o1_kor == o2_kor) {
					return o1_eng - o2_eng;
					
				}else {
					return o2_kor - o1_kor;
				}
			}
			
		});
		
		for(int i = 0 ; i < score.length; i ++) {
			sb.append(score[i][0]);
			
			if(i != score.length - 1) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	// 2. 클래스 사용
	private void solve_2() throws Exception {
		
		class Score {
			
			String name;
			int kor;
			int eng;
			int mat;
			
			public Score(String name, int korean, int english, int math) {
				this.name = name;
				this.kor = korean;
				this.eng = english;
				this.mat = math;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		List<Score> list = new ArrayList<Score>();
		
		for(int i = 0; i < cnt; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Score student = new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list.add(student);
		}
		
		Collections.sort(list, (o1, o2) -> {

			if(o1.kor == o2.kor && o1.eng == o2.eng && o1.mat == o2.mat) {
				return o1.name.toCharArray()[0] - o2.name.toCharArray()[0];
			
			}else if(o1.kor == o2.kor && o1.eng == o2.eng ) {
				return o2.mat - o1.mat;
			
			}else if(o1.kor == o2.kor) {
				return o1.eng - o2.eng;
				
			}else {
				return o2.kor - o1.kor;
			}
		
		});
		
		list.stream().forEach(x->System.out.println(x.name));
		
	}

	// Object 2차원 배열 사용
	private static void solve_3() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Object [][] scores = new Object [n][4];

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++){
				scores[i][j] = st.nextToken();
			}
		}

		Arrays.sort(scores, (score1, score2)->{
			String name1 = (String) score1[0];
			int kor1 = Integer.parseInt((String) score1[1]);
			int eng1 = Integer.parseInt((String)score1[2]);
			int math1 = Integer.parseInt((String)score1[3]);

			String name2 = (String) score2[0];
			int kor2 = Integer.parseInt((String)score2[1]);
			int eng2 = Integer.parseInt((String)score2[2]);
			int math2 = Integer.parseInt((String)score2[3]);

			if(kor1 == kor2 && eng1 == eng2 && math1 == math2){
				return name1.compareTo(name2);

			}else if(kor1 == kor2 && eng1 == eng2){
				return math2 - math1;

			}else if(kor1 == kor2){
				return eng1 - eng2;

			}else{
				return kor2 - kor1;
			}
		});

		for(Object[] score : scores){
			sb.append((String) score[0]).append("\n");
		}

		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		new Solution_tier4_10825().solve_1();
	}
}