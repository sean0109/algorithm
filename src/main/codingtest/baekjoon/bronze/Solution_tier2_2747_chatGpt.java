package main.codingtest.baekjoon.bronze;


/*
    문제 : 피보나치 수
    난이도 : 브론즈 2
    알고리즘 : 수학, 구현, 다이나믹 프로그래밍
    시간제한 : 1초
*/

// top-down 방식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_tier2_2747_chatGpt {

    private static int[] dp;    //  메모이제이션 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;

        int answer = fibo(n);
        System.out.println(answer);
    }

    private static int fibo(int n) {

        // 이전값을 구하려면 1번실행, 새로운 값은 2번 실행
        // 1번
        if (dp[n] != -1) return dp[n];  // 메모이제이션
        // 2번
        dp[n] = fibo(n - 1) + fibo(n - 2);

        return dp[n];
    }
}
