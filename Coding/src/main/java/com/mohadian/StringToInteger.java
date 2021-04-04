package com.mohadian;

public class StringToInteger {
    public static int myAtoi(String str) {
        long num = 0;
        boolean sign = true;
        boolean readNumber = false;
        boolean readSign = false;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-' || ch == '+') {
                if (!readSign) {
                    sign = (ch == '+');
                    readSign = true;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else if (ch >= '0' && ch <= '9') {
                readNumber = true;
                if (num * 10 + (ch - '0') > Integer.MAX_VALUE) {
                    return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    num = (num * 10 + (ch - '0')) * (sign ? 1 : -1);
                }
            } else {
                break;
            }
        }
        if (readNumber) {
            return (int) num * (sign ? 1 : -1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-912832"));
    }
}
