package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    문제 : 회의실 배정
    난이도 : 골드 5
    시간 제한 : 2초
    알고리즘 : 그리디알고리즘, 정렬
*/

public class Solution_tier5_1931 {

    private static int[][] lectures;    // 회의 정보
    private static int N;   // 회의 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

       Arrays.sort(lectures, (e1, e2) -> {
           int sortVal = e1[1] - e2[1];

           if (sortVal != 0) {
               return sortVal;
           }
           return e1[0] - e2[0];
       });

       int answer = 0;
       int end = 0;

       for (int i = 0; i < N; i++) {
           if (lectures[i][0] > end) {
               answer ++;
               end = lectures[i][1];
           }
       }
        System.out.println(answer);
    }
}
