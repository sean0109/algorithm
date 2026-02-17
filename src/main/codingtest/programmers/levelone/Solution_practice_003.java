package main.codingtest.programmers.levelone;

import java.util.*;

// 카드뭉치
public class Solution_practice_003 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String answer = solution.solution(cards1, cards2, goal);
        System.out.println("answer : " + answer);
    }

    private static class Solution {

        public String solution(String[] cards1, String[] cards2, String[] goal) {

            // 스택으로 풀기
            Stack<String> s1 = arrayToStack(cards1);
            Stack<String> s2 = arrayToStack(cards2);
            Stack<String> target = arrayToStack(goal);

            // 정답 플래그
            String answer = "Yes";

            while (!target.isEmpty()) {

                String pos = target.pop();

                // 스택에서 글자 찾기
                if (!s1.isEmpty() && s1.peek().equals(pos)) {
                    s1.pop();
                    continue;
                }

                if (!s2.isEmpty() && s2.peek().equals(pos)) {
                    s2.pop();
                    continue;
                }

                // 못찾았을 경우
                answer = "No";
                break;
            }

            return answer;
        }

        // 스택 변환
        public <T> Stack<T> arrayToStack(T[] array) {

            Stack<T> stack = new Stack<>();

            for (int i = array.length -1; i >= 0; i --) {
                stack.push(array[i]);
            }

            return stack;
        }
    }
}
