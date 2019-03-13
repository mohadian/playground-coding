package com.mohadian;

public class GenericSort {

    public static void insertionSory(Comparable[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i].compareTo(list[j]) < 0) {
                    exchange(list, i, j);
                }
            }
        }
    }

    private static void exchange(Comparable[] list, int a, int b) {
        Comparable c = list[a];
        list[a] = list[b];
        list[b] = c;
    }
}
