package main.codingtest.programmers.levelone;

import java.util.Arrays;

// 둘만의 암호
public class Solution_practice_004 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "aukks";
        String skip = "wbqd";
        //String skip = "abcd";
        int index = 5;

        String answer = solution.solution(s, skip, index);
        System.out.println("answer = " + answer);
    }

    private static class Solution {
        public String solution(String s, String skip, int index) {

            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {

                int loopCnt = 0;
                char pos = c;
                while (loopCnt < index) {

                    pos = (pos == 'z') ? 'a' : (char) (pos + 1);

                    if (skip.contains(String.valueOf(pos))) {
                        continue;
                    }
                    loopCnt ++;
                }
                sb.append(pos);
            }
            return sb.toString();
        }
    }
}
