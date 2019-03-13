package com.mohadian;

public class DecodeNumWaysCounter {

    private static String[] codes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};
    private static String[] clear = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private static boolean validCode(String str) {
        for (String code : codes) {
            if (code.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static int numWays(String str, int n) {
        if (str.length() == n) {
            return validCode(str) ? 1 : 0;
        } else {
            for (int i = n; i < str.length(); i++) {
                String sub = str.substring(0, i);
                if (validCode(sub)) {
                    return 1 + numWays(str.substring(i), 1);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(numWays("4144", 1));
    }
}
