package com.mohadian;

import java.util.*;

public class DivingBoard {

    public DivingBoard() {
    }

    private Set<Integer> generateAllLengthRecursive(int sLen, int lLen, int k) {
        Set<Integer> set = new HashSet<>();
        Set<String> memo = new HashSet<>();
        generateAllLengthRecursive(sLen, lLen, k, 0, set);
        generateAllLengthRecursive(sLen, lLen, k, 0, set, memo);
        return set;
    }

    private void generateAllLengthRecursive(int sLen, int lLen, int k, int total, Set<Integer> set) {
        if (k == 0) {
            set.add(total);
            return;
        }
        generateAllLengthRecursive(sLen, lLen, k - 1, total + sLen, set);
        generateAllLengthRecursive(sLen, lLen, k - 1, total + lLen, set);
    }

    private void generateAllLengthRecursive(int sLen, int lLen, int k, int total, Set<Integer> set, Set<String> memo) {
        if (k == 0) {
            set.add(total);
            return;
        }
        String key = total + "_" + k;
        if (memo.contains(key)) {
            return;
        }
        generateAllLengthRecursive(sLen, lLen, k - 1, total + sLen, set);
        generateAllLengthRecursive(sLen, lLen, k - 1, total + lLen, set);
        memo.add(key);
    }

    private void generateAllLengthOptimal(int sLen, int lLen, int k, Set<Integer> set){

        int nShort;
        int nLong;
        int totalLen;
        for (int i = 0; i <= k; i++) {
            nShort=i;
            nLong = k-i;
            totalLen = nShort*sLen + nLong *lLen;
            set.add(totalLen);
        }
    }

    public static void main(String[] args) {
        int sLen = 2;
        int lLen = 3;
        int k = 10;

        Set<Integer> set = new HashSet<>();

        DivingBoard divingBoard = new DivingBoard();

        // set = divingBoard.generateAllLengthRecursive(sLen, lLen, k);
        divingBoard.generateAllLengthOptimal(sLen, lLen, k, set);

        System.out.println(Arrays.toString(set.toArray()));
    }
}
