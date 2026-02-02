package main.codingtest.programmers.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



// 코딩테스트 연습 > 연습문제 > 문자열 내 마음대로 정렬하기
/*
	# 문제 설명
	문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 
	각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
	예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 
	각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
	
	# 제한조건
	
	1. strings는 길이 1 이상, 50이하인 배열입니다.
	2. strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
	3. strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
	4. 모든 strings의 원소의 길이는 n보다 큽니다.
	5. 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
	
	# 입출력 예
																
			strings				n				return
	["sun", "bed", "car"]		1		["car", "bed", "sun"]
	["abce", "abcd", "cdx"]		2		["abcd", "abce", "cdx"]
			
	# 입출력 예 설명
	
	입출력 예 1
	"sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다. 
	이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.
	
	입출력 예 2
	"abce"와 "abcd", "cdx"의 2번째 인덱스 값은 "c", "c", "x"입니다. 
	따라서 정렬 후에는 "cdx"가 가장 뒤에 위치합니다. 
	"abce"와 "abcd"는 사전순으로 정렬하면 "abcd"가 우선하므로,
	답은 ["abcd", "abce", "cdx"] 입니다.

*/

public class Solution_008 {
	
	
	String removeValue = "";
	
	public static void main(String[] args) {
		System.out.println("Solution_008 Start");
		
		String [] exArr_1 = {"sun", "bed", "car"};
		String [] exArr_2 = {"abce", "abcd", "cdx"};
		int exN_1 = 1;
		int exN_2 = 2;
		
		/*solution 1*/
		
		//String[] answer_1 = solution_1(exArr_1, exN_1);
		//String[] answer_2 = solution_1(exArr_2, exN_2);
		
		//System.out.println("answer_1 : " + Arrays.toString(answer_1));				// ["car", "bed", "sun"]
		//System.out.println("answer_2 : " + Arrays.toString(answer_2));			// ["abcd", "abce", "cdx"]
		
		
		/*solution 2*/
		
		String[] answer_1 = solution_2(exArr_1, exN_1);
		String[] answer_2 = solution_2(exArr_2, exN_2);
		
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
				// 주어진 배열의 n번째 문자열의 값이 색출한 tempArr_1 배열의 값과 같으면 
				if(String.valueOf(strings[k].charAt(n)).equals(String.valueOf(tempArr_1[i]))) {
					// answer 배열에 추가
					answer[i] = strings[k];	
					t1.removeValue = strings[k];
					break;
				}
			}
			//strings = Arrays.stream(strings).filter(item-> ! item.equals(t1.removeValue)).toArray(String[] :: new);
		}
		return answer;
	}
	
	// 풀이 2 ("u,sun", "a,car", "e,bed" 형식으로 list에 저장 하여 문제 해결해 보기 )
	public static String[] solution_2(String[] strings, int n) {
		
		System.out.println("solution_2 method start");
		
		//ArrayList<String> list = new ArrayList<>();
		
		List<String> tempList = new ArrayList<>();
		String[] answer = new String[strings.length];
		
		
		for(int i = 0; i < strings.length; i ++) {
			tempList.add(strings[i].charAt(n) + "," + strings[i]);
		}
		
		Collections.sort(tempList);
		
		for(int i = 0; i < tempList.size(); i ++) {
			String tempVal = "";
			answer[i] = tempList.get(i).split(",")[1];
			
		}
		
		for(int i = 0; i < answer.length; i ++) {
			System.out.println("answer : " + answer[i]);
		}
		
		return answer;
		
	}
	
}