package com.mohadian;

public class SumInArray {

    private static boolean findSumInArray(int[] array, int target) {
        int start = 0;
        int end = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            end = i;

            while (sum > target && start < end) {
                sum -= array[start];
                start++;
            }

            if (sum == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 9, 7, 3};
        int target = 8;

        System.out.println(findSumInArray(array, target));
    }
}
