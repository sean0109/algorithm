package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    문제 : 수 정렬하기 2
    난이도 : 실버 5
    알고리즘 : 수 정렬하기, 수 정렬하기 3
    시간제한 : 2초
*/
public class Solution_tier5_2751 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);

    }
}
