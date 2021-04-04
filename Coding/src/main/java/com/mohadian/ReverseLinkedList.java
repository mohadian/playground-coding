package com.mohadian;

import java.util.LinkedList;

public class ReverseLinkedList {

    private static void printList(LinkedList<Integer> list) {
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    private static void printReversedRecursive(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("Empty List");
            return;
        }

        Integer data = list.remove();
        printReversedRecursive(list);
        System.out.println(data);
    }

    private static void printReversedNonRecursive(LinkedList<Integer> list) {
        System.out.println("Non recursive");

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        printList(list);

        printReversedNonRecursive(list);
        printReversedRecursive(list);
    }
}
