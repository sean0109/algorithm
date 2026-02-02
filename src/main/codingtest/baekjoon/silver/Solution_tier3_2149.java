package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
/*
문제 : 암호 해독
알고리즘 : 구현, 문자열, 정렬
난이도 : 실버 3
시간제한 : 2초
*/

public class Solution_tier3_2149 {
	
	private void solve_1() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		/*String key = br.readLine();
		String encodeStr = br.readLine();*/
		String key = "BATBOY";
		String encodeStr = "EYDEMBLRTHANMEKTETOEEOTH";
		int keyLen = key.length();
		int encodeStrLen = encodeStr.length();

		Object [][] keyArr = new Object[keyLen][2];
		Character [] encodeStrArr = new Character[encodeStrLen];

		for(int i = 0; i < keyLen; i++){
			keyArr[i][0] = key.charAt(i);
			keyArr[i][1] = i;
		}

		Arrays.sort(keyArr, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return (Character) o1[0] - (Character) o2[0];
			}
		});

		for(int i = 0; i < encodeStrLen; i++){
			encodeStrArr[i] = encodeStr.charAt(i);
		}

		Queue<Character> encodeStrQueue = new LinkedList<Character>();
		for(Character c : encodeStrArr){
			encodeStrQueue.offer(c);
		}

		Object [][] encodeChart = new Object [keyLen][encodeStrLen / keyLen + 2];

		int loop = 0;
		for(int i = 0 ; i < keyLen; i++){
			encodeChart[i][0] = (Character) keyArr[i][0];
			encodeChart[i][1] = (Integer) keyArr[i][1];
			for(int j = 2 ; j < encodeStrLen / keyLen + 2; j ++){
				encodeChart[i][j] = encodeStrQueue.poll();
			}
		}

		// encodeChart[i][1] 로 다시 오름차순 정렬 해서 복호화
		Arrays.sort(encodeChart, ( o1, o2 )->{
			return (int)o1[1] - (int) o2[1];
		});

		// 출력
		for(int j = 2; j < encodeChart.length; j ++){
			for(int i = 0 ; i < encodeChart.length; i ++){
				sb.append(encodeChart[i][j]);
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier3_2149().solve_1();
	}
}