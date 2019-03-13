package com.mohadian;

public class SesrchRotatedArray {

    public int findSequential(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public int findBinaryIterative(int[] a, int n) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (a[mid] == n) {
                return mid;
            } else {
                if (a[low] < a[mid]) {
                    if (a[mid] > n) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (a[mid] < n) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SesrchRotatedArray search = new SesrchRotatedArray();
        System.out.println(search.findBinaryIterative(new int[]{15, 16, 19, 21, 23, 24, 5, 7, 10, 14}, 5));
    }
}
