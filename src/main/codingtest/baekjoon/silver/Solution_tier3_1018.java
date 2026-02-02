package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_tier3_1018 {

    private static char[][] chessBoard;
    private static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                chessBoard[i][j] = input.charAt(j);
            }
        }

        int answer = N * M;

        // 8 * 8 조각을 내서 탐색
        for (int i = 0; i <= N - 8; i ++) {
            for (int j = 0; j <= M - 8; j++) {
                 answer = Math.min(checkCount(i, j), answer);
            }
        }

        System.out.println(answer);
    }

    public static int checkCount(int startX, int startY) {

        int drawCountX = 0;
        int drawCountY = 0;

        // 시작을 W 라고 가정
        for (int i = startX; i < startX + 8; i++) {
            for (int j = startY; j < startY + 8; j++) {
                // 홀수 행일 때의 홀수 열과, 짝수 행 일때의 짝수 열을 검사
                // ex > (0,0), (0,2), ... (1,1), (1,3) ... 이 W 가 되어야 함으로, j + j 가 짝수인 배열의 요소가 W가 되어야 함

                char expected = (i + j) % 2 == 0 ? 'W' : 'B';

                if (chessBoard[i][j] != expected) {
                    drawCountX++;
                }
            }
        }

        // 시작이 B 일때는 , 시작이 W 일때의 반대이므로,
        drawCountY = 64 - drawCountX;

        return Math.min(drawCountX, drawCountY);
    }
}
