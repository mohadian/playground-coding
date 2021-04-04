package com.mohadian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCode {
    public class HuffmanNode {
        char ch;
        int frequency;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }
    }

    public class HuffmanComparator implements Comparator<HuffmanNode> {
        @Override
        public int compare(HuffmanNode o1, HuffmanNode o2) {
            return o1.frequency - o2.frequency;
        }
    }

    public HuffmanNode calculateHuffmanTree(char[] chars, int[] frequencies) {
        HuffmanNode root = null;
        int len = chars.length;

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new HuffmanComparator());

        for (int i = 0; i < len; i++) {
            queue.add(new HuffmanNode(chars[i], frequencies[i]));
        }

        while (queue.size() > 1) {
            HuffmanNode n1 = queue.poll();
            HuffmanNode n2 = queue.poll();
            HuffmanNode node = new HuffmanNode('-', n1.frequency + n2.frequency);
            node.left = n1;
            node.right = n2;
            queue.add(node);
            root = node;
        }

        return root;
    }

    public void printCode(String code, HuffmanNode root) {

        if (root.ch == '-') {
            printCode(code + "0", root.left);
            printCode(code + "1", root.right);
        } else {
            System.out.println(code);
        }
    }

    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};

        HuffmanCode huffmanCode = new HuffmanCode();
        HuffmanNode root = huffmanCode.calculateHuffmanTree(charArray, charfreq);
        huffmanCode.printCode("", root);
    }
}
