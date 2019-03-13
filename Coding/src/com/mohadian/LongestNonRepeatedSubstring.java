package com.mohadian;

public class LongestNonRepeatedSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = s.indexOf(ch, start);
            if (index < i) {
                start = (index + 1 < s.length()) ? index + 1 : s.length();
                end++;
            } else {
                end++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("abcabc!bb");
        System.out.println(len);
    }
}
