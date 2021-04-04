package com.mohadian;

import java.util.Stack;

public class LargestRectangleInHistogram {

    private static int calculateLargestArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        while (i < hist.length) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i);
                i++;
            } else {
                int anchorPoint = stack.pop();
                int area = hist[anchorPoint] * ((stack.isEmpty()) ? (i - 1) : (i - stack.peek() - 1));
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            int anchorPoint = stack.pop();
            int area = hist[anchorPoint] * ((stack.isEmpty()) ? (i - 1) : (i - stack.peek() - 1));
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] hist = new int[]{1, 2, 3, 4, 5, 3, 3, 2};

        int maxArea = calculateLargestArea(hist);

        System.out.println(maxArea);
    }
}
