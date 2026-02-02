package main.codingtest.baekjoon.myutil.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 순열, 조합 백 트래킹
public class BackTrackingAlgorithm<T> {

    private int N;                          // depth
    private T[] data;                       // data
    private boolean[] visited;              // 방문여부

    private List<T> output = new ArrayList();   // 모든 경우의 수 저장
    StringBuilder sb = new StringBuilder();     // 출력값 저장
    private int count;

    // 생성자
    public BackTrackingAlgorithm(T[] data) {
        this.data = Arrays.copyOf(data, data.length);
        visited = new boolean[data.length];
    }

    /**
     * 순열
     * @param n
     * @param duplicate
     * @return
     */
    public BackTrackingAlgorithm<T> permutation(int n,  boolean duplicate ){

        clearData(n);

        // 중복 허용 o
        if(duplicate){
            backTrackP_dupY(0);
        // 중복 혀용 x
        }else{
            backTrackP_dupN(0);
        }
        return this;
    }

    /**
     * 순열, 중복 허용
     * @param depth
     */
    private void backTrackP_dupY(int depth) {

        if(depth == N){
            for(T t : output){
                sb.append(t).append(" ");
            }
            count ++;
            sb.append("\n");
            return;
        }

        for(int i = 0; i < data.length; i++){
                output.add(data[i]);
                backTrackP_dupY(depth+1);
                output.remove(output.size()-1);
        }
    }

    /**
     * 순열 , 중복 제한
     * @param depth
     */
    private void backTrackP_dupN(int depth) {

        if(depth == N){
            for(T t : output){
                sb.append(t).append(" ");
            }
            count ++;
            sb.append("\n");
            return;
        }

        for(int i = 0; i < data.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output.add(data[i]);
                backTrackP_dupN(depth+1);
                visited[i] = false;
                output.remove(output.size()-1);
            }
        }
    }

    /**
     * 조합
     * @param n
     * @param duplicate
     * @return
     */
    public BackTrackingAlgorithm<T> combination(int n,  boolean duplicate){

        clearData(n);

        // 중복 허용 o
        if(duplicate){
            backTrackC_dupY(0, 0);
        // 중복 혀용 x
        }else{
            backTrackC_dupN(0, 0);
        }
        return this;
    }

    private void clearData(int depth) {
        N = depth;
        sb = new StringBuilder();
        visited = new boolean[data.length];
        count = 0;
        output.clear();
    }

    /**
     * 조합, 중복 허용
     * @param depth
     * @param fromIndex
     */
    private void backTrackC_dupY(int depth, int fromIndex) {
        if(depth == N){
            for(T t : output){
                sb.append(t).append(" ");
            }
            count ++;
            sb.append("\n");
            return;
        }

        for(int i = fromIndex; i < data.length; i++){
            output.add(data[i]);
            backTrackC_dupY(depth+1, i);
            output.remove(output.size()-1);
        }
    }

    /**
     * 조합, 중복 제한
     * @param depth
     * @param fromIndex
     */
    private void backTrackC_dupN(int depth, int fromIndex) {
        if(depth == N){
            for(T t : output){
                sb.append(t).append(" ");
            }
            count ++;
            sb.append("\n");
            return;
        }

        for(int i = fromIndex; i < data.length; i++){
            output.add(data[i]);
            backTrackC_dupN(depth+1, i+1);
            output.remove(output.size()-1);
        }
    }

    /**
     * 출력
     */
    public void print(){

        if("".equals(sb.toString())){
            System.out.println("경우의수가 존재하지 않습니다.");
            return;
        }

        System.out.println(sb.toString());
    }

    public int getCount() {
        return count;
    }

    public StringBuilder getSb() {
        return sb;
    }
}
