package com.mohadian;

import java.util.ArrayList;

public class Kaprekar {

    static int rightOf(long num, int digits){
        return (int) (num % ((int) Math.pow(10, digits)));
    }

    static int leftOf(long num, int digits){
        return (int) (num / ((int) Math.pow(10, digits)));
    }

    static int countDigits(long num){
        int d = 1;
        int count = 1;
        while(10*d<=num){
            d*=10;
            count++;
        }
        return count;
    }

    // Complete the kaprekarNumbers function below.
    static int[] kaprekarNumbers(int p, int q) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (long i=p; i<q; i++){
            System.out.println(77778L * 77778L);
            long sqr = i*i;
            int digits = countDigits(i);
            int right = rightOf(sqr, digits);
            int left = leftOf(sqr, digits);
            System.out.println(String.format("%d, %d, %d, %d, %d", i, sqr, digits, left, right));
            if(left+right == i){
                list.add((int)i);
            }
        }

        int[] array = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] result = kaprekarNumbers(77776,77779);
        if(result.length == 0){
            System.out.println("INVALID RANGE");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.print(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
