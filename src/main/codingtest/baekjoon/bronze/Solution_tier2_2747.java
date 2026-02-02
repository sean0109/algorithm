package main.codingtest.baekjoon.bronze;


/*
    문제 : 피보나치 수
    난이도 : 브론즈 2
    알고리즘 : 수학, 구현, 다이나믹 프로그래밍
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_tier2_2747 {

    private static int n;
    private static int prev2, prev1;    // 2단계전, 1단계 전 값
    private static int curr;            // n번째 피보나치 수 (현재값)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        prev2 = 0;
        prev1 = 1;

        // 피보나치 수열 만들기
        // n 번째 피보나치 수를 구하라
        for(int i = 0; i <= n; i++) {
            if(i == 0){
                curr = 0;
                continue;
            }
            if(i == 1){
                curr = 1;
                continue;
            }
            // 피보나치 수 계산 및, 이전 값 기억
            memorizeAndGet();
        }
        System.out.println(curr);
    }

    public static void memorizeAndGet(){
        curr = prev2 + prev1;   // 피보나치 수 계산

        prev2 = prev1;          // 하나씩 밀기
        prev1 = curr;
    }
}
