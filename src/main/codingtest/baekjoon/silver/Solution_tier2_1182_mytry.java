package main.codingtest.baekjoon.silver;
/*
문제 : 부분수열의 합
알고리즘 : 완전탐색, 브루트포스
난이도 : 실버 2
시간제한 : 2초

아이디어 : 순열과 조합은 다르다. 해당 문제는 조합을 구하는 문제.
        이때는 visited 배열로 체크할 필요 없다. 순열은 순서가 바뀌어도 허용, 조합은 순서 변경을 허용 안함
        ex ) 1, 2, 3  / 2, 1, 3 -> 순열에서는 허용, 조합에서는 허용 x

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_tier2_1182_mytry {

    private static int[] arr;           // 주어진 배열
    private static int N;               // 배열 개수
    private static int S;               // 찾아야 할 합계

    private static int depth;                               // 탐색 종료 깊이
    private static List<Integer> list = new ArrayList<>();  // 수열 저장

    private static int count;                               // 부분 수열의 개수

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(depth, 0);
        System.out.println(count);  // 개수 출력

    }

    private static void backTracking(int depth, int start) {
        // 합산을 구해서 S와 같은 경우 count ++;
        int sum = 0;
        if(!list.isEmpty()){

            for(int i : list){
                sum += i;
            }

            if(sum == S){
                count++;
            }
        }

        // 탐색 종료 조건
        if(depth == N){
            return; // 끝
        }

        for(int i = start; i < N; i++){
            list.add(arr[i]);
            backTracking(depth + 1, i+1);
            list.remove(list.size() - 1);
        }
    }
}