package main.codingtest.programmers.levelone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 나누어 떨어지는 숫자 배열

/*문제 설명
	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
	arr은 자연수를 담은 배열입니다.
	정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
	divisor는 자연수입니다.
	array는 길이 1 이상인 배열입니다.

입출력 예

	arr						divisor			return
	
	[5, 9, 7, 10]			5				[5, 10]
	[2, 36, 1, 3]			1				[1, 2, 3, 36]
	[3,2,6]					10				[-1]

입출력 예 설명
입출력 예#1
	arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

입출력 예#2
	arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

입출력 예#3
	3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
	
*
*/
public class Solution_004 {
	public static void main(String[] args) {
		
		System.out.println("배열에 담을 0 이상의 숫자를 입력해 주세요");
		
		int arr_space  = 0;
		
		do {
			
			arr_space = (int)(Math.random() * 11);
			
		}while(arr_space == 0);
		
		System.out.println("arr_space : " + arr_space);
		
		
		int[] arr_variable = new int[arr_space];
		
		
		for(int i = 0; i < arr_space; i ++) {
			
			int arr_value = (int)(Math.random() * 100);
			
			arr_variable[i] = arr_value;
			
		}
		
		System.out.println("배열 생성 완료");
		
		for(int i = 0; i < arr_space; i ++) {
			System.out.println("var_arr["+i+"] : " + arr_variable[i]);
		}
		
		int divisor_variable = (int)(Math.random() * 100);
		System.out.println("divisor_variable : " + divisor_variable);
		
		Solution_004 sol_004 = new Solution_004();
		
		int [] answer = sol_004.solution(arr_variable, divisor_variable);
		
	}
	
	// 풀이 1
	public int[] solution(int[] arr, int divisor) {
		
		//int[] answer = {};
		// ArrayList로 만들어서 배열에 추가
		List<Integer> tempList = new ArrayList<>();
		
		for(int i = 0 ; i < arr.length; i ++) {
			
			if(arr[i] % divisor == 0 ) {
				
				tempList.add((int)arr[i]);
				
			}
		}
		
		if(tempList.size() == 0) {
			tempList.add(-1);
		}
		
		for(int i = 0; i < tempList.size(); i ++) {
			System.out.println("tempList 값 : " + tempList.get(i));
		}
		
		
		//answer = tempList.toArray();
		
		Collections.sort(tempList);
		
		int [] answer = new int[tempList.size()];
		
		for(int i = 0; i < answer.length; i ++) {
			answer[i] = tempList.get(i);
		}
		
		for(int i = 0; i < answer.length; i ++) {
			System.out.println("answer 값 : " + answer[i]);
		}
		
		return answer;
	}
}