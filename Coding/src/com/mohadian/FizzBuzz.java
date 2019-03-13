package com.mohadian;

public class FizzBuzz {

    private static void printFizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String out = ""+i;
            if (i%3==0){
                out = "Fizz";
            }
            if (i%5==0){
                out = (out.startsWith("F"))? out+"Buzz": "Buzz";
            }
            System.out.println(out);
        }
    }

    public static void main(String[] args) {
        printFizzBuzz(16);
    }
}
