package com.mohadian;

import java.util.Stack;

public class ContainerWithMostWater {
    private static int maxArea(int[] height) {
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        int area = 0;
        int i = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] < height[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = height[top] * i;
                } else {
                    area = height[top] * (i - stack.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = height[top] * i;
            } else {
                area = height[top] * (i - stack.peek() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        System.out.println(maxArea(new int[]{2,1,2,3,1}));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
