package main.codingtest.baekjoon.silver;

/*
    문제 : 괄호
    난이도 : 실버 4
    알고리즘 : 자료 구조, 문자열, 스택
    시간 제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_tier4_9012 {
    
    private void solve_1() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String s = br.readLine();

            String YesOrNo = checkVPS(s);
            sb.append(YesOrNo);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private String checkVPS(String s) {

        Queue<Character> queue = new LinkedList<Character>();

        for(char c : s.toCharArray()){
            // 1. ( 이 들어 왔을 때
            if(c == '('){
                queue.offer(c);
            }

            // 2. ) 이 들어 왔을 때
            if(c == ')'){
                // 3. () 확인 후, queue 에서 제거
                if(!queue.isEmpty() && queue.peek() == '('){
                    queue.poll();
                    // 제거 안됐으면 바로 종료
                }else {
                    return "NO";
                }
            }
        }

        // 4. 다 끝났을 때 , queue에 아무것도 없으면 YES, 남아있으면 NO
        if(queue.isEmpty()){
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier4_9012().solve_1();
    }
}
