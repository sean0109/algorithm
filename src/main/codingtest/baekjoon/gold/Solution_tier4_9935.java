package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 : 문자열 폭발
    난이도 : 골드4
    시간제한 : 2초
    알고리즘 : 자료구조, 문자열, 스택
*/
public class Solution_tier4_9935 {
    
    // 해당 풀이는 메모리 초과
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder rebuild = new StringBuilder(br.readLine());
        String bomb = br.readLine();

        while (rebuild.indexOf(bomb) > -1 ) {
            String[] tempArr = rebuild.toString().split(bomb);

            rebuild = new StringBuilder();
            for (String e : tempArr) {
                rebuild.append(e);
            }
        }

        if (rebuild.length() == 0) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(rebuild.toString());
    }
}
