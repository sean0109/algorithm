package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_tier5_5430_plus {
    // 뒤집는 것을, 덱큐의 출력 방향으로 생각
    /* 덱큐로 풀어보자 */
    private static int T;                   // 테스트 케이스 개수
    private static String p;                // 수행 함수
    private static int n;                   // 배열에 들어 있는 수의 개수
    private static Deque<Integer> deque;    // 문제를 풀기 위한 자료 구조
    private static StringBuilder sb = new StringBuilder(); // 정답 출력 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            String input = br.readLine();
            input = input.replace("[", "").replace("]", "");
            StringTokenizer st = new StringTokenizer(input, ",");
            for(int j = 0; j < n; j++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            solve();    // 문제 풀기
        }

        System.out.println(sb);
    }

    private static void solve() {

        boolean direction = true;       // true 일 경우 최종 pollFirst, false일 경우 최종 pollLast를 한다.

        for(char function : p.toCharArray()) {

            if(function == 'R'){
                direction = !direction; // 스위치
            }

            if(function == 'D'){

                if(direction){
                    if(deque.pollFirst() == null) {
                        sb.append("error").append("\n");
                        return;
                    }
                }else{
                    if(deque.pollLast() == null) {
                        sb.append("error").append("\n");
                        return;
                    }
                }
            }
        }
        sb.append("[");

        while(!deque.isEmpty()){

            if(direction){
                sb.append(deque.pollFirst());
            }else{
                sb.append(deque.pollLast());
            }
            if(!deque.isEmpty()) sb.append(",");
        }
        sb.append("]").append("\n");
    }
}
