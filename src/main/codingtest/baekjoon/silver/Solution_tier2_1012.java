package main.codingtest.baekjoon.silver;
/*
    문제 : 유기농 배추
    난이도 : 실버 2
    알고리즘 : 그래프이론, 그래프탐색, 너비우선탐색, 깊이우선탐색, 격자그래프, 플러드필
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_tier2_1012 {

    private static int T;       // 테스트 케이스 수
    private static int M,N;     // 배추밭의 가로길이, 세로길이
    private static int K;       // 배추가 심어져 있는 위치의 개수

    private static int[][] cabbages;    // 배추밭
    private static boolean[][] visited; // 흰지렁이 배추 방문 여부

    private static int[] dx = {1, -1, 0, 0};    // x좌표 이동량
    private static int[] dy = {0, 0, 1, -1};    // y좌표 이동량
    private static int answer;      // 정답 (배추의 개수)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        // 문제 풀기
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbages = new int[M][N];
            visited = new boolean[M][N];

            // 배추 심기
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cabbages[x][y] = 1;
            }

            // 배추 심었으면, 흰지렁이 탐색 시작 ( bfs )
            // 배추밭을 탐색하면서, 1이 나올때마다 bfs를 시도 한다.
            answer = 0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(cabbages[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);    // 흰지렁이의 개수 누적
                        answer++;
                    }
                }
            }
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
    
    // 흰지렁이 배추 탐색 시작 (해당 메서드의 목적은 인접한 배추 배열의 visited 정보를 모두 true로 만드는것)
    private static void bfs(int x, int y) {

        visited[x][y] = true;   // 방문 기록 추가

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] pData = q.poll();
            int px = pData[0];
            int py = pData[1];
            
            // 4방향 탐색
            for(int i = 0; i < 4; i ++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                
                // 탐색 가능 유효성 검사
                if(nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] || cabbages[nx][ny] != 1) continue;

                // 탐색 유효성 검사 통과하면,
                // 방문기록 추가
                int[] nData = new int[]{nx, ny};
                visited[nx][ny] = true;
                q.offer(nData);
            }
        }
    }
}