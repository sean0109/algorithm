package main.codingtest.baekjoon.silver;

/*
    문제 : 그림
    난이도 : 실버 1
    알고리즘 : 그래프이론, 그래프탐색, 너비우선탐색, 격자그래프, 깊이우선탐색, 플러드필
    시간제한 : 2 초
    메모리 제한 : 128 MB
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS 탐색으로 풀기. 재귀 호출
 */
public class Solution_tier1_1926_dfs {

    private static int N, M;            // 행, 열
    private static int[][] screen;      // 도화지
    private static boolean[][] visited; // 방문 탐색 여부

    private static int[] dx = {1, -1, 0, 0};    // 행 이동 좌표값
    private static int[] dy = {0, 0, -1, 1};    // 열 이동 좌표값

    private static int count;           // 그림 개수
    private static int maxExtent;       // 그림의 최대 넓이
    private static int extent;          // 탐색시, 개별 그림의 넓이

    private static void solve() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        screen = new int[N][M];
        visited = new boolean[N][M];

        // 배열 값 저장
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                screen[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        maxExtent = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && screen[i][j] == 1){
                    count++;
                    extent = 0;
                    int area = dfs(i, j);
                    maxExtent = Math.max(maxExtent, area);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxExtent);
    }


    private static int dfs(int x, int y) {
        extent ++;
        visited[x][y] = true;   // 방문 기록 체크

        // 4방향 탐색
        for(int i = 0; i < 4; i ++){

            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 벽이 아닌지 확인
            if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                if(!visited[nx][ny] && screen[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
        return extent;
    }
}
