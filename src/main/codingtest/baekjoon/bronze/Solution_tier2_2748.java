package main.codingtest.baekjoon.bronze;

/*
    문제 : 피보나치 수 2
    난이도 : 브론즈 2
    알고리즘 : 수학, 다이나믹 프로그래밍
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_tier2_2748 {

    private static long[] dp;    // dp (피보나치 수 배열)
    private static int n;

    //  *** DP 기초를 튼튼히 해 보자
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // Dynamic Programming 동적 계획법의 중요 포인트!!!
/*
            1. 점화식 세우기
                피보나치 수 : f(n) = f(n-1) + f(n-2)
            2. 함수 ( 메서드 구현 )
             2-1) 재귀로 풀꺼냐 : Top-Down 방식 : n이 커질수록 depth 재귀 함수 깊이가 깊어짐으로 유의
             2-2) 반복문으로 풀꺼냐 : Bottom-Up 방식

*/

        // 헷갈리는 포인트!! '문제에서 0번째의 개념을 포함 하므로...'
        // ex  : n이 3 번째일경우
        // dp = {0, 1, 1, 2} : length 는 4 이므로 n+1 배열을 만들어 준다.
        dp = new long[n + 1];

        Arrays.fill(dp, -1);    // 계산이 아직 안 된 값은 구분을 위해서 -1로 채운다.

        long answer = 0;

        // 점화식을 생각하면서 dp 들어간다.

        // 1. Top-Down 방식 : 재귀 함수 호출
        //answer = getValue(n);

        // 2. Bottom-Up 방식 : 반복문으로 해결
        for (int i = 0; i <= n; i ++ ) {
            if (i == 0) {
                dp[0] = 0;
                continue;
            }
            if (i == 1) {
                dp[1] = 1;
                continue;
            }
            // 점화식 적용
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        answer = dp[n];

        // 정답 출력
        System.out.println(answer);

    }

    // 1. Top-Down 방식 : 재귀 함수 호출 방식을 해결
    private static long getValue(int n) {
        // 피보나치 수 점화식 : f(n) = f(n-1) + f(n-2)

        // 값을 바로 꺼낼 수 있는 경우에는 꺼내준다. ( 이미 계산이 되어있을 경우 )
        // 문제에서는 n번째 피보나치 수열을 만드는 과정에서 dp 배열을 채워 가므로 사실상 조건에 걸릴경우는 없다.
        if(dp[n] != -1) return dp[n];

        // 점화식의 개념상 n >= 2 이상 부터 적용할 수 있으므로, 그 전은 하드코딩 해서 구해준다.
        if(n == 0) {
            dp[0] = 0;
            return dp[0];
        }
        if(n == 1) {
            dp[1] = 1;
            return dp[1];
        }

        // 점화식 적용
        dp[n] = getValue(n - 1) + getValue(n - 2);
        return dp[n] ;
    }
}
