package com.mohadian;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        String converted = "";

        int index = 6;
        while (num > 0) {
            while (num > 0 && num < nums[index]) {
                index--;
            }
            if (index > -1) {
                if (num / 4 == 1 && num < 5
                ) {
                    converted += (roman[index] + roman[index + 1]);
                    num = num % 4;
                } else if (num / 40 == 1 && num < 50
                ) {
                    converted += (roman[index] + roman[index + 1]);
                    num = num % 40;
                } else if (num / 400 == 1 && num < 500
                ) {
                    converted += (roman[index] + roman[index + 1]);
                    num = num % 400;
                } else if (num / 9 == 1 && num < 10
                ) {
                    converted += (roman[index - 1] + roman[index + 1]);
                    num = num % 9;
                } else if (num / 90 == 1 && num < 100
                ) {
                    converted += (roman[index - 1] + roman[index + 1]);
                    num = num % 90;
                } else if (num / 900 == 1 && num < 1000
                ) {
                    converted += (roman[index - 1] + roman[index + 1]);
                    num = num % 900;
                } else {
                    converted += roman[index];
                    num -= nums[index];
                }
            }
        }
        return converted;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1001)); //"MCMXCIV"
    }
}
