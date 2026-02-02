package main.codingtest.baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 : 피보나치 함수
    난이도 : 실버 3
    알고리즘 : 다이나믹 프로그래밍 (DP)
    시간제한 : 0.25초
*/
public class Solution_tier3_1003_timeout {
    // 시간 초과
    private static int N, M;    // N = 0 출력 카운트, M = 1 출력 카운트

    public static void main(String[] args) throws IOException {
        // 점화식
        // f(n) = f(n-1) + f(n-2)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0 ; i < count ; i++) {
            N = 0; M = 0;
            int n = Integer.parseInt(br.readLine());
            answer = dp(n);
            sb.append(N).append(" ").append(M);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int dp(int n) {
        if (n == 0) {
            N++;
            return 0;
        }

        if (n == 1) {
            M++;
            return 1;
        }
        return dp(n - 1) + dp(n - 2);
    }
}
