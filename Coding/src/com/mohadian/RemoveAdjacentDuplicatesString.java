package com.mohadian;

import java.util.Stack;

public class RemoveAdjacentDuplicatesString {

    public String removeDuplicatesUsingStack(String s) {
        StringBuffer res = new StringBuffer();
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public String removeDuplicates(String s) {
        boolean couldRemove = true;
        while (couldRemove) {
            if (s.length() > 0) {
                couldRemove = false;
                StringBuffer sb = new StringBuffer();
                char current = s.charAt(0);
                int count = 1;
                for (int i = 1; i < s.length(); i++) {
                    char next = s.charAt(i);
                    if (current == next) {
                        count++;
                        couldRemove = true;
                    } else {
                        if (count % 2 == 1) {
                            sb.append(current);
                        }
                        count = 1;
                        current = next;
                    }
                }
                if (count % 2 == 1 && current == s.charAt(s.length() - 1)) {
                    sb.append(current);
                }
                s = sb.toString();
                sb = new StringBuffer();
            } else {
                couldRemove = false;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        RemoveAdjacentDuplicatesString cls = new RemoveAdjacentDuplicatesString();
        System.out.println(cls.removeDuplicates("aababaab"));
        System.out.println(cls.removeDuplicatesUsingStack("aababaab"));
    }
}
