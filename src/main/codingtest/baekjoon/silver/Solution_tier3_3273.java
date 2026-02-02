package main.codingtest.baekjoon.silver;

/*
문제 : 두 수의 합
난이도 : 실버 3
알고리즘 : 투 포인터, 정렬
시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_tier3_3273 {

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        // 1, 2, 3, 5, 7, 9, 10, 11, 12

        int target = Integer.parseInt(br.readLine());
        int sum = 0;
        int left = 0;
        int right = n-1;
        int cnt = 0;

        // 탐색 시작
        while(left < right){
            sum = arr[left] + arr[right];

            if(sum == target){
                //left ++;
                //right --;
                cnt ++;
            }
            if(sum <= target){
                left ++;
            }else {
                right --;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier3_3273().solve_1();
    }
}