package com.mohadian;

public class LonelyInteger {

    public static void main(String[] args) {
        int[] list = {9, 1, 2, 3, 2, 1, 9};

        int lonely = findLonelyInteger(list);
        System.out.println(lonely);
    }

    private static int findLonelyInteger(int[] list) {
        int num = 0;
        for (int i = 0; i < list.length; i++) {
            num ^= list[i];
        }
        return num;
    }
}
