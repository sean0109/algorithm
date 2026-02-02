package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

/*
    문제 : 2기타 레슨
    난이도 : 골드 5
    시간 제한 : 2초
    알고리즘 : 이분탐색, 매개변수탐색
*/

public class Solution_tier5_2343 {

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 값, 최대값 구하기
        OptionalInt maxOpt = Arrays.stream(arr).max();
        int left = maxOpt.isPresent() ? maxOpt.getAsInt() : 0;  // 최소
        int right = Arrays.stream(arr).sum();   // 최대

        int answer = right;

        while (left <= right ) {
            int mid = (left + right) / 2;

            // 개수 계산
            int count = getBlueRayCount(mid);

            if (count > M) {    // 블루레이 개수를 줄여야 함으로, 블루레이 크기를 늘려야함
                left = mid + 1;
            }else {             // 블루레이 개수를 늘려야 함으로, 블루레이 크기를 줄여야 함
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static int getBlueRayCount(int size) {
        
        // 더해나가다가 size 체크
        int cnt = 1;
        int tempSum = 0;

        for (int e : arr) {
            // 검증. 이번 강의를 추가 했을때, 용량을 초과하면, 개수를 하나 늘려주고,
            // 새로운 블루레이에 현재 강의를 추가한다.
            if (tempSum + e > size) {
                cnt ++;         // 블루레이 개수 추가
                tempSum = e;    // 새로운 블루레이에 현재 강의 추가
                
            }else {
                tempSum += e;
            }
        }
        return cnt;
    }
}
