package main.codingtest.baekjoon.silver;

/* 패션왕 신해빈 : hashMap 이용. 경우의 수 곱 , 시간제한 1초 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution_tier3_9375 {

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 1; i <= cnt; i++) {
            int solveCnt = Integer.parseInt(br.readLine());
            Map<String, Integer> clothMap = new HashMap<String, Integer>();

            for (int j = 1; j <= solveCnt; j++) {
                //StringTokenizer st = new StringTokenizer(br.readLine());
                String sortName = br.readLine().split(" ")[1];
                clothMap.put(sortName, clothMap.getOrDefault(sortName, 0) + 1);
            }

            Iterator<String> iter = clothMap.keySet().iterator();

            int answer = 1;
            /*while (iter.hasNext()) {
                int num = clothMap.get((String) iter.next());
                answer *= (num + 1);
            }*/
            // 코드 리뷰 : 향상된 for문 사용
            for(int value : clothMap.values()) {
                answer *= (value + 1);
            }

            sb.append(answer - 1).append("\n");    // 아무것도 안입는 경우의 수 1 빼줌
        }
        System.out.print(sb);
    }


    public static void main(String[] args) throws Exception {
        new Solution_tier3_9375().solve_1();
    }
}