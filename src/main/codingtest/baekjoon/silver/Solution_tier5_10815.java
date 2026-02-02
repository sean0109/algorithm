package main.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
문제 : 숫자카드
난이도 : 실버 5
알고리즘 : 자료구조, 정렬, 이분탐색, 집합과맵
시간제한 : 2초
*/

public class Solution_tier5_10815 {

    private void solve() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt_1 = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt_1; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int cnt_2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt_2; i++) {
            sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0);
            if(i < cnt_2 - 1) sb.append(" ");
        }

        System.out.println(sb);
    }
    // 이진 탐색 방법
    private void solve_2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt_1 = Integer.parseInt(br.readLine());
        int [] arr = new int[cnt_1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt_1; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt_2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt_2; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(binarySearch(arr, target)) {
                sb.append(1);
            }else{
                sb.append(0);
            }
            if(i != cnt_2 - 1) sb.append(" ");
        }

        System.out.println(sb);
    }

    private boolean binarySearch(int []arr, int target) throws Exception {

        int left = 0, right = arr.length -1;
        boolean found = false;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                found = true;
                break;
            }else {
                if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return found;
    }
    
    // 이진 탐색 내부 함수 구현
    private void solve_3() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards); // 정렬 필수

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(cards, num) >= 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            if (i < M - 1) sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier5_10815().solve_2();
    }
}