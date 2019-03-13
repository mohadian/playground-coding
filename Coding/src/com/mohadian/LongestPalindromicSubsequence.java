package com.mohadian;

import java.util.Arrays;

/**
 * Given a string find longest palindromic subsequence in this string.
 */
public class LongestPalindromicSubsequence {

    private static int calculateLongest(String input) {
        int len = input.length();

        int[][] m = new int[len][len];

        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                if (l == 0) {
                    m[i][i + l] = 1;
                } else {
                    if (input.charAt(i) == input.charAt(i + l)) {
                        m[i][i + l] = 2 + m[i - 1][i + l - 1];
                    } else {
                        m[i][i + l] = Math.max(m[i][i + l - 1], m[i + 1][i + l]);
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(m[i]));
        }

        return m[0][len - 1];
    }

    public static void main(String[] args) {

        String input = "agbdba";

        int maxLen = calculateLongest(input);

        System.out.println(maxLen);

    }
}
