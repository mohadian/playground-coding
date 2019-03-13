package com.mohadian;

public class PalindromeNumber {

    private static int countDigits(int x) {
        int count = 0;
        while (x > 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int xx = x;
        int yy = x;

        int digits = countDigits(x);

        for (int i = 1; i < digits; i++) {
            int pow = (int) (Math.pow(10, digits - i));
            int high = yy / pow;
            int low = xx % 10;
            if (low != high) return false;
            xx = xx / 10;
            yy = yy % pow;
            System.out.println(high + " " + low + " " + xx + " " + yy);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }
}
