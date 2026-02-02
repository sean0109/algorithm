package main.codingtest.baekjoon.silver;

/*
    문제 : 미로탐색
    난이도 : 실버 1
    알고리즘 : 그래프이론, 그래프탐색, 너비우선탐색, 격자그래프
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_tier1_2178 {

    private static int N, M;
    private static int [][] maze;
    private static boolean[][] visited;
    
    // 아래, 위, 오른쪽, 왼쪽
    private static int [] dx = {1, -1, 0, 0};
    private static int [] dy = {0, 0, 1, -1};

    private void solve() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];           // 미로 행렬 데이터
        visited = new boolean[N][M];    // 방문 탐색 기록

        // 미로 정보 입력
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 지나야 하는 최소의 칸 수 탐색
        // BFS 탐색 시작
        bfs(0,0);
    }

    private void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 1});    // 시작 위치와 거리 1
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cx = now[0];    // 현재 x 위치 currentX
            int cy = now[1];    // 현재 y 위치 currentY
            int dist = now[2];

            // 출구에 도달했을 경우 거리 출력 후 종료
            if(cx == N-1 && cy == M-1){
                System.out.println(dist);
                return;
            }

            // 4방향을 탐색하여, 가능한 경로가 존재하면 큐에 저장
            for(int i = 0; i < 4; i ++){
                int nx = cx + dx[i];    // 새로운 x 위치 newX = currentX + dx;
                int ny = cy + dy[i];

                // 범위 체크 + 방문 여부 + 벽이 아닌지 체크 (가능한 경로이면 큐에 저장)
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(!visited[nx][ny] && maze[nx][ny] == 1){  // 방문한적 없고, 이동이 가능한 1 이면
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Solution_tier1_2178().solve();
    }
}
