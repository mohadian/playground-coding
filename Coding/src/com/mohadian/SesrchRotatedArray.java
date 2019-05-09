package com.mohadian;

public class SesrchRotatedArray {

    public int findBinaryRecursive(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target <= nums[mid]) {
                return findBinaryRecursive(nums, target, low, mid - 1);
            } else {
                return findBinaryRecursive(nums, target, mid + 1, high);
            }
        } else {
            if (target >= nums[mid] && target <= nums[high]) {
                return findBinaryRecursive(nums, target, mid + 1, high);
            } else {
                return findBinaryRecursive(nums, target, low, mid - 1);
            }
        }

    }

    int findBinaryIterative(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                return mid;
            } else {
                if (nums[low] <= nums[mid]) {
                    if (target >= nums[low] && target <= nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (target >= nums[mid] && target <= nums[high]) {
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
        System.out.println(search.findBinaryIterative(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(search.findBinaryRecursive(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8, 0, 8));
    }
}
