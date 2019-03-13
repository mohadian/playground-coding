package com.mohadian;

import java.util.*;

public class RemoveDuplicates {

    private static Set<Integer> removeDuplicates(int[] arr) {
        Set<Integer> list = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            if(arr[val-1]<0){
                System.out.println("Add " + val + " Because " + arr[val-1]);
                list.add(val);
            } else {
                arr[val-1] *= -1;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,2,1,1};

        Set<Integer> list = removeDuplicates(arr);

        for (int element: arr
        ) {
            System.out.print(" "+element);
        }

        System.out.println(" Duplicates ");
        for (Integer element: list
        ) {
            System.out.print(" "+element);

        }
    }
}
