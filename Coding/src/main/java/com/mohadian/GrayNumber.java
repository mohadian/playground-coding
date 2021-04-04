package com.mohadian;

public class GrayNumber {

    private static boolean isGray(int a, int b) {
        int n = a ^ b;
        while (n > 0) {
            if ((n & 1) == 1 && n >> 1 > 0) return false;

            n = n >> 1;
        }
        return true;
    }

    private static boolean isGrayEfficient(int a, int b) {
        int n = a ^ b;
        return ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;

        System.out.println(isGray(a, b));
        System.out.println(isGrayEfficient(a, b));
    }
}
