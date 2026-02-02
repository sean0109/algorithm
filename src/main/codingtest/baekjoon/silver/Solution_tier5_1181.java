package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
	문제 : 단어 정렬
	난이도 : 실버 5
	알고리즘 : 정렬
	시간제한 : 2초
*/

public class Solution_tier5_1181 {

	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<String> list = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++){
			list.add(br.readLine());
		}

		list.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));

		for(String s : list){
			sb.append(s).append("\n");
		}

		System.out.println(sb);

	}

	private void solution_2() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Set<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++){
			set.add(br.readLine());
		}
		Comparator<String> stringComparator = Comparator.comparing(String::length).thenComparing(String::compareTo);

		List<String> sortedList = set.stream().sorted(stringComparator).collect(Collectors.toList());


		for(String s : sortedList){
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier5_1181().solution_1();

	}
}
 