package com.mohadian;

import java.util.Arrays;

public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int alen = a.length;
        int blen = b.length;
        int clen = c.length;
        int[] less = new int[blen];
        int[] more = new int[blen];
        long count = 0;

        for (int i = 0; i < blen; i++) {
            if (i < blen - 1 && b[i] == b[i + 1]) {
                continue;
            }
            int ainx = Arrays.binarySearch(a, b[i]);
            //System.out.println(ainx);

            if (ainx >= 0 && a[ainx] == b[i]) {
                while (ainx < alen - 1 && a[ainx] == a[ainx + 1]) {
                    ainx++;
                }
                less[i] = ainx + 1;
            } else {
                less[i] = -1 * ainx - 1;
            }

            int cinx = Arrays.binarySearch(c, b[i]);
            //System.out.println(cinx);
            if (cinx >= 0 && c[cinx] == b[i]) {
                while (cinx < clen - 1 && c[cinx] == c[cinx + 1]) {
                    cinx++;
                }
                more[i] = cinx + 1;
            } else {
                more[i] = -1 * cinx - 1;
            }
            //System.out.println("L " + less[i]);
            //System.out.println("M " +more[i]);

            count += (long) less[i] * (long) more[i];
        }
        //System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5};
        int[] b = new int[]{2, 3};
        int[] c = new int[]{1, 2, 3};

        System.out.println(triplets(a, b, c));
    }
}
