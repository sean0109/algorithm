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
public class Solution_tier1_5014_mytry {

    private int F;  // 건물 높이
    private int S;  // 강호의 위치
    private int G;  // Starlink 위치
    private int U;  // 위로 U만큼 올라가는 버튼
    private int D;  // 아래로 D만큼 내려가는 버튼
    private Set<Integer> visited = new HashSet<>(); // 방문했던 층

    private void solve() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        bfs(S);

    }

    // 넓이 탐색 시작
    private void bfs(int S) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});

        while(!queue.isEmpty()){
            int [] test = queue.poll();
            int cs = test[0];
            int count = test[1];
            if (cs == G){
                System.out.println(count);
                return;
            }

            if(cs < G){
                if(cs + U <= F){
                    cs = cs + U;
                }else {
                    cs = cs - D;
                }
            }

            if(cs > G && cs - D > 0){
                cs = cs - D;
            }

            if(visited.contains(cs)){
                System.out.println("use the stairs");
                return;
            }else{
                visited.add(cs);
                queue.add(new int[]{cs, ++count});
            }
        }

        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws Exception{
        new Solution_tier1_5014_mytry().solve();
    }
}
