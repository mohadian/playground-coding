package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationSequence {

    private static void printPermutations(int n, int k) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }

        ArrayList<String> list = new ArrayList<>();
        generatePermutations(s.toString(), "", k, list);
        list.get(k);
        generatePermutationsIterative(3);
    }

    private static void generatePermutationsIterative(int n) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();

        list.add("");

        for (int i = 1; i <= n; i++) {
            for (String item : list) {
                if (item.length() == 0) {
                    temp.add("" + i);
                }
                for (int j = 0; j <= item.length(); j++) {
                    temp.add(item.substring(0, j) + i + item.substring(j));
                }
            }
            list.addAll(temp);
            temp.clear();
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void generatePermutations(String str, String chosen, int k, ArrayList<String> list) {
        if (str.length() == 0) {
            list.add(chosen);
        }

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(0, i) + str.substring(i + 1);
            char ch = str.charAt(i);
            generatePermutations(s, chosen + ch, k - 1, list);
        }
    }

    public static void main(String[] args) {
        printPermutations(3, 3);
    }
}
