package main.algorithm;

// 재귀 함수
public class Recursion_01 {

    private int factorial(int n) {
        if(n == 0) return 1;

        return n * factorial(n-1);
        // 5 * 4 * 3 * 2 * 1
    }

    public static void main(String[] args) {
            new Recursion_01().factorial(5);
    }

}
