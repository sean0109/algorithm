package main.codingtest.programmers.levelone;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 명예의 전당(1)
public class Solution_practice_009 {

    public static void main(String[] args) {

        Solution sol = new Solution();
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] answer = sol.solution(k, score);

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        // result : [10, 10, 10, 20, 20, 100, 100]
    }

    public static class Solution {

        public int[] solution(int k, int[] score) {
            Queue<Integer> scoreData = new PriorityQueue<>();
            int[] answer = new int[score.length];

            for (int i = 0; i < score.length; i ++ ) {

                // 추가 부터 하고, 제거
                scoreData.offer(score[i]);

                if (scoreData.size() > k) {
                    scoreData.poll();   // 명예의 전당은 항상 상위 3개 이므로, 제거
                }

                answer[i] = scoreData.peek();
            }
            return answer;
        }
    }
}
