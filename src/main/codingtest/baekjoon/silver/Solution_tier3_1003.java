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
public class Solution_tier3_1003 {
    private static int[] dp = new int[41];
    private static int T;   // 테스트 케이스
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 피보나치 수열을 미리 만들어 놓자
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[0] = 0;
                continue;
            }

            if (i == 1) {
                dp[1] = 1;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            // 규칙을 확인해 보면 0이 출력되는 횟수는 n-1 번째 피보나치 수열 값이고,
            // 1이 출력되는 횟수는 n 번째 피보나치 수열이다.

            // 0 일때는 1로 바꿔서 구해준다. 배열 인덱스 예외처리
            if(n == 0) {
                sb.append("1 0\n");
                continue;
            }

            sb.append(dp[n - 1]).append(" ").append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
