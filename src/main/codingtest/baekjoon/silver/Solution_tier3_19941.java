package main.codingtest.baekjoon.silver;

/*
    문제 : 햄버거 분배
    난이도 : 실버 3
    알고리즘 : 그리디 정렬
    시간제한 : 0.5초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_tier3_19941 {

    private static void solve_1() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int count = 0;

        char[] table = new char[N];
        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {
            table[i] = input.charAt(i);
        }
        
        // 그리디 탐색
        for(int i = 0; i < table.length; i ++){
            // 사람일때 탐색
            if(table[i] == 'P'){
                findHamburger :
                for(int j = i - K; j < i + K + 1; j++){
                    if(j >= 0 && j < N){
                        if(table[j] == 'H'){        // 햄버거를 찾으면
                            table[j] = 'X';         // 먹는다.
                            count++;
                            break findHamburger;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
        solve_1();
    }
}