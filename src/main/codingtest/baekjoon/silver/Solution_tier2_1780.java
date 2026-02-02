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

// 좌표값과 크기만으로 충분
public class Solution_tier2_1780 {

    int N;      // 배열 개수
    int minusOne, zero, plusOne;    // 그림 종류

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 종이가 모두 같은 수로 되어 있는 지 확인
        // 2. 종이가 모두 같은 수로 되어 있으면, ( 수 확인 해서 -1, 0, 1 count ++)
        // 3. 종이가 모두 같은 수로 되어 있지 않으면, 같은 크기 9개로 자름
        // 1 - 2 - 3 반복

        checkSame(arr);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);

    }
    
    // 1. 종이가 모두 같은 수로 되어 있는지 확인
    private void checkSame(int[][] arr) {
        
        int check = arr[0][0];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
               // 다른 수가 있는지 파악 되면
               if(check != arr[i][j]){
                   // 9 등분 하기
                   divideArray(arr);
                   return;
               }
            }
        }
        
        // 2. 위에서 return에 안걸렸으면, 모두 같은 수로 되어있으므로 그림 개수 파악
        if(check == -1){
            minusOne ++;
        }else if(check == 0){
            zero ++;
        }else{
            plusOne ++;
        }
    }

    // 3. 종이가 모두 같은 수로 되어 있지 않으면, 같은 크기 9개로 자름
    private void divideArray(int[][] arr){
        // 여기서 9등분 해서 나누고, checkSame으로 다시 보내기
        int length = arr.length;

        // 9등분 할 수 있는 조건 파악.
        // 1. length가 9 이상인지 파악 3, 9, 27, ...
        // - 9 등분하고, deviceArray로 arr 보냄
        if(length >= 9){
            int newLength = length / 3;
            int[][] newArr = new int[newLength][newLength];

            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    // 꼭지점으로 등분할 종이 배열 생성
                    if((i == 0 && j == 0)
                            ||(i % newLength == 0 && j == 0)
                            ||(i == 0 && j % newLength == 0)
                            ||(i % newLength == 0 && j % newLength == 0)){

                        int fromX = i;

                        for(int k = 0; k < newLength; k++){
                            int fromY = j;
                            for(int l = 0; l < newLength; l++){
                                newArr[k][l] = arr[fromX][fromY++];
                            }
                            fromX++;

                        }
                        checkSame(newArr);
                    }
                }
            }

        // 2. length가 3이면 3*3 배열 확인후 , 그림 개수 파악 후 증가
        }else{
            for (int[] ints : arr) {
                for (int j = 0; j < length; j++) {
                    if (ints[j] == -1) {
                        minusOne++;
                    } else if (ints[j] == 0) {
                        zero++;
                    } else {
                        plusOne++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier2_1780().solve_1();
    }
}