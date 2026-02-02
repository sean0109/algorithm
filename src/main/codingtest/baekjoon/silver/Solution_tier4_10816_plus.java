package main.codingtest.baekjoon.silver;

/*
    문제 : 숫자카드2
    난이도 : 실버 4
    알고리즘 : 자료구조, 정렬, 이분탐색, 해시를사용한집합과맵
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분(이진) 탐색으로 풀어보기
public class Solution_tier4_10816_plus {

    private static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // *** 정렬된 배열에서 target의 개수를 구하려면...
        // 1. 왼쪽을 기준으로 target 값이 처음으로 등장하는 index를 구하고,
        // 2. target 값보다 큰 최소값의 인덱스를 구해서,
        // 3. 그 차이를 구하면 target의 개수가 된다.
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            // 두 인덱스의 차가 개수
            sb.append(findEndIndex(target) - findStartIndex(target)).append(" ");
        }

        System.out.println(sb);
    }
    // target 값보다 작은 최대값의 인덱스 구하기
    private static int findStartIndex(int target){

        // 탐색 범위 인덱스
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while(left <= right){
            mid = (left + right) / 2;

            if(arr[mid] >= target){  // 최초로 target 값이 이상이 되는 인덱스 찾기
                right = mid - 1;
            }else{
                left = mid + 1;
            }


        }
        // right 는 조건을 만족하지 않는 마지막 인덱스
        // left는 조건을 만족하는 첫번째 인덱스
        // mid는 그냥 탐색을 위한 중앙값
        // 헷갈리는 포인트 : mid는 단순히 현재 중앙값 이므로, 탐색 종료 시점에서는 left 값을 꺼내야 한다.

        // 원래 이분탐색에서 특정 값을 정확히 찾을 때 에는 mid 값을 리턴하는것이 일반적이다.
        return left;
    }

    // target 값보다 큰 최대값의 인덱스 구함
    private static int findEndIndex(int target){
        // 탐색 범위 인덱스
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while(left <= right){
            mid = (left + right) / 2;

            if(arr[mid] > target){  // 최초로 target 값을 초과하는 index 찾기
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        // 마찬가지
        return left;
    }
}
