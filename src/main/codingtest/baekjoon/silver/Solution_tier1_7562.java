package main.codingtest.baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    문제 : 나이트의 이동
    난이도 : 실버 1
    알고리즘 : 그래프이론, 그래프탐색, 너비우선탐색, 최단경로, 격자그래프
    시간제한 : 1초
*/
public class Solution_tier1_7562 {

    // 체스판
    private static int[][] chessBoard;  // 체스판 배열
    private static boolean[][] visited; // 체스판 좌표 탐색 여부

    // 나이트 dx, dy 좌표 이동 범위
    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int square;          // 체스판 가로, 세로 크기

    // 목표 좌표
    private static int targetX;
    private static int targetY;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼
        for(int i = 0; i < caseNum; i++){
            square = Integer.parseInt(br.readLine());
            chessBoard = new int[square][square];
            visited = new boolean[square][square];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken());  // 현재 x 좌표
            int py = Integer.parseInt(st.nextToken());  // 현재 y 좌표

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            // 넓이 탐색
            int moveCount = bfs(px, py);
            sb.append(moveCount).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
    // 넓이 탐색

    private static int bfs(int px, int py) {
        int posCount = 0;
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new int[] {px, py, posCount});
        visited[px][py] = true; // 현재 위치 탐색 체크

        while(!bfsQueue.isEmpty()){
            int[] pos = bfsQueue.poll();
            int cx = pos[0];
            int cy = pos[1];
            int moveCount = pos[2];

            // 탐색 종료 조건
            if (cx == targetX && cy == targetY){
                return moveCount;
            }

            // 움직일수 있는 방향 탐색 (총 8 방향)
            for(int i = 0; i < 8; i ++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < square && nx >= 0 && ny < square && ny >= 0 && !visited[nx][ny]){

                    visited[nx][ny] = true;
                    bfsQueue.offer(new int[] {nx, ny, moveCount+1});
                }
            }
        }
        return posCount;
    }


    public static void main(String[] args) throws Exception{
        solve();
    }
}


