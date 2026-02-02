package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
문제 : 수들의 합 5
알고리즘 : 투포인터
난이도 : 실버 5
*/
public class Solution_tier5_2018 {
    // 멤버변수 = 필드변수
    // 멤버변수 -> 1. 클래스 변수 (static) 2. 인스턴스 변수

    private void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 지역변수
        int cnt = 1;
        int left = 1;
        int right = left + 1;  // 15
        int sum = 0;

        while(left != right){
            sum = 0;
            for(int i = left; i <= right; i ++){
                sum += i;
            }
            if(sum < n){
                right ++;
            }else if(sum > n){
                left ++;
            }else if(sum == n){
                cnt ++;
                right++;
            }
        }
        System.out.println(cnt);
    }

    private void solve_review() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int left = 1, right = 1;
        int sum = 1;
        int count = 1; // n 자기 자신도 포함

        while(right < n) {
            if(sum < n) {
                right++;
                sum += right;
            } else if(sum > n) {
                sum -= left;
                left++;
            } else { // sum == n
                count++;
                right++;
                sum += right;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        new Solution_tier5_2018().solve_review();
    }
}
