package main.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_tier5_2470_2 {

    private static int N;
    private static int[] status;

    // 투포인터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        status = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(status);

        // 1. 0에 가까운 값을 찾기위해 투포인터 탐색을 진행한다.
        // 2. 그 중에서 두 수의 합의 절대값의 최소값을 저장해 나간다. 이때 두 용액의 위치를 저장한다.
        // 3. 탐색이 끝나면 2번에 해당하는 두 용액의 위치를 출력한다.

        int sum = Math.abs(status[0] + status[N-1]);
        int left = 0;
        int right = N - 1;

        int solution_1 = 0;  // 1번 용액
        int solution_2 = 0;  // 2번 용액

        while(left < right){
            int tempSum = status[left] + status[right];
            int absTempSum = Math.abs(tempSum);

            if(absTempSum <= sum){  // 최적의 용액 갱신
                sum = absTempSum;
                solution_1 = status[left];
                solution_2 = status[right];
            }

            // 합이 0보다 작으면 left를 늘려보자
            if(tempSum < 0){
                left++;
                // 합이 0보다 크면 right를 줄여보자
            }else if(tempSum > 0){
                right--;
            }else{
                break;
            }
        }
        System.out.println(solution_1 + " " + solution_2);
    }
}
