package com.mohadian;

import java.util.Arrays;
import java.util.HashMap;

public class LettersAndNumbers {

    private static int[] findLongestOptimal(int[] array) {

        int[] diffs = findDiffs(array);

        int[] result = findRange(diffs);

        if (result != null && result.length == 2) {
            return Arrays.copyOfRange(array, result[0], result[1]);
        }
        return new int[0];
    }

    private static int[] findRange(int[] diffs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = 0;
        int rs = 0;
        int re = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (!map.containsKey(diffs[i])) {
                map.put(diffs[i], i);
            } else {
                int start = map.get(diffs[i]);
                if (i - start > length) {
                    length = i - start;
                    rs = start;
                    re = i;
                }
            }
        }
        if (length > 0) {
            return new int[]{rs, re};
        }
        return null;
    }

    private static int[] findDiffs(int[] array) {
        int[] diff = new int[array.length];

        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                ones++;
            } else {
                zeros++;
            }
            diff[i] = ones - zeros;
        }
        return diff;
    }

    private static int[] findLongestBF(int[] array) {

        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (hasEqual(array, i, j)) {
                    return Arrays.copyOfRange(array, i, j);
                }
            }
        }

        return new int[0];
    }

    private static boolean hasEqual(int[] array, int s, int e) {
        int count = 0;
        for (int i = s; i < e; i++) {
            if (array[i] == 0) {
                count++;
            } else {
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1};

        int[] result = findLongestBF(array);
        System.out.println(Arrays.toString(result));
        result = findLongestOptimal(array);

        System.out.println(Arrays.toString(result));
    }
}
