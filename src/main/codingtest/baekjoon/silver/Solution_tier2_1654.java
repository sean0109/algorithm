package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : 랜선 자르기
알고리즘 : 이분 탐색, 매개 변수 탐색
난이도 : 실버 2
힌트 :
시간제한 : 2초

*/
public class Solution_tier2_1654 {

    // 이진 탐색
    private static void codeReview() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        long max = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) max = arr[i];
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;

            for(int i = 0; i < arr.length; i++){
                count += arr[i] / mid;
            }

            if(count >= k) {
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }


    private void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];

        for(int i = 0; i < n; i ++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr[arr.length - 1];
        boolean resume = true;

        int count = 0;
        int answer = 0;
        while(resume){
            answer = (right + left) / 2 ;
            count = 0;
            for(int i = 0; i < n; i ++){
                count += arr[i] / answer;
            }

            if(count == k){
                resume = false;
            }else{
                if(count > k){
                    left = answer;
                }else {
                    right = answer;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier2_1654().codeReview();
    }
}