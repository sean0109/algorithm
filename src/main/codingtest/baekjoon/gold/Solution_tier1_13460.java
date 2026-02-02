package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    문제 : 구슬 탈출 2
    난이도 : 골드 1
    알고리즘 : 구현, 그래프이론, 그래프탐색, 시뮬레이션, 너비우선탐색
    시간제한 : 2초
*/
public class Solution_tier1_13460 {
    
    private static int N, M;                    // 보드의 세로, 가로 크기
    private static Character[][] board;         // 보드 판
    private static boolean[][][][] visited;     // 방문 기록 (최단 회수를 찾기 위한)
    private static int[] dx = {1, -1, 0, 0};    // x좌표 방향 이동(한칸)
    private static int[] dy = {0, 0, 1, -1};    // y좌표 방향 이동(한칸)

    //private static int moveCount;   // 공이 움직인 칸 수
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Character[N][M];
        visited = new boolean[N][M][N][M];


        int xR = 0, yR = 0;     // 빨간구슬 처음 위치
        int xB = 0, yB = 0;     // 파란구슬 처음 위치

        for(int i = 0; i < N; i++){
            String input = br.readLine();

            for(int j = 0; j < M; j++){
                board[i][j] = input.charAt(j);
                if (input.charAt(j) == 'R'){
                    xR = i;
                    yR = j;
                }

                if(input.charAt(j) == 'B'){
                    xB = i;
                    yB = j;
                }
            }
        }

        // bfs 탐색 시작
        // 빨간구슬 좌표, 파란구슬좌표, 기울이기 회수
        bfs(xR, yR, xB, yB, 0);
    }
    
    // bfs 넓이 우선 탐색
    private static void bfs(int xR, int yR, int xB, int yB, int count) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{xR, yR, xB, yB, count});

        visited[xR][yR][xB][yB] = true; // 처음 빨간공, 파란공 위치 지나온 길 체크

        while(!q.isEmpty()){
            
            int[] now = q.poll();
            // 현재 빨간구슬 좌표
            int nowXR = now[0];
            int nowYR = now[1];
            // 현재 파란구슬 좌표
            int nowXB = now[2];
            int nowYB = now[3];
            // 현재 기울인 누적 회수
            int nowCount = now[4];

            // 해당 탐색 종료 조건
            if(nowCount >= 10) {
                continue;   // 10 번 기울이기 횟수 넘어갔으므로 탐색 안하고 제거한다.
            }

            // 탐색 시작 (4방향)
            for(int i = 0; i < 4; i++){
                
                // 공이동
                MoveBalls moveBalls = new MoveBalls(nowXR, nowYR, nowXB, nowYB, dx[i], dy[i]);
                moveBalls.move();

                // 전체 탐색  종료 조건 1 : 성공조건
                if(moveBalls.rIsHole && !moveBalls.bIsHole){    // 성공조건
                    nowCount++;
                    System.out.println(nowCount);
                    return;
                }
                
                // 해당 탐색 종료 조건 2 : 실패 조건, 해당 탐색 종료
                if(moveBalls.bIsHole){
                    continue;
                }


                // 만약 빨간공의 위치와 파란공의 위치가 같다면.
                if(moveBalls.newXR == moveBalls.newXB && moveBalls.newYR == moveBalls.newYB){
                    // 많이 이동한쪽을 한칸 빼준다
                    if(moveBalls.redBallMoveCnt > moveBalls.blueBallMoveCnt){
                        moveBalls.newXR -= dx[i];
                        moveBalls.newYR -= dy[i];
                    }else{
                        moveBalls.newXB -= dx[i];
                        moveBalls.newYB -= dy[i];
                    }
                }

                // 해당 탐색 종료 조건 3 : 방문 여부 확인
                if(visited[moveBalls.newXR][moveBalls.newYR][moveBalls.newXB][moveBalls.newYB]){
                    continue;
                }

                visited[moveBalls.newXR][moveBalls.newYR][moveBalls.newXB][moveBalls.newYB] = true;
                // 자 이제 큐에 탐색 경우의 수를 비로소 저장해 준다.
                q.offer(new int[]{moveBalls.newXR, moveBalls.newYR, moveBalls.newXB, moveBalls.newYB, nowCount + 1});

            }
        }

        System.out.println(-1);
    }

    static class MoveBalls {
        
        // 현재 빨간공 위치
        private int xR;
        private int yR;
        
        // 기울인 후 새로운 빨간공 위치
        private int newXR;
        private int newYR;

        // 현재 파란공 위치
        private int xB;
        private int yB;

        // 기울인 후 새로운 파란공 위치
        private int newXB;
        private int newYB;

        // 이동 방향
        private int dx;
        private int dy;

        private boolean rIsHole;
        private boolean bIsHole;

        private int redBallMoveCnt;
        private int blueBallMoveCnt;


        public MoveBalls(int xR, int yR, int xB, int yB, int dx, int dy) {
            this.xR = xR;
            this.yR = yR;
            this.xB = xB;
            this.yB = yB;
            this.dx = dx;   // 방향 (동서남북 중 x좌표 한칸)
            this.dy = dy;   // 방향 (동서남북 중 y좌표 한칸)
        }

        public void move() {

            // 빨간 구슬
            int rx = xR, ry = yR;
            redBallMoveCnt = 0;
            while (true) {
                int nx = rx + dx, ny = ry + dy;
                if (board[nx][ny] == '#') break;  // 벽이면 멈춤
                rx = nx; ry = ny;                  // 실제로 전진
                redBallMoveCnt++;
                if (board[rx][ry] == 'O') {        // 구멍이면 빠짐
                    rIsHole = true;
                    break;
                }
            }
            newXR = rx; newYR = ry;

            // 파란 구슬
            int bx = xB, by = yB;
            blueBallMoveCnt = 0;
            while (true) {
                int nx = bx + dx, ny = by + dy;
                if (board[nx][ny] == '#') break;
                bx = nx; by = ny;
                blueBallMoveCnt++;
                if (board[bx][by] == 'O') {
                    bIsHole = true;
                    break;
                }
            }
            newXB = bx; newYB = by;
        }
    }
}
