package com.mohadian;

import java.util.Stack;

public class PalindromLinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static boolean isPalindrom(Node root) {
        Stack<Node> toCheck = new Stack<>();

        Node runner = root.next;
        Node slower = root;
        while (runner != null) {
            toCheck.push(slower);
            if (runner.next == null) {
                slower = slower.next;//skip the middle one
                break;
            }
            slower = slower.next;
            runner = runner.next.next;
        }

        if (runner == null) {
            slower = slower.next;
        }

        while (!toCheck.isEmpty()) {
            Node st = toCheck.pop();
            System.out.println(st.data + " - " + slower.data);
            if (st.data != slower.data) return false;
            slower = slower.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(2);
        root.next.next.next.next = new Node(1);

        System.out.println(isPalindrom(root));
    }
}
