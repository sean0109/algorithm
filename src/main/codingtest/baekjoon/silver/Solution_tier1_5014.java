package main.codingtest.baekjoon.silver;

/*
    문제 : 스타트링크
    난이도 : 실버 1
    알고리즘 : 그래프이론, 그래프탐색, 너비우선탐색, BFS
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 다시 돌아가야 하는 경우가 있으므로 내 코드는 오류가 생김
public class Solution_tier1_5014 {

    private int F;  // 건물 높이
    private int S;  // 강호의 위치
    private int G;  // Starlink 위치
    private int U;  // 위로 U만큼 올라가는 버튼
    private int D;  // 아래로 D만큼 내려가는 버튼
    private boolean[] visited;

    private void solve() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];   // 층 방문

        bfs(S);

    }

    // 넓이 탐색 시작
    private void bfs(int start) {
        
        // bfs 탐색을 위한 Queue 선언
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        // 방문 층, true로
        visited[start] = true;

        // while문을 통해 탐색 시작
        while(!queue.isEmpty()) {
            int[] test = queue.poll();
            int curPos = test[0];
            int count = test[1];

            // 탐색 종료 조건 확인
            if(curPos == G){
                System.out.println(count);
                return;
            }

            // 위 버튼 눌렀을 때, 경우의 수 추가
            int upPos = curPos + U;
            if(upPos <= F && !visited[upPos]){
                visited[upPos] = true;
                queue.offer(new int[]{upPos, count+1});
            }

            // 아래 버튼 눌렀을 때, 경우의 수 추가
            int downPos = curPos - D;
            if(downPos > 0 && !visited[downPos]){
                visited[downPos] = true;
                queue.offer(new int[]{downPos, count+1});
            }
        }

        // 모든 탐색이 다 끝났는데도, 탐색 종료 조건을 못찾았을 경우
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws Exception{
        new Solution_tier1_5014().solve();
    }
}
