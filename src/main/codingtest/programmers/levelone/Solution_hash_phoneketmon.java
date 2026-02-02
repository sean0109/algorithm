package main.codingtest.programmers.levelone;

/*

문제 : 폰켓몬
알고리즘 : 해시
난이도 : lv1

*/

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution_hash_phoneketmon {

    private int solution(int[] nums) {
        int answer = 0;
        Set<Integer> treeSet = new TreeSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            treeSet.add(nums[i]);
        }
        answer = Math.min(treeSet.size(), nums.length/2);
        return answer;
    }
    
    // 함수형 프로그래밍
    public int solution_others(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
    
    public static void main(String[] args) {
        int [] nums = {3,1,2,3};
        int answer = new Solution_hash_phoneketmon().solution(nums);
        System.out.println(answer);
    }
}
