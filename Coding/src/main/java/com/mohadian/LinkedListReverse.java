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

    private static Node reverseIterative(Node root) {
        Node pre = null;
        Node current = root;
        Node next = current.next;

        while(next != null){
            current.next = pre;
            pre = current;
            current = next;
            next = current.next;
        }

        current.next = pre;
        return current;
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
        Node head = reverseIterative(root);
        printList(head);
        head = reverseRec(head);
        printList(head);
    }
}
