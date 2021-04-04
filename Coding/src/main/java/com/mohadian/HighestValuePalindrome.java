package com.mohadian;

public class HighestValuePalindrome {

    private static String calculateHighestPalindrom(String number, int n, int change) {
        char[] num = number.toCharArray();
        int minChange = calculateMinChange(num);
        if (minChange > change) {
            return "-1";
        }

        int hafl = n / 2;

        for (int i = 0; i < hafl; i++) {
            if (num[i] != num[n - i - 1]) {
                int max = Math.max(num[i], num[n - i - 1]);
                num[i] = (char) max;
                num[n - i - 1] = (char) max;
                change--;
            }
        }

        while (change > 0) {
            if (change - 2 >= 0) {
                boolean found = false;
                for (int i = 0; i < hafl && change > 0; i++) {
                    if (num[i] != '9') {
                        if (number.charAt(i) != number.charAt(n - i - 1)) {
                            num[i] = '9';
                            num[n - i - 1] = '9';
                            change -= 1;
                            found = true;
                        } else {
                            num[i] = '9';
                            num[n - i - 1] = '9';
                            change -= 2;
                            found = true;
                        }
                    }
                }
                if (!found) {
                    break;
                }
            } else if (change == 1) {
                boolean found = false;
                for (int i = 0; i < hafl && change > 0; i++) {
                    if (num[i] != '9' && number.charAt(i) != number.charAt(n - i - 1)) {
                        num[i] = '9';
                        num[n - i - 1] = '9';
                        change -= 1;
                        found = true;
                    }
                }
                if (!found) {
                    break;
                }
            } else {
                break;
            }
        }
        if (change > 0) {
            if (n % 2 > 0 && num[n / 2] != '9') {
                num[n / 2] = '9';
            }
        }
        return new String(num);
    }

    private static int calculateMinChange(char[] number) {
        int len = number.length;
        int hafl = len / 2;
        int count = 0;

        for (int i = 0; i < hafl; i++) {
            if (number[i] != number[len - i - 1]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 5;
        int change = 5;
        String number = "35243";

        String palindrome = calculateHighestPalindrom(number, n, change);

        System.out.println(palindrome);
    }
}
