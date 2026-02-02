package main.codingtest.programmers.levelone;

import java.util.Scanner;

/*정수 num1과 num2가 주어질 때, num1과 num2의 합을 return하도록 soltuion 함수를 완성해주세요.*/

public class Solution_002 {
    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	
	    	int num1 = sc.nextInt();
	    	int num2 = sc.nextInt();
	    	
	    	System.out.println("num1 : " + num1);
	    	System.out.println("num2 : " + num2);
	    	
    		//Solution doSolution = new Solution(num1, num2);
    		
    		//doSolution(num1, num2);
	}
}


class Solution {
	
	public Solution(int num1, int num2){
	}
	
	
	public int solution(int num1, int num2) {
		
		int answer = num1 + num2;
			
		System.out.println("두 정수의 합은 : " + answer + " 입니다.");
		return answer;
		
	}
}

 