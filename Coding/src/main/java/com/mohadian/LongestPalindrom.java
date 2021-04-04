package com.mohadian;

public class LongestPalindrom {

    static String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;

        String result = "";
        int maxLength = 0;
        int curLength = 0;

        for (int i = 0; i < s.length(); i++) {

            int x = i - 1;
            int y = i + 1;
            curLength = 1;
            while (x >= 0 && y < len && chs[x] == chs[y]) {
                x--;
                y++;
                curLength += 2;
            }
            if (maxLength < curLength) {
                x = (x < 0) ? 0 : x + 1;
                y = (y > len) ? len - 1 : y;
                result = s.substring(x, y);
                maxLength = curLength;
            }

            x = i;
            y = i + 1;
            curLength = 0;
            while (x >= 0 && y < len && chs[x] == chs[y]) {
                x--;
                y++;
                curLength += 2;
            }
            if (maxLength < curLength) {
                x = (x < 0) ? 0 : x + 1;
                y = (y > len) ? len - 1 : y;
                result = s.substring(x, y);
                maxLength = curLength;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String result = longestPalindrome("a");
        System.out.println(result);
    }
}
