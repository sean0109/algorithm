package main.codingtest.programmers.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


// 코딩테스트 연습 > 연습문제 > 두 개 뽑아서 더하기


/*
# 문제 설명
	정수 배열 numbers가 주어집니다. 
	numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 
	배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
	
# 제한사항
	numbers의 길이는 2 이상 100 이하입니다.
	numbers의 모든 수는 0 이상 100 이하입니다.

# 입출력 예
		numbers			result
	[2,1,3,4,1]		[2,3,4,5,6,7]
	[5,0,2,7]		[2,5,7,9,12]

# 입출력 예 설명
# 입출력 예 #1

	2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
	3 = 2 + 1 입니다.
	4 = 1 + 3 입니다.
	5 = 1 + 4 = 2 + 3 입니다.
	6 = 2 + 4 입니다.
	7 = 3 + 4 입니다.
	따라서 [2,3,4,5,6,7] 을 return 해야 합니다.

# 입출력 예 #2

	2 = 0 + 2 입니다.
	5 = 5 + 0 입니다.
	7 = 0 + 7 = 5 + 2 입니다.
	9 = 2 + 7 입니다.
	12 = 5 + 7 입니다.
	따라서 [2,5,7,9,12] 를 return 해야 합니다.

*/

public class Solution_007 {
	public static void main(String[] args) {
		
		
		int [] exArr_1 = {2,1,3,4,1};
		int [] exArr_2 = {5,0,2,7};
		
		int[] answer_1 = solution_3(exArr_1);
		int[] answer_2 = solution_3(exArr_2);
		
		
		System.out.println("answer_1 for solution_3: " + Arrays.toString(answer_1));
		System.out.println("answer_2 for solution_3: " + Arrays.toString(answer_2));
		
	}
	
	// 풀이 1 : 중복 제거 시 요소탐색 for 문 사용
	public static int[] solution_1(int[] numbers) {
		
		System.out.println("solution_1 시작 :");
		
		List<Integer> tempList = new ArrayList<Integer>();
		System.out.println("numbers.lenght : " + numbers.length);
		// numbers : [2,1,3,4,1]
		for(int i = 0; i < numbers.length; i ++) {
			System.out.println("i의 값 : " + i);
			int value = 0;
			
			
			// 더하고
			for(int j = i+1; j < numbers.length; j ++) {
				System.out.println("j의 값 : " + j);
				value = numbers[i] + numbers[j];
				System.out.println("value : " + value + " = " + numbers[i] + "+" + numbers[j]);
				
				// 최초
				if(tempList.size() == 0) {
					System.out.println("최초 " + value + "의 값을 추가 합니다.");
					tempList.add(value);
				}else {
					boolean flag = false;
					for(int k : tempList) {
						if(k == value) {
							flag = true; System.out.println("k(" + k + ")의 값이 value(" +value+")의 값과 같습니다");break;
						}
					}
					
					if(!flag) {
						System.out.println(value + " 의 값을 추가 합니다.");
						tempList.add(value);
					}
				}
			}
		}
		
		int [] answer = new int[tempList.size()];
		
		for(int i = 0; i < tempList.size(); i ++) {
			answer[i] = tempList.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
	
	// 풀이 2 : 중복 제거시 요소 탐색 iterator 사용
	public static int[] solution_2(int[] numbers) {
		
		System.out.println("solution_2 시작 :");
		List<Integer> tempList = new ArrayList<Integer>();
		int addValue = 0;
		
		for(int i = 0; i < numbers.length; i ++) {
			
			for(int j = i+1; j < numbers.length; j ++) {
				
				addValue = numbers[i] + numbers[j];
				
				if(tempList.size() == 0) {
					tempList.add(addValue);
				}else {
					Iterator<Integer> iter_1 = tempList.iterator();
					boolean flag = false;
					while(iter_1.hasNext()) {
						if(addValue == iter_1.next()) {
							flag = true; break;
						}
					}
					
					if(!flag) {
						tempList.add(addValue);
					}
				}
			}
		}
		
		int [] answer = new int[tempList.size()];
		
		for(int i = 0; i < tempList.size(); i ++) {
			answer[i] = tempList.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
	
	// 풀이 3 : HashSet을 사용하여 중복 요소 자동 제거
	public static int[] solution_3(int[] numbers) {
		
		System.out.println("solution_3 시작 : ");
		Integer [] resultArr = null;
		
		Set<Integer> tempSet = new HashSet<Integer>();
		int addValue = 0;
		
		for(int i=0; i < numbers.length; i ++) {
			for(int j=i+1; j < numbers.length; j ++) {
				addValue = numbers[i] + numbers[j];
				
				tempSet.add(addValue);
			}
		}
		
		// set.Stream() 함수 써서 구현 
		System.out.println("hashset 값 : " + tempSet);
		//System.out.println("hashset stream 값 : " + tempSet.stream().sorted().mapToInt(i->i).toArray());
		 
		resultArr = tempSet.toArray(new Integer[0]);
		
		//System.out.println("출력 : " + (int)Arrays.toString(resultArr));
		
		//return resultArr;
		
		return null;
	}
}