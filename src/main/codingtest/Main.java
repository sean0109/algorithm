package main.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 미로 변수
    private static int[][] maze; // int[col][row]
    private static boolean[][] visited;
    private static int M, N; // 행, 열

    // 이동량 (동,서,남,북)
    private static int[] dm = {0, 0, 1, -1};
    private static int[] dn = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // 세로 길이 ( 행 col )
        N = Integer.parseInt(st.nextToken());   // 가로길이 ( 열 row )

        maze = new int[M][N];
        visited = new boolean[M][N];

        // 미로 채우기
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }
        // bfs 탐색 시작
        int answer = bfs();

        System.out.println(answer);

    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        // 처음 시작 위치 큐에 넣기
        queue.offer(new int[]{0, 0, 1});    // 행좌표, 열좌표, 이동한 칸 수

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curM = cur[0];
            int curN = cur[1];
            int curCount = cur[2];

            // 출구에 도착 헀을 경우 종료
            if (curM == M - 1 && curN == N - 1) {
                return curCount;
            }

            // 아직 출구에 도착하지 않았을 경우
            for (int i = 0; i < 4; i ++) {
                int newM = curM + dm[i];
                int newN = curN + dn[i];

                if (newM >= 0 && newM < M && newN >= 0 && newN < N && !visited[newM][newN] && maze[newM][newN] == 1) {
                    visited[newM][newN] = true;
                    queue.offer(new int[]{newM, newN, curCount + 1});
                }
            }
        }
        // 출구에 도착하지 못했을 경우에는 -1을 리턴한다.
        return -1;
    }
}

