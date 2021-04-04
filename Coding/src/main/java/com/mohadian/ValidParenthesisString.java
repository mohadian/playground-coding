package com.mohadian;

import java.util.Stack;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public boolean checkValidStringRecursive(String s) {
        Stack<String> stack = new Stack();

        return checkerRecursive(s, 0, stack);
    }

    private boolean checkerRecursive(String s, int index, Stack<String> stack) {
        if (index == s.length()) {
            return (stack.isEmpty());
        }
        if (s.charAt(index) == '(') {
            stack.push("(");
            return checkerRecursive(s, index + 1, stack);
        } else if (s.charAt(index) == '*') {
            Stack<String> temp = new Stack<>();
            temp.addAll(stack);
            boolean ignore = checkerRecursive(s, index + 1, stack);

            if (!ignore) {
                stack.clear();
                stack.addAll(temp);

                stack.push("(");
                boolean open = checkerRecursive(s, index + 1, stack);
                if (!open) {
                    stack.clear();
                    stack.addAll(temp);
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                    return checkerRecursive(s, index + 1, stack);
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
            return checkerRecursive(s, index + 1, stack);
        }
    }

    public static void main(String[] args) {
        ValidParenthesisString checker = new ValidParenthesisString();

        System.out.println(checker.checkValidStringRecursive("((*())"));
    }
}


