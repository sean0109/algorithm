package main.codingtest.baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    문제 : N과 M(9)
    난이도 : 실버 2
    알고리즘 : 백트래킹
    시간제한 : 1초
*/
public class Solution_tier2_15663 {

    // 순열, 같은 수 중복 x
    private static int N, M;
    private static int[] arr;
    private static boolean [] visited;

    private static final List<Integer> output = new ArrayList<>();
    private static final Set<String> answerSet = new LinkedHashSet<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0);
        for (String e : answerSet) {
            System.out.println(e);
        }

    }

    private static void backTracking(int depth) {

        if (depth == M) {
            sb = new StringBuilder();
            for (Integer e : output) {
                sb.append(e).append(" ");
            }
            String saveData = sb.toString();
            answerSet.add(saveData);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output.add(arr[i]);
                backTracking(depth + 1);
                visited[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }
}
