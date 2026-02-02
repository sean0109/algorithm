package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 나무자르기
알고리즘 : 이진탐색 / 매개변수 탐색
난이도 : 실버 2
시간제한 : 1초
*/
public class Solution_tier2_2805 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max){ max = arr[i]; }
        }

        int left = 1;
        int right = max;
        int mid = 0;
        int height = 0;
        int answer = 0;

        // 이진 탐색
        while(left <= right){
            mid = (left + right) / 2;
            height = 0;
            for(int i = 0; i < n; i ++){
                height += Math.max((arr[i] - mid), 0);
            }

            if(height >= k){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Solution_tier2_2805().solution();
    }
}
