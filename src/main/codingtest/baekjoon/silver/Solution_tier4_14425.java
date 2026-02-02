package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
문제 : 문자열 집합
난이도 : 실버 4
알고리즘 : 자료구조, 문자열, 해시, 트리, 집합과맵
시간제한 : 2초
*/

public class Solution_tier4_14425 {

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt_1 = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<String>();

        for(int i = 1; i <= cnt_1; i++) {
            set.add(br.readLine());
        }

        int cnt_2 = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= cnt_2; i++) {
            if(set.contains(br.readLine())) { total_cnt++;}
        }
        System.out.println(total_cnt);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier4_14425().solve_1();
    }
}