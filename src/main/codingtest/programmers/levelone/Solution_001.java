package main.codingtest.programmers.levelone;

import java.util.Scanner;



/*문제 설명
문자열 str이 주어질 때, str을 출력하는 코드를 작성해 보세요.

제한사항
1 ≤ str의 길이 ≤ 1,000,000
str에는 공백이 없으며, 첫째 줄에 한 줄로만 주어집니다*/

public class Solution_001 {
    public static void main(String[] args) {
	
		System.out.println("test11");
		
		//Scanner sc = new Scanner(System.in);
		//String a = sc.next();
		
		//System.out.println("a : " + a);
		
		
		//System.out.println("입력해 주세요");
		//Scanner sc = new Scanner(System.in);
		
		
		/*boolean flag = false;
		
		String INPUT_STR = "";
		
		while(flag == false) {
						
			System.out.println("한 글자 이상 , 다섯글자 이내로 입력해 주세요");

			
			Scanner sc = new Scanner(System.in);
			
			INPUT_STR = sc.next();
			
			if(INPUT_STR.length() >= 1 && INPUT_STR.length() <= 5) {
				flag = true;
			}
		}
	
		System.out.println("입력한 글자는 : " + INPUT_STR);*/
		
		String INPUT_STR = "";
		
		do {
			
			System.out.println("글자를 입력해 주세요");
			Scanner sc = new Scanner(System.in);
			
			INPUT_STR = sc.next();
			
			if(INPUT_STR.length() < 1) {
				System.out.println("한글자 이상을 입력 해야 합니다.");
				
			}
			
			if(INPUT_STR.length() > 5) {
				System.out.println("길이가 5자가 넘어가면 안됩니다");
			}
			
			
			
		}while (INPUT_STR.length() < 1 || INPUT_STR.length() > 5 || INPUT_STR.contains(" "));
			
			System.out.println("입력한 글자는 : " + INPUT_STR);
			
			
		
		
		
	}
}


 