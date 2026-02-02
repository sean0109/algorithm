package main.codingtest.baekjoon.silver;

/*
    문제 : 스위치 켜고 끄기
    난이도 : 실버 4
    알고리즘 : 구현, 시뮬레이션
    시간제한 : 2초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_tier4_1244 {
    private static int[] status;        // 스위치 배열
    private static StringTokenizer st;  // 문자열 데이터 파싱 도구

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        status = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            status[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());

        for(int i = 0; i < students; i++){
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            switch (gender) {
                // 남학생
                case 1:
                    doMaleStudent(number);
                    break;
                case 2:
                    doFemaleStudent(number);
                    break;
                default:
                    throw new Exception("성별이 올바르지 않습니다.");
            }
        }

        // 정답 출력
        for (int i = 0; i < status.length; i++) {
            sb.append(status[i]);
            if((i + 1) % 20 == 0) {
                sb.append("\n");
            }else {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    // 남학생이 스위치를 조작한다.
    public static void doMaleStudent(int number){

        int pos = number - 1;   // 배열의 순번은 스위치 번호의 -1

        for(int i = pos; i < status.length; i++){

            if((i+1) % number == 0){
                changeStatus(i);
            }
        }
    }

    // 여학생이 스위치를 조작한다.
    public static void doFemaleStudent(int number){

        int pos = number - 1;   // 배열의 순번은 스위치 번호의 -1

        // 탐색 경계를 먼저 정해 주기
        int end = status.length - 1;

        int left = pos;
        int right = pos;

        // 중심에서 왼쪽, 오른쪽으로 범위 확장
        while(left-1 >= 0 && right + 1 <= end &&  status[left-1] == status[right+1]){
            left --;
            right ++;
        }

        for (int i = left; i <= right; i++) {
            changeStatus(i);
        }
    }

    // 스위치 상태 변경
    public static void changeStatus(int index){
        status[index] = status[index] == 0 ? 1 : 0;
    }
}
