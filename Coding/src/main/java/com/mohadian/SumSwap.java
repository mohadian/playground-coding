package com.mohadian;

import java.util.Arrays;
import java.util.HashSet;

public class SumSwap {

    private int sum(int[] a) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res += a[i];
        }

        return res;
    }

    private int[] sumSwapBF(int[] a1, int[] a2) {
        int s1 = sum(a1);
        int s2 = sum(a2);

        int diff = (s1 - s2) / 2;

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] - a2[j] == diff) {
                    return new int[]{a1[i], a2[j]};
                }
            }
        }
        return new int[]{};
    }

    private int[] sumSwap(int[] a1, int[] a2) {
        int s1 = sum(a1);
        int s2 = sum(a2);

        int diff = (s1 - s2) / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a2.length; i++) {
            set.add(a2[i]);
        }

        for (int i = 0; i < a1.length; i++) {
            if (set.contains(a1[i] - diff)) {
                return new int[]{a1[i], a1[i] - diff};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] a1 = {4, 1, 2, 1, 1, 2};
        int[] a2 = {3, 6, 3, 3};

        SumSwap sumSwap = new SumSwap();

        System.out.println(Arrays.toString(sumSwap.sumSwap(a1, a2)));
    }
}
