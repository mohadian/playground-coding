package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;

public class StringPermutations {

    private static ArrayList<String> permutations(String input) {
        ArrayList<String> result = new ArrayList<>();
        permutations("", input, result);
        return result;
    }

    private static void permutations(String prefix, String suffix, ArrayList<String> result) {
        if (suffix.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                permutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1), result);
            }
        }
    }

    private static ArrayList<int[]> permutations(int[] input) {
        ArrayList<int[]> result = new ArrayList<>();
        permutations(input, 0, result);
        return result;
    }

    private static void permutations(int[] a, int start, ArrayList<int[]> result) {
        if (start >= a.length) {
            result.add(a.clone());
        } else {
            for (int i = start; i < a.length; i++) {
                mswap(a, start, i);
                permutations(a, start + 1, result);
                mswap(a, start, i);
            }
        }
    }

    private static void mswap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void main(String[] args) {

        String input = "abc";

        ArrayList<String> result = permutations(input);

        for (String item : result) {
            System.out.println(item);
        }

        int[] array = {1, 2, 3};

        ArrayList<int[]> res = permutations(array);

        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }
}
