package com.mohadian;

import java.util.*;

public class CountTriplets {

    private static long countTriplets(List<Long> arr, long r) {
        long count = 0;

        int len = arr.size();
        Long[] list = new Long[len];
        for (int i = 0; i < len; i++) {
            list[i] = arr.get(i);
        }
        Arrays.sort(list);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (list[i] * r == list[j]) {
                    int search = Arrays.binarySearch(list, j - 1, len, list[j] * r);

                    if (search >= 0) {
                        int k = search;
                        while (k < len && list[search].equals(list[k])) {
                            count++;
                            k++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Long> list = new LinkedList<>();
        list.add(1L);
        list.add(3L);
        list.add(9L);
        list.add(9L);
        list.add(27L);
        list.add(81L);//1 3 9 9 27 81

        System.out.println(countTriplets(list, 3));
    }
}
