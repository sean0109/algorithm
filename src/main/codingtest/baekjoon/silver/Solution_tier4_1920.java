package main.codingtest.baekjoon.silver;

/*
    문제 : 수 찾기
    난이도 : 실버 4
    알고리즘 : 자료구조, 정렬, 이분탐색, 해시를 사용한 집합과맵, 집합과 맵
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_tier4_1920 {

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    // 이분탐색으로 풀기
    private void solve_2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){

            int target = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N-1;

            int isNumber = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == target) {
                    isNumber = 1;
                    break;
                } else if (arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(isNumber).append("\n");   // 존재하지 않으면 0
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        //new Solution_tier4_1920().solve_1();
        new Solution_tier4_1920().solve_2();
    }
}
