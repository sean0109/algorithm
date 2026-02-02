package main.codingtest.baekjoon.silver;

/*
    문제 : 숫자카드2
    난이도 : 실버 4
    알고리즘 : 자료구조, 정렬, 이분탐색, 해시를사용한집합과맵
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_tier4_10816 {
    
    private void solve_1() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(st.nextToken());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier4_10816().solve_1();
    }
}
