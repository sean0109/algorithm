package main.mytest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ConstructionGame {

    private int length;
    private int width;

    private int height; // 현재 최고 높이

    private boolean[][] firstFloor; // 1층의 상태

    List<Deque<Boolean>> status = new ArrayList();

    public ConstructionGame(int length, int width) {
        this.length = length;
        this.width = width;
        this.height = 0;

        for(int i = 0; i < length*width; i ++){
            Deque<Boolean> deque = new ArrayDeque<>();
            status.add(deque);
        }
    }

    // 테이블에 놓을 큐브 세트의 좌표를 나타내는 2차원 boolean 배열 매개변수
    public void addCubes(boolean[][] cubes) {


        // 추가
        height ++;
        for(int i = 0; i < cubes.length; i ++){
            Deque<Boolean> deque = status.get(i);
            for(int j = 0; j < cubes[i].length; j ++){
                deque.offerLast(cubes[i][i]);
            }
            status.set(i, deque);
        }
        
        boolean test = false;
        
        // 1층 확인후 판별
        for(int i = 0; i < cubes.length; i ++) {
            Deque<Boolean> deque = status.get(i);
            while(!deque.peekFirst()) {
                test = deque.peekFirst();
            }
        }
        
        // 1층이 모두 True 면
        if(test){
            for(int i = 0; i < cubes.length; i ++) {
                Deque<Boolean> deque = status.get(i);
                if(!deque.isEmpty()){
                    deque.pollFirst();
                    status.set(i, deque);
                }
            }
            height --;
        }
    }

    // 구조물의 최대 수직 높이를 큐브 개수로 반환
    public int getHeight() {

        return height;
    }

    public static void main(String[] args) {
        ConstructionGame game = new ConstructionGame(2, 2);

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