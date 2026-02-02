package main.codingtest.programmers.levelone;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

/*자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 
답이 항상 존재함은 증명될 수 있습니다.*/


public class Solution_003 {
	public static void main(String[] args) {
		
		/*try {
			
			num_var = sc.nextInt();
			
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력해 주세요.");
			e.printStackTrace();
		}*/
		
		boolean flag = false;
		int num_var = 0;
		
		do {
			
			//boolean flag = false;
			//int num_var = 0;
			
			try {
				Scanner sc = new Scanner(System.in);
				num_var = sc.nextInt();
				
				flag = true;
				
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력해 주세요.");
			}
			
			
		}while(!flag);
		
		
		
		 
		
		Solution_003 sol = new Solution_003();
		
		int answer = sol.solution(num_var);
		
		//int answer2 = sol.solution2(num_var);
		
		
		System.out.println("정답은: " + answer);
		//System.out.println("정답은 : " + answer2);
	}
	
	// 풀이 1
	public int solution(int n) {
		int answer = 0;
		
		int x = 1;
		int y = 0;
		
		do {
			y = n % x;
			
			if(y != 1) {
				x ++;
			}
			
		} while (y != 1);
		
		answer = x; 
		
		return answer;
	}
	
	// 풀이 2
	public int solution2(int n) {
		
		return IntStream.range(2, n).filter(i -> n % i == 1).findFirst().orElse(0);
	}
	
	// 풀이 3
	public int solution3(int n) {
		
		
		int answer = 1;
		
		do {
			answer++;
			
		}while(n % answer != 1);
		
		return answer;
	}
	
}