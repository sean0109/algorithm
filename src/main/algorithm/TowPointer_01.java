package main.algorithm;

/*
 * 투 포인터
 
순차적으로 나열된 데이터를 다룰 때.
두 개의 포인터(인덱스)를 사용해서 문제를 해결하는 방법

# 부분 합 문제
# 정렬된 배열에서 두 수의 합
# 슬라이딩 윈도우

포인터 두 개(start, end)를 준비해.
조건에 맞게 포인터를 움직이면서 원하는 결과를 찾아.

 * */

public class TowPointer_01 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 4, 6, 10};
		int target = 8; 			//	8의 합을 구하는 경우의 수를 구하시오
		
		boolean result = twoPointer(nums, target);
		System.out.println("result : " + result);
		
	}
	
	private static boolean twoPointer(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while(left < right) {
			
			int sum = nums[left] + nums[right];
			
			// 합이 작으면 왼쪽 포인터를 오른쪽으로 한칸 이동 
			if(sum < target ) {
				left ++;
			
			// 합이 크면 오른쪽 포인터를 왼쪽으로 한칸 이동
			}else if(sum > target) {
				right --;
			}else {
				return true;
			}
			
		}
		return false;
	}
}
