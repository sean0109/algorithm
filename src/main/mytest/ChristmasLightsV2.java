package main.mytest;

import java.util.Arrays;

public class ChristmasLightsV2 {

    private final int lightCount;   // 전구 개수
    private boolean isForward;      // 방향 체크
    private int searchIdx;          // 탐색 시작 인덱스

    public ChristmasLightsV2(int lightCount) {
        this.lightCount = lightCount;
        this.isForward = true;
        this.searchIdx = 0;
    }

    public boolean[] next() {
        boolean[] lights = new boolean[lightCount];

        if(isForward){

            if(!lights[searchIdx]){
                lights[searchIdx] = true;
            }

            searchIdx++;    // 1 증가
            
            // 끝까지 도달하면, 방향 전환
            if(searchIdx == lightCount-1){
                isForward = false;
            }

        }else{

            if(!lights[searchIdx]){
                lights[searchIdx] = true;
            }

            searchIdx--;
            
            // 첫 인덱스로 왔을 경우 다시 방향 전환
            if(searchIdx == 0){
                isForward = false;
            }
        }


        return lights;
    }

    public static void main(String[] args) {
        ChristmasLightsV2 lights = new ChristmasLightsV2(8);

        for (int i = 0; i < 11; i++) {
            System.out.println("Step " + (i + 1) + ": " + Arrays.toString(lights.next()));
        }
    }
}