package main.codingtest.programmers.levelone;

import java.util.ArrayList;
import java.util.Arrays;


public class Solution_009 {
	
	
	String removeValue = "";
	
	public static void main(String[] args) {
		System.out.println("Solution_009 Start");

		
	}
	
	// 풀이 1 
	public static String[] solution_1(String[] strings, int n) {
		
		String[] answer = new String [strings.length];
		// 1. 먼저 해당 n 번째 문자열을 꺼내서 temp 배열에 저장하고, 오름차순으로 정렬
		// 2. temp 배열에서 순서대로 꺼내면서 strings 에 있는 단어를 contains로 비교 하여 색출
		// 3. 새로운 answer 배열에 하나씩 push 한다고 생각.
		// 4. 꺼낼 때 strings의 배열에 있는 값 제거
		// 중복된 값이 있을 경우?
		
		Arrays.sort(strings);	//주어진 배열을 먼저 오름차순 정렬
		char [] tempArr_1 = new char [strings.length];
		char tempChar;
		
		for(int i = 0; i < strings.length; i ++) {
			tempChar =  strings[i].charAt(n);
			System.out.println("tempChar : " + tempChar);
			tempArr_1[i] = tempChar; 
		}
		
		System.out.println("arrays to string : " + Arrays.toString(tempArr_1));
		
		Solution_008 t1 = new Solution_008();
		
		Arrays.sort(tempArr_1);		// n 번째 값으로 만든 배열을 오름차순 정렬
		
		
		// tempArr_1 
		for(int i = 0; i < tempArr_1.length; i ++) {
			for(int k = 0; k < tempArr_1.length; k ++) {
				if(String.valueOf(strings[k].charAt(n)).equals(String.valueOf(tempArr_1[i]))) {
					// answer 배열에 추가
					answer[i] = strings[k];
					t1.removeValue = strings[k];
					break;
				}
			}
			strings = Arrays.stream(strings).filter(item-> ! item.equals(t1.removeValue)).toArray(String[] :: new);
		}
		return answer;
	}
	
	// 풀이 2 ("u,sun", "a,car", "e,bed" 형식으로 list에 저장 하여 문제 해결해 보기 )
	public static String[] solution_2(String[] strings, int n) {
		
		System.out.println("solution_2 method start");
		
		ArrayList<String> list = new ArrayList<>();
		
		return null;
	}
	
}