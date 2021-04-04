package com.mohadian;

public class Masseuse {

    public static void main(String[] args) {
        int[] times = {30, 15, 60, 75, 45, 15, 15, 45};

        int maxTime = calculateMaxTime(times);

        System.out.println(maxTime);
    }

    private static int calculateMaxTime(int[] times) {
        return calculateMaxTime(times, 0, new int[times.length]);
    }

    private static int calculateMaxTime(int[] times, int index, int[] memo) {
        if (index >= times.length) {
            return 0;
        }

        if (memo[index] == 0) {
            int bestTimeWith = times[index] + calculateMaxTime(times, index + 2, memo);
            int bestTimeWithout = calculateMaxTime(times, index + 1, memo);
            memo[index] = Math.max(bestTimeWith, bestTimeWithout);
        }

        return memo[index];
    }
}
