package com.mohadian;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStack {

    private static Stack<Integer> reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        Integer item = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, item);
        return stack;
    }

    private static void insertAtBottom(Stack<Integer> stack, Integer x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            Integer item = stack.pop();
            insertAtBottom(stack, x);
            stack.push(item);
        }
    }

    private static void printStack(Stack<Integer> stack) {
        System.out.println(Arrays.toString(stack.toArray()));
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        printStack(stack);
        printStack(reverseStack(stack));
    }
}
