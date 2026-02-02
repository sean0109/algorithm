package main.codingtest.baekjoon.silver;

/*
    문제 : 종이의 개수
    알고리즘 : 분할 정복, 재귀
    난이도 : 실버 2
    시간제한 : 2초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 새로운 그림 배열을 만들지 않고, 좌표값과 탐색 범위(길이) 를 넘겨서 해결
public class Solution_tier2_1780_plus {

    int minusOne, zero, plusOne;    // 그림 종류
    int[][] picture;                // 그림

    // 9등분을 할 때, 새로운 길이로 꼭지점 좌표를 구해야 함 ( 꼭지점은 새로운 그림의 좌 상단 시작점 위치를 의미 )
    int[] dx = {0, 0, 0, 1, 1, 1, 2, 2, 2}; // 꼭지점의 x 좌표를 찾기 위한 변화량 (배수)
    int[] dy = {0, 1, 2, 0, 1, 2, 0, 1, 2}; // 꼭지점의 y 좌표를 찾기 위한 변화량 (배수)

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        picture = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideNine(0, 0, N);    // 탐색 시작 x 좌표, 탐색 시작 y 좌표, 탐색 범위

        System.out.println(minusOne + "\n" + zero + "\n" + plusOne);

    }

    // 1. 종이 9등분
    private void divideNine(int x, int y, int length){
        // 2. 종이가 같은 수로 되어 있는지 확인
        boolean isSame = checkSame(x, y, length);

        // 3. 같은 수로 되어 있을 경우
        if(isSame){
            if(picture[x][y] == -1){
                minusOne++;
            }else if(picture[x][y] == 1){
                plusOne++;
            }else{
                zero++;
            }
        }else{
            // 4. 같은 수로 되어 있지 않을 경우 - 9등분 할 꼭지점의 x 좌표, y 좌표,
            int newLength = length / 3;
            for(int i = 0; i < 9; i++){
                divideNine(x + dx[i] * newLength, y + dy[i] * newLength, newLength);
            }
        }
    }


    private boolean checkSame (int x, int y, int length) {
        
        // 탐색 시작 지점의 값을 기준으로 잡고
        int checkValue = picture[x][y];
        
        for(int i = x; i < x + length; i++){
            for(int j = y; j < y + length; j++){
                if(checkValue != picture[i][j]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier2_1780_plus().solve_1();
    }
}