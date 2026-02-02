package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    문제 : N과 M (1)
    난이도 : 실버 3
    알고리즘 : 백트래킹
    시간제한 : 1초
*/

public class Solution_tier3_15649_2 {

    private static int N, M;
    //private static int[] arr;         // 배열 필요 없고, for문으로 해결
    private static boolean[] visited;

    private static List<Integer> output = new ArrayList<>();

    private static StringBuilder sb = new StringBuilder(); // 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        visited = new boolean[N + 1];   // 1부터 n 까지 이므로, 순번과 값을 맞춰주기 위해 length = N + 1 로 지정, 0번째는 버림
        backtrack(0);
        System.out.println(sb);
    }

    public static void backtrack(int depth) {

        if (depth == M) {
            // 출력
            for (int data : output) {
                sb.append(data).append(" ");
            }
            sb.append("\n");
            return; // 해당 경우의 수 출력 종료
        }

        //
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                output.add(i);
                visited[i] = true;
                backtrack(depth + 1);   // 재귀 호출해서 다음 숫자 올거 탐색 보내버리고

                // 방금 추가된거 빼고, 다른 가능성 탐색
                visited[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }
}
