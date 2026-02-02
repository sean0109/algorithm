package main.codingtest.baekjoon.silver;

/*
    문제 : 계단 오르기
    난이도 : 실버3
    알고리즘 : 다이나믹 프로그래밍
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_tier3_2579 {

    private static int[] stairs;
    private static int maxScore;

    // 백트래킹으로 풀기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stairs = new int[n];

        for(int i = 0; i < n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 백트래킹 시작
        search(0, -1, 0);   // 시작점은 -1로

        System.out.println(maxScore);

    }

    // 재귀 함수 호출
    private static void search(int score, int curStep, int seq ) {

        // 탐색 종료 조건
        if(curStep == stairs.length - 1){
            maxScore = Math.max(score, maxScore);
            return;
        }

        if(seq < 2){   // 한 계단 이동 또는 두 계단 이동 가능
            // 한계단 이동
            if(curStep + 1 < stairs.length){
                search(score + stairs[curStep+1], curStep + 1, seq + 1);
            }

            // 두 계단 이동
            if(curStep + 2 < stairs.length){
                search(score + stairs[curStep+2], curStep + 2, 1);
            }

        }else{
            // 이때는 무조건 두계단 이동 하고, 연속계단수 0으로 초기화
            if(curStep + 2 < stairs.length){
                search(score + stairs[curStep+2], curStep + 2, 1);
            }
        }
    }
}
