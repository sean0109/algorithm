package main.mytest;

import java.util.*;

public class ConstructionGameV3 {

    private int length;                 // 행
    private int width;                  // 열
    private int tiles;                  // 타일의 개수

    Queue<Boolean>[][] blockStatus;

    public ConstructionGameV3(int length, int width) {
        this.length = length;
        this.width = width;
        this.tiles = length * width;

        blockStatus = (Queue<Boolean>[][]) new LinkedList[length][width];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                Queue<Boolean> status = new LinkedList<>();
                blockStatus[i][j] = status;
            }
        }
    }

    // 테이블에 놓을 큐브 세트의 좌표를 나타내는 2차원 boolean 배열 매개변수
    public void addCubes(boolean[][] cubes) {

        int count = 0;

        // 블럭 추가
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                Queue<Boolean> status = blockStatus[i][j];
                // true 일때만 저장
                if(cubes[i][j]){
                    status.offer(cubes[i][j]);  // 블럭 유무 를 queue에 저장
                }

                // 해당 좌표가 true인지 확인 ( 블럭이 존재하는지 확인 )
                if(Boolean.TRUE.equals(status.peek())){
                    count ++;
                }
                blockStatus[i][j] = status; // 다시 blockStatus에 저장
                
            }
        }

        // 1층 확인 후 제거. & 중력의 법칙 적용
        if(count == tiles){
            for(int i = 0; i < length; i++){
                for(int j = 0; j < width; j++){
                    Queue<Boolean> status = blockStatus[i][j];
                    status.poll();
                    blockStatus[i][j] = status;
                }
            }
        }
    }

    // 구조물의 최대 수직 높이를 큐브 개수로 반환
    public int getHeight() {
        int currentHeight = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                Queue<Boolean> status = blockStatus[i][j];
                currentHeight = Math.max(currentHeight, status.size());
            }
        }

        return currentHeight;
    }

    public static void main(String[] args) {
        ConstructionGameV3 game = new ConstructionGameV3(2, 2);

        game.addCubes(new boolean[][] {
                { true, true },
                { true, false } });

        game.addCubes(new boolean[][] {
                { true, true },
                { true, false } });

        System.out.println(game.getHeight()); // should print 2

        game.addCubes(new boolean[][] {
                { false, false },
                { false, true } });

        System.out.println(game.getHeight()); // should print 1
        game.addCubes(new boolean[][] {
                { false, false },
                { false, false } });
        System.out.println(game.getHeight()); // should print 1
        game.addCubes(new boolean[][] {
                { false, false },
                { false, true } });
        System.out.println(game.getHeight()); // should print 0
        game.addCubes(new boolean[][] {
                { true, true },
                { true, true } });
        System.out.println(game.getHeight()); // should print 0
        game.addCubes(new boolean[][] {
                { true, false },
                { false, true } });
        System.out.println(game.getHeight()); // should print 1
        game.addCubes(new boolean[][] {
                { false, true },
                { true, false } });
        System.out.println(game.getHeight()); // should print 0
    }
}