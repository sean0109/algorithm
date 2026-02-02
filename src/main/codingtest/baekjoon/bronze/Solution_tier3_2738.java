package main.codingtest.baekjoon.bronze;



/*
    문제 : 행렬 덧셈
    난이도 : 브론즈 3
    시간 제한 : 1초
    알고리즘 : 수학, 구현, 사칙연산
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_tier3_2738 {

    private static int N, M;
    private static int[][] arrA;
    private static int[][] arrB;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 행렬은 고정적으로 2개 A, B
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N][M];
        arrB = new int[N][M];


        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j ++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j ++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
                // 여기서 출력결과 누적
                sb.append(arrA[i][j] + arrB[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
