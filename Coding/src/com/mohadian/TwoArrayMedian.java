package com.mohadian;

public class TwoArrayMedian {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8, 9, 15};
        int[] arr2 = {7, 11, 18, 19, 21, 25};

        int n = arr1.length;
        int m = arr2.length;

        int middle = (n + m + 1) / 2;

        System.out.println(middle);

    }
}
