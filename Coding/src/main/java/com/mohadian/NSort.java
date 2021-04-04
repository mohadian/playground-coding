package com.mohadian;

import java.util.Arrays;

public class NSort {

    private void mySort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i];
                int j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3};
        NSort nSort = new NSort();
        nSort.mySort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
