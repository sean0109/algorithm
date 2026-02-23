package main.codingtest.programmers.levelone;

import java.util.*;

// 귤 고르기
public class Solution_practice_007 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        // result : 3

        System.out.println("tangerine : " + Arrays.toString(tangerine));

        int answer = sol.solution(k, tangerine);

        System.out.println("answer : " + answer);

    }

    private static class Solution {
        public int solution(int k, int[] tangerine) {

            int answer = 0;

            Map<Integer, Integer> infoMap = new HashMap<>();

            for (int e : tangerine) {
                infoMap.put(e, infoMap.getOrDefault(e, 0) + 1);
            }

            // Map 정렬
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(infoMap.entrySet());
            list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            System.out.println("infoMap : " + infoMap);

            int count = 0;
            for (Map.Entry<Integer, Integer> entry : list) {

                count += entry.getValue();
                answer ++;

                if (count >= k) {
                    break;
                }
            }
            return answer;
        }

        // keySet 만 이용해서 정렬
        public int solution_2(int k, int[] tangerine) {

            Map<Integer, Integer> infoMap = new HashMap<>();
            for (int e : tangerine) {
                infoMap.put(e, infoMap.getOrDefault(e, 0) + 1);
            }

            // 정렬
            List<Integer> list = new ArrayList<>(infoMap.keySet());

            Comparator<Integer> comp = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return infoMap.get(o2) - infoMap.get(o1);   // value 값으로 내림차순 정렬
                }
            };

            list.sort(comp);

            int answer = 0;
            int count = 0;

            for (int e : list) {
                count += infoMap.get(e);
                answer ++;
                if (count >= k) {
                    break;
                }
            }

            return answer;
        }
    }
}
