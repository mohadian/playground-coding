package com.mohadian;

public class LinkedListReverse {

    private static class Node {
        int data;
        LinkedListReverse.Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node reverseRec(Node root) {
        if (root.next == null) {
            return root;
        }

        Node next = reverseRec(root.next);
        root.next.next = root;
        root.next = null;
        return next;

    }

    private static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " -> ");
            root = root.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);

        printList(root);
        Node head = reverseRec(root);

        printList(head);
    }
}
