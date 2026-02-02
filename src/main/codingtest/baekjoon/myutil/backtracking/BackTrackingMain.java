package main.codingtest.baekjoon.myutil.backtracking;

public class BackTrackingMain {

    public static void main(String[] args) {

        // 백트래킹 유틸
        Integer[] arr = {1,2,3,4};

        BackTrackingAlgorithm<Integer> myBackTrack = new BackTrackingAlgorithm<>(arr);

        myBackTrack.permutation(3, false).print();
        System.out.println("===========================");
        myBackTrack.permutation(3, true).print();
        System.out.println("===========================");
        myBackTrack.combination(3, false).print();
        System.out.println("===========================");
        myBackTrack.combination(3, true).print();
    }
}
