package main.codingtest.baekjoon.bronze;

/*
    문제 : 일곱 난쟁이
    난이도 : 브론즈 1
    알고리즘 : 브루트포스, 정렬
    시간제한 : 2초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_tier1_2309 {

    private static int[] height = new int[9];  // 10명의 키

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++){
            height[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(height);

        int index1 = 0;
        int index2 = 0;

        // 브루트 포스로 탐색
        for(int i = 0; i < 9; i++){
            index1 = i;

            for(int j = 0; j < 9; j++){
                if(j == index1) continue;
                index2 = j;
                // 합을 여기서 검증.
                int sum = 0;
                for(int k = 0; k < 9; k++){
                    if(k == index1 || k == index2) continue;
                    sum += height[k];
                }
                if(sum == 100){
                    break;
                }
            }
        }
        // 출력
        for(int i = 0; i < 9; i++){
            if(i == index1 || i == index2) continue;
            sb.append(height[i]).append("\n");
        }
        System.out.println(sb);
    }
}
