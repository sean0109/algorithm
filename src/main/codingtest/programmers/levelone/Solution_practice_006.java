package main.codingtest.programmers.levelone;

import java.util.HashMap;
import java.util.Map;

// 가장 가까운 같은 글자
public class Solution_practice_006 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "banana";
        // reuslt => [-1, -1, -1, 2, 2, 2]

        sol.solution(s);

    }

    private static class Solution {
        public int[] solution(String s) {

            int[] answer = new int[s.length()];

            // Map 을 이용해서 풀기. 항상 최신 위치를 갱신
            Map<Character, Integer> pos = new HashMap<>();

            for (int i = 0; i < s.length(); i ++) {

                char c = s.charAt(i);
                // 탐색
                int findIdx = pos.getOrDefault(c, -1);

                answer[i] = findIdx == -1 ? -1 : i - findIdx;

                // 문자별 위치 정보 갱신
                pos.put(c, i);
            }

            return answer;
        }
    }
}
