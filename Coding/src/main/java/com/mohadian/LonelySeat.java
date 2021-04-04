package com.mohadian;

import java.util.Arrays;
import java.util.List;

public class LonelySeat {

    /**
     * Find a seat furthest from other people on a randomly populated bench.
     * <p>
     * Implement the following method:
     * <p>
     * int findBestSeat(bool[] seats) {
     * // write this function returning the best seat
     * }
     * <p>
     * Examples:
     * <p>
     * [1, 0, 0, 0, 1], returns seat 2
     * <p>
     * [1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1], returns seat 8
     */
    int findBestSeat(List<Integer> seats) {
        int startIndex = -1;
        int maxIndex = 0;
        int maxLength = 0;
        int len = seats.size() - 1;

        for (int i = 0; i <= len; i++) {
            if (seats.get(i) == 1) {
                if (startIndex >= 0) {
                    if ((i - startIndex) > maxLength) {
                        int dist = (i - startIndex) / 2;
                        if (dist > maxLength) {
                            maxLength = dist;
                            maxIndex = startIndex + (i - startIndex) / 2;
                        }
                    }
                } else {
                    // If no one is seating at the first seat
                    maxIndex = 0;
                    maxLength = i;
                }
                startIndex = i;
            }
        }

        if (seats.get(len) == 0) {
            if (maxLength < len - startIndex) {
                maxIndex = len;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        LonelySeat lonelySeat = new LonelySeat();
        int index = lonelySeat.findBestSeat(Arrays.asList(1, 0, 0, 0, 0, 0, 0, 1));
        System.out.println(index);
    }
}
