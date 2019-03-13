package com.mohadian;

public class NumberSwapper {

    private static void swap(int a, int b) {
        System.out.println("A " + a + " B " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("A " + a + " B " + b);
    }

    private static void swapBinary(int a, int b) {
        System.out.println("A " + a + " B " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("A " + a + " B " + b);
    }

    public static void main(String[] args) {
        swap(1, 2);
        swapBinary(1, 2);
    }
}
