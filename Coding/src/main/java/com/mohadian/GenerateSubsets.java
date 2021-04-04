package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateSubsets {

    private static void printSubsets(ArrayList<ArrayList<Integer>> allSubsets) {
        for (ArrayList<Integer> set : allSubsets) {
            System.out.println(Arrays.toString(set.toArray()));
        }
    }

    private static ArrayList<ArrayList<Integer>> allSubsetsIterative(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());

        for (Integer item : set) {
            ArrayList<ArrayList<Integer>> with = new ArrayList<>();
            for (ArrayList<Integer> current : allSubsets) {
                ArrayList<Integer> nset = new ArrayList<>(current);
                nset.add(item);
                with.add(nset);
            }
            allSubsets.addAll(with);
        }

        return allSubsets;
    }

    private static ArrayList<ArrayList<Integer>> allSubsetsRec(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = allSubsetsRec(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();

            for (ArrayList<Integer> current : allSubsets) {
                ArrayList<Integer> nset = new ArrayList<>(current);
                nset.add(item);
                moreSubsets.add(nset);
            }
            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }

    private static ArrayList<ArrayList<Integer>> allSubsetsCombinatorics(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int len = set.size();

        int max = 1 << len;

        for (int i = 0; i < max; i++) {
            ArrayList<Integer> subset = convertToSet(set, i);
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    private static ArrayList<Integer> convertToSet(ArrayList<Integer> set, int n) {
        ArrayList<Integer> subset = new ArrayList<>();

        int i = 0;
        while (n > 0) {
            boolean isIncluded = ((n & 1) == 1);
            if (isIncluded) {
                subset.add(set.get(i));
            }
            i++;
            n = n >> 1;
        }

        return subset;
    }

    public static void main(String[] args) {
        int n = 3;

        ArrayList<Integer> set = new ArrayList<>();
        set.add(-1);
        set.add(2);
        set.add(4);

        ArrayList<ArrayList<Integer>> allSubsets;

        allSubsets = allSubsetsIterative(set);
        allSubsets = allSubsetsRec(set, 0);
        allSubsets = allSubsetsCombinatorics(set);

        printSubsets(allSubsets);
    }
}
