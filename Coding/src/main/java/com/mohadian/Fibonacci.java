package com.mohadian;

public class Fibonacci {

    public int recursive(int n) {
        if (n < 2) return 1;
        return recursive(n - 1) + recursive(n - 2);
    }

    public int dynamic(int n) {
        return dynamicHelper(n, new int[n+1]);
    }

    private int dynamicHelper(int n, int[] memo) {
        if (n < 1) return 1;

        if (memo[n] == 0){
            memo[n] = dynamicHelper(n-1, memo) + dynamicHelper(n-2, memo);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int n = 100;
        System.out.println("Fib N " + n + " = " + fib.dynamic(n));
    }
}
