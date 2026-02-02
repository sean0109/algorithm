package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_tier4_11000 {

    private static int N;
    private static int[][] lectures;
    private static int maxCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 오름차순, 시작시간 같으면 종료 오름차순
        Arrays.sort(lectures, (e1, e2) -> {
            return e1[0] != e2[0] ? e1[0] - e2[0] : e1[1] - e2[1];
        });

        Queue<Integer> rooms = new PriorityQueue<>();   // 진행중인 강의들의 종료시간

        for (int[] lecture : lectures) {
            int startTime = lecture[0];
            int endTime = lecture[1];
            
            // 현재 진행중인 강의의 종료시간 <= 새 강의 시작시간 이면, 비워서 재사용
            while (!rooms.isEmpty() && rooms.peek() <= startTime) {
                rooms.poll();
            }

            // 아니면, 강의실 추가
            rooms.offer(endTime);
            maxCount = Math.max(maxCount, rooms.size());
        }
        System.out.println(maxCount);
    }
}
