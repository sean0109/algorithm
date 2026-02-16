package main.codingtest.programmers.levelone;

import java.util.Arrays;
import java.util.Collections;

// 문자열 내림차순 배치
public class Solution_practice_002 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String answer = solution.solution("Zbcdefg");
        System.out.println("answer : " + answer);
    }

    private static class Solution {

        public String solution(String s) {

            StringBuilder sb = new StringBuilder();
            Character[] charArr = new Character[s.length()];

            int i = 0;
            for (Character e : s.toCharArray()) {
                charArr[i] = e;
                i++;
            }
            Arrays.sort(charArr, Collections.reverseOrder());

            for (Character c : charArr) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
