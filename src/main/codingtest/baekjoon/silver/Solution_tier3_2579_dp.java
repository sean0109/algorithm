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

public class Solution_tier3_2579_dp {

    private static int n;
    private static int[] stairs;            // 0은 버리고, 1번째 ~ n 번째 계단
    private static Integer[] dp;

    // DP로 풀기 ( dp 기초를 배워 보자~~~)
    public static void main(String[] args) throws IOException {

        // 마지막 계단(i)를 밟기 직전에, i-1 에서 한 칸 올라온 경우와, i-2 에서 두 칸 올라온 경우를 비교해서,
        // 그 중 더 큰 점수를 선택하고, 현재 계단 점수를 더한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {    // 계산을 간단하기 하기 위해 0 번째는 버린다.
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp = new Integer[n + 1];
        int answer = solve(n);

        System.out.println(answer);
    }

    private static int solve(int n) {

        if(n == 1){
            dp[1] = stairs[1];
            return dp[1];
        }

        if(n == 2){
            dp[2] = stairs[1] + stairs[2];
            return dp[2];
        }

        if(n == 3){
            dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            return dp[3];
        }

        // solve(n) 재귀 호출 시 값이 있을 경우 return,
        if(dp[n] != null){
            return dp[n];
        }

        // 핵심 로직!
        // 3번째(n번째) 계단 부터는, 도달하는 경우의 수는 2가지
        // 1) [n-3] -> [n-1] -> [n]
        // 2) [n-2] -> [n]

        // Top-down 방식으로, 재귀를 호출하면서 dp의 값을 계산해나가면서 풀게 된다.
        return dp[n] = Math.max(solve(n - 3) + stairs[n - 1], solve(n - 2)) + stairs[n];
        
    }
}
