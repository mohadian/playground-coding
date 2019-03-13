package com.mohadian;

public class BinaryGap {
    private static int solution(int N) {
        // 100101
        // 2^5 + 2^2 + 2^0
        // 1000010001 = 2^9 + 2^4 + 2^0 = 512 + 16 + 1

        int maxGap = 0;

        int mbit;
        int previous = 0;
        while (N > 0) {
            mbit = maxBit(N);
            int gap = previous - mbit - 1;
            if (gap > 0 && gap > maxGap) {
                maxGap = gap;
            }
            previous = mbit;
            N -= Math.pow(2, mbit);
        }
        return maxGap;
    }

    private static int maxBit(int x) {
        return (int) Math.floor(Math.log(x) / Math.log(2));
    }

    public static void main(String[] args) {
        System.out.println(solution(1610612737));
    }
}
