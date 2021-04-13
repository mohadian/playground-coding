package com.mohadian;
// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//      1            <---  1
//    /   \
//   2     3         <---  3
//    \
//    5              <---  5

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class PrintRightView {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static List<Integer> printRightView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        LinkedList<Node> parents = new LinkedList<>();
        LinkedList<Node> children = new LinkedList<>();

        parents.add(root);
        list.add(root.value);

        while (!parents.isEmpty()) {
            Node node = parents.remove();
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }

            if (parents.isEmpty() && !children.isEmpty()) {
                list.add(children.get(children.size() - 1).value);
                parents.addAll(children);
                children.clear();
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);

        List<Integer> print = printRightView(root);
        System.out.println(Arrays.toString(print.toArray()));
    }
}