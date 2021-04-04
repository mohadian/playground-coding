package com.mohadian;

import java.util.ArrayList;

public class SpecialPalindromeAgain {
    // Complete the substrCount function below.
    static long substrCount(String s) {
        ArrayList<Character> chars = new ArrayList();
        ArrayList<Integer> counts = new ArrayList();
        Character current = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != current) {
                chars.add(current);
                counts.add(count);
                current = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        chars.add(current);
        counts.add(count);

        long total = 0;
        if (counts.size() > 0) {
            total += ((counts.get(0) * (counts.get(0) + 1)) / 2);
        }
        if (counts.size() > 1) {
            int len = counts.size();
            total += ((counts.get(len - 1) * (counts.get(len - 1) + 1)) / 2);
        }

        for (int i = 1; i < chars.size() - 1; i++) {
            total += ((counts.get(i) * (counts.get(i) + 1)) / 2);
            if (chars.get(i - 1) == chars.get(i + 1)) {
                total += Math.min(counts.get(i - 1), counts.get(i + 1));
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String input = "aaaaba";

        System.out.println(substrCount(input));

    }
}
