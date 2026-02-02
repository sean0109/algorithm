package main.mytest;

import java.util.Arrays;

public class ChristmasLights {

    private final int lightCount;
    private int lightOnIndex;    // 불 켜진 인덱스
    private int searchIndex;    // 탐색 인덱스

    public ChristmasLights(int lightCount) {
        this.lightCount = lightCount;
        this.lightOnIndex = -1;
    }

    public boolean[] next() {
        boolean[] lights = new boolean[lightCount];

        // 정방향
        if(searchIndex < lightCount - 1){
            for(int i = lightOnIndex + 1; i < lightCount; i++){
                searchIndex = i;
                if(!lights[i]){
                    lights[i] = true;
                    lightOnIndex = i;
                    break;
                }
            }
        }

        // 역방향
        if(searchIndex >= lightCount - 1){
            for(int i = lightOnIndex -1; i > -1; i --){
                searchIndex = i;
                if(!lights[i]){
                    lights[i] = true;
                    lightOnIndex = i;
                    break;
                }
            }
        }
        return lights;
    }

    public static void main(String[] args) {
        ChristmasLights lights = new ChristmasLights(8);

        for (int i = 0; i < 11; i++) {
            System.out.println("Step " + (i + 1) + ": " + Arrays.toString(lights.next()));
        }
    }
}