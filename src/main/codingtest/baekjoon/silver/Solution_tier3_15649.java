package main.codingtest.baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    문제 : N과 M (1)
    난이도 : 실버 3
    알고리즘 : 백트래킹
    시간제한 : 1초
*/

public class Solution_tier3_15649 {

    private int N;  // 주어진 순열 개수
    private int M;  // depth
    private boolean visited [];
    private List<Integer> output = new ArrayList<>();

    private void solve() throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 개수
        M = sc.nextInt();   // depth
        visited = new boolean[N + 1];

        backtrack(0);
    }

    // 백 트래킹
    private void backtrack(int depth){

        if(depth == M){
            for(int i : output){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){ // 숫자 탐색
            if(!visited[i]){
                visited[i] = true;
                output.add(i);
                backtrack(depth+1);
                output.remove(output.size()-1); // 마지막 값 제거
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier3_15649().solve();
    }
}
