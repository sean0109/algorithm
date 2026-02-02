package main.codingtest.baekjoon.silver;
/*
문제 : 부분수열의 합
알고리즘 : 완전탐색, 브루트포스
난이도 : 실버 2
시간제한 : 2초

아이디어 : 순열과 조합은 다르다. 해당 문제는 조합을 구하는 문제.
        이때는 visited 배열로 체크할 필요 없다. 순열은 순서가 바뀌어도 허용, 조합은 순서 변경을 허용 안함
        ex ) 1, 2, 3  / 2, 1, 3 -> 순열에서는 허용, 조합에서는 허용 x

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_tier2_1182_plus {

    private int [] arr;
    private int S;      // 찾아야 합계 값
    private int M;      // depth
    private int answer;

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        arr = new int[count];
        M = count;
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);
        if (S == 0) answer--;
        System.out.println(answer);

    }

    private void backtrack(int depth, int sum) {

        if (depth == M) {
            if (sum == S) answer++;  // 리프에서만 카운트
            return;
        }

        // 고를지
        backtrack(depth + 1, sum + arr[depth]);

        // 말지
        backtrack(depth + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier2_1182_plus().solve_1();
    }
}