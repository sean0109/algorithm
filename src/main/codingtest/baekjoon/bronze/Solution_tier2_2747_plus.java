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

public class Solution_tier2_2747_plus {
    private static int n;
    private static int[] fibonacci;
    
    // bottom-up 방식
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        //피보나치 배열 저장
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        System.out.println(fibonacci[n]);
    }
}
