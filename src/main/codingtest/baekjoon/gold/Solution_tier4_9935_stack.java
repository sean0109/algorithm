package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    문제 : 문자열 폭발
    난이도 : 골드4
    시간제한 : 2초
    알고리즘 : 자료구조, 문자열, 스택
*/
public class Solution_tier4_9935_stack {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String given = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        for (char e : given.toCharArray()) {

            stack.push(e);  // 추가해 나가면서, 검사

            if (stack.size() >= bombLen) {

                boolean isBomb = true;      // 마지막 문자열이 폭탄인지 검사
                
                // 폭탄의 문자열 개수 만큼 스택에서 꺼냄
                for (int i = 0; i < bombLen; i ++) {
                    if (stack.get(stack.size() - bombLen + i) != bomb.charAt(i)) {
                        isBomb = false;
                        break;
                    }
                }
                // 폭탄이면 제거
                if (isBomb) {
                    for (int i = 0; i < bombLen; i++) {
                        stack.pop();
                    }
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();

        for (Character e : stack) {
            sb.append(e);
        }

        if (!sb.isEmpty()) {
            System.out.println(sb.toString());
        }else {
            System.out.println("FRULA");
        }
    }
}
