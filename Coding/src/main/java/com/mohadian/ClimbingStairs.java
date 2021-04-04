package com.mohadian;

public class ClimbingStairs {

    private int calculate(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps < 3) {
            return steps;
        } else {
            return calculate(steps - 1) + calculate(steps - 2);
        }
    }

    private int calculateMemo(int steps, int[] memo) {
        if (memo[steps] > 0) {
            return memo[steps];
        }
        if (steps < 0) {
            return 0;
        } else if (steps < 3) {
            memo[steps] = steps;
            return steps;
        } else {
            memo[steps] = calculateMemo(steps - 1, memo) + calculateMemo(steps - 2, memo);
            return memo[steps];
        }
    }

    public static void main(String[] args) {
        ClimbingStairs climb = new ClimbingStairs();
//        int count = climb.calculateMemo(20, new int[21]);
        int count = climb.calculate(30);
        System.out.println(count);
    }
}
