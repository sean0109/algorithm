package main.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 백트래킹 : 모든 경우의 수를 탐색하되, 조건에 맞지 않는 경우 미리 탐색을 중단하는 방법
public class Backtracking_01 {

    private static int N;
    private static boolean[] visited;
    private static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) {
        // 정수 N이 주어졌을 때, 1부터 N 까지의 숫자를 중복 없이 순열로 나열하는 모든 경우를 출력
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N+1]; // 1~N까지니까 크기 N+1

        backtrack(0);
    }

    private static void backtrack(int depth) {
        // depth : 현재까지 선택한 숫자 개수
        if(depth == N) {
            for(int num : output) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output.add(i); // 선택
                backtrack(depth + 1); // 다음 깊이로
                output.remove(output.size() - 1); // 백트래킹 (선택 취소)
                visited[i] = false;
            }
        }
    }
}
