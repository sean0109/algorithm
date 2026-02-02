package main.codingtest.baekjoon.silver;


/*
    문제 : 쇠막대기
    난이도 : 실버 2
    알고리즘 : 스택, 자료구조
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_tier2_10799 {

    private static Stack<Character> stack = new Stack();
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char temp = 'a';    // 레이저 판독 플래그
        int answer = 0;

        for (Character data : input.toCharArray()) {

            // 1. '(' 가 나오면 push
            // 2. ')' 가 나오면 레이저인지, 막대 끝 지점인지 확인 후 계산

            if(data == '('){
                stack.push(data);
            }

            if(data == ')'){
                stack.pop();
                if(temp == '('){    // 레이저인지 판독 여부 : 바로 직전 데이터가 ( 이면 레이저
                    answer += stack.size(); // 자르기

                }else{
                    // 막대 끝점 만난 것이므로, 마지막 조각 1개 추가
                    answer += 1;
                }
            }
            temp = data;    // 바로 직전 데이터 save ( 레이저 여부 판독을 위함 )
        }
        System.out.println(answer);

    }
}
