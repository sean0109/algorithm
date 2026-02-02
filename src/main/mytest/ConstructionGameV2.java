package main.mytest;

import java.util.*;

public class ConstructionGameV2 {

    private int length;                 // 행
    private int width;                  // 열
    private int tiles;                  // 타일의 개수

    List<Deque<Boolean>> blockStatus = new LinkedList<>();    // 블럭의 상태

    public ConstructionGameV2(int length, int width) {
        this.length = length;
        this.width = width;
        this.tiles = length * width;

        for(int i = 0; i < tiles; i ++){
            Deque<Boolean> deque = new ArrayDeque<>();
            blockStatus.add(deque);
        }
    }

    // 테이블에 놓을 큐브 세트의 좌표를 나타내는 2차원 boolean 배열 매개변수
    public void addCubes(boolean[][] cubes) {

        int cTile = 0;
        // 블럭 추가
        for(int i = 0; i < length; i ++){
            for(int j = 0; j < width; j ++){
                Deque<Boolean> queue = blockStatus.get(cTile++);
                boolean cube = cubes[i][j];
                if(cube){
                    queue.add(cube);
                }
            }
        }

        // 1층 확인 후 제거. & 중력의 법칙 적용
        int flag = 0;   // 비어있는 개수

        for(Deque<Boolean> tileStatus: blockStatus){

            boolean test = Boolean.TRUE.equals(tileStatus.peek());
            if(tileStatus.isEmpty() || !test){
                flag++;
            }
        }

        // 1층이 모두 true 면 해당 좌표값을 가진 각각의 queue 모두 하나씩 poll

        if(flag == 0){
            for(Deque<Boolean> tileStatus: blockStatus){
                tileStatus.poll();  // 하나만 제거. ( 1층만 제거 )
            }
        }
    }

    // 구조물의 최대 수직 높이를 큐브 개수로 반환
    public int getHeight() {

        int curHeight = 0;

        for(Deque<Boolean> tileStatus: blockStatus){
            curHeight = Math.max(tileStatus.size(), curHeight);
        }
        return curHeight;
    }

    public static void main(String[] args) {
        ConstructionGameV2 game = new ConstructionGameV2(2, 2);

        game.addCubes(new boolean[][] {
                { true, true },
                { false, false } });

        game.addCubes(new boolean[][] {
                { true, true },
                { false, true } });

        System.out.println(game.getHeight()); // should print 2

        game.addCubes(new boolean[][] {
                { false, false },
                { true, true } });

        System.out.println(game.getHeight()); // should print 1

    }
}