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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 탐색으로 풀기
 */
public class Solution_tier1_1926_bfs {

    private static int N, M;          // 행, 열
    private static int[][] screen;    // 도화지
    private static boolean[][] visited;

    // x, y 이동의 변화량
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int count;       // 그림의 개수
    private static int maxExtent;  // 넓이


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

        // bfs 탐색 시작
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && screen[i][j] == 1){
                    int area = bfs(i,j);
                    count++;
                    maxExtent = Math.max(maxExtent, area);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxExtent);
    }

    // 넓이 탐색 시작
    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        int area = 1;   // 시작점 포함

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            boolean stop = true;

            for(int i = 0; i < 4; i ++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(screen[nx][ny] == 1 && !visited[nx][ny]){
                        area++;
                        stop = false;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        return area;
    }

    public static void main(String[] args) throws Exception{
        solve();
    }
}
