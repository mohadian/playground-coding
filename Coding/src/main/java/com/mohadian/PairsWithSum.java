package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithSum {

    class Pair {
        int first, second;

        public Pair() {
        }

        @Override
        public String toString() {
            return "<" + first + "," + second + ">";
        }
    }

    private List<Pair> findAllBF(int[] array, int sum) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] + first == sum) {
                    Pair pair = new Pair();
                    pair.first = first;
                    pair.second = array[j];
                    list.add(pair);
                }
            }
        }
        return list;
    }

    private List<Pair> findAllSinglePass(int[] array, int sum) {
        List<Pair> list = new ArrayList<>();

        Arrays.sort(array);

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            if (array[start] + array[end] == sum) {
                Pair pair = new Pair();
                pair.first = array[start];
                pair.second = array[end];
                list.add(pair);
                end--;
            } else if (array[start] + array[end] > sum) {
                end--;
            } else {
                start++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] array = {-2, -1, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};
        int sum = 5;

        PairsWithSum pairs = new PairsWithSum();

        System.out.println(Arrays.toString(pairs.findAllBF(array, sum).toArray()));
        System.out.println(Arrays.toString(pairs.findAllSinglePass(array, sum).toArray()));
    }
}
