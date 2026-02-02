package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    문제 : 색종이
    난이도 : 실버 5
    시간 제한 : 1초
    알고리즘 : 구현
*/

public class solution_tier5_2563 {

    private static boolean[][] paper = new boolean[100][100];   // 도화지 바둑판
    private static int N;   // 색종이 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 도화지를 색종이로 책칠한다고 생각
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int initX = Integer.parseInt(st.nextToken());   // 왼쪽 아래 x 좌표
            int initY = Integer.parseInt(st.nextToken());   // 왼쪽 아래 y 좌표

            for (int x = initX ; x < initX + 10; x ++ ) {   // 서로 다른 도화지의 색이 겹쳐도 상관 노노
                for (int y = initY; y < initY + 10; y++) {
                    paper[x][y] = true;
                }
            }
        }
        
        // 칠해진 칸 개수만큼 넓이로 책정
        int width = 0;

        for (boolean[] area : paper) {
            for (boolean color : area) {
                if (color) {
                    width += 1;
                }
            }
        }
        System.out.println(width);
    }
}
