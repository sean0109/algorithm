package main.codingtest.baekjoon.bronze;

/*
    문제 : 대표값2
    난이도 : 브론즈2
    시간제한 : 1초
    알고리즘 : 수학, 구현, 정렬, 사칙연산
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_tier2_2587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [] arr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        sb.append(sum / 5).append("\n");
        sb.append(arr[2]);

        System.out.println(sb);
    }
}
