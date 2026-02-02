package main.codingtest.programmers.levelone;

import java.util.InputMismatchException;
import java.util.Scanner;

// 코딩테스트 연습 > 연습문제 > 수박수박수박수박수박수?


/*
 * 
 * #문제 설명

길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

# 제한 조건
 n은 길이 10,000이하인 자연수입니다.

입출력 예
	n	return
	3	"수박수"
	4	"수박수박"

*
*/

public class Solution_005 {
	public static void main(String[] args) {
		
		int n = 0;
		boolean flag = false;
		
		do {
			
			System.out.println("정수 n 을 입력해 주세요");
			
			Scanner sc = new Scanner(System.in);
			
			try {
				
				n = sc.nextInt();
				
				flag = true;
				
			}catch(InputMismatchException e) {
				System.out.println("정수만 입력해 주세요");
				e.printStackTrace();
			}
			
		}while(!flag);
		
		
		String answer = solution_3(n);
		
		
		System.out.println("answer 3: " + answer);
		
	}
	
	// 풀이 1
	public static String solution(int n) {
		
		String answer = "";
		
		int flag = 1; 
		
		do {
			// 홀수
			if(flag % 2 != 0) {
				answer += "수";
				
			// 짝수
			}else {
				answer += "박";
			}
			flag += 1;
			
		}while(flag <= n);
		
		
		
		System.out.println("answer : " + answer);
		
		
		return answer;
	}
	
	// 풀이 2
	public static String solution_2(int n) {
		
		String answer = "";
		
		
		for(int i = 0; i < n; i ++ ) {
			
			answer += (i%2 == 0) ? "수" : "박";
			
		}
			
		return answer;
	}
	
	// 풀이 3
	public static String solution_3(int n) {
		
		
		String answer = new String(new char [n/2+1]).replace("\0", "수박");//.substring(0,n);
		
		return answer;
	}
	
}