package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    문제 : 용돈 관리
    난이도 : 실버 1
    알고리즘 : 이분탐색, 매개변수탐색
    시간제한 : 1초
*/
public class Solution_tier1_6236 {

    private static int N, M;            // N일동안, M번만 통장에서 돈을 빼서 씀
    private static int[] withdrawMoney; // 날짜 별 인출 금액
    private static int K;               // 정답 : 현우가 필요한 최소 금액

    // 이분탐색 (Binary Serach)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        withdrawMoney = new int[N];

        int left = 0;   // 탐색 최소 값
        int right = 0;  // 탐색 최대 값

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            withdrawMoney[i] = money;

            left = Math.max(left, money);
            right += money;
        }

        // 이분 탐색 시작 (인출 최소 금액 찾기)
        while(left <= right){

            int mid  = (left + right) / 2;  // 탐색 금액 (인출 금액)
            int remain = 0;                 // 남은 금액
            int count = 0;                  // 인출 횟수

            // 횟수 계산
            for(int i = 0; i < N; i++){
                // 남은 금액이 오늘 쓸 금액보다 이상이면, 그냥 씀
                if(remain < withdrawMoney[i]) {
                    remain = mid;       // 인출
                    count++;
                }
                remain -= withdrawMoney[i];
            }

            // 인출 횟수 판독
            if(count <= M){     // 인출 횟수가 M보다 작으면, 금액을 줄여라 (정답 저장 블럭)
                right = mid - 1;
                K = mid;        // 정답 save : 최소 금액을 찾는 것이므로, 해당 조건(금액을 줄이는)에서 정답 저장.
            }else {             // 인출 횟수가 M보다 많으면, 금액을 늘려라
                left = mid + 1;
            }
        }
        System.out.println(K);      // 정답 출력
    }
}
