package main.codingtest.programmers.levelone;

import java.util.stream.IntStream;

public class Solution_pcce_01 {

    public static void main(String[] args) {

        String [][] board = {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        int h = 0; int w = 1;
        int answer = new Solution_pcce_01().solution(board, h, w );
        System.out.println(answer);
    }

    private int solution(String[][] board, int h, int w) {
        int answer = 0;
        int [] dh = {0, 1, -1, 0};
        int [] dw = {1, 0, 0, -1};

        int minH = 0;
        int minW = 0;

        int maxH = board.length-1;
        int maxW = board[0].length-1;

        String color = board[h][w];

        for(int i = 0; i < 4; i ++){
            int targetH = h + dh[i];
            int targetW = w + dw[i];

            if((targetH >= 0 && targetH <= maxH) && (targetW >= 0 && targetW <= maxW)) {
                String findColor = board[targetH][targetW];

                if(color.equals(findColor)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private int solution_2(String[][] board, int h, int w) {
        //int answer = 0;

        return (int) IntStream.range(0, 4)
                .filter(i -> h + new int[] {0, 1, -1, 0}[i] >= 0 && h + new int[] {0, 1, -1, 0}[i] < board.length && w + new int[] {1, 0, 0, -1}[i] >= 0 && w + new int[] {1, 0, 0, -1}[i] < board.length)
                .filter(i -> board[h][w].equals(board[h + new int[] {0, 1, -1, 0}[i]][w + new int[] {1, 0, 0, -1}[i]]))
                .count();

        //return answer;
    }
}
