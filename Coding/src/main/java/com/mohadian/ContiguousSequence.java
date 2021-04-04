package com.mohadian;

import java.util.Arrays;

public class ContiguousSequence {

    private int[] findLargestSum(int[] array) {
        int[] indexes = findLargestSumIndexes(array);

        return copyLargestSum(array, indexes);
    }

    private int[] copyLargestSum(int[] array, int[] indexes) {
        int len = array.length;

        if (indexes[0] > len || indexes[1] > len) {
            return new int[]{};
        }

        int resLen = indexes[1] - indexes[0] + 1;
        int[] res = new int[resLen];

        for (int i = 0; i < resLen; i++) {
            res[i] = array[i + indexes[0]];
        }

        return res;
    }

    private int[] findLargestSumIndexes(int[] array) {
        int max = array[0];
        int len = array.length;
        int start = 0;
        int end = 0;
        int temp = 0;
        int maxStart = 0;
        int maxEnd = 0;

        while (start < len && end < len) {
            temp += array[end];
            if (temp < 0) {
                start = end + 1;
                end = end + 1;
                temp = 0;
            } else {
                if (temp > max) {
                    maxStart = start;
                    maxEnd = end;
                }
                end = end + 1;
            }
        }

        return new int[]{maxStart, maxEnd};
    }

    public static void main(String[] args) {
//        int[] array = {2, -8, 3, -2, 4, -10};
        int[] array = {2, 3, -8, -1, 2, 4, -2, 3};

        ContiguousSequence contiguousSequence = new ContiguousSequence();

        int[] sequence = contiguousSequence.findLargestSum(array);

        System.out.println(Arrays.toString(sequence));
    }
}
