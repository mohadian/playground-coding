package com.mohadian;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    class Item {
        int value;
        int parent;
        int count;

        public Item(int value) {
            this.value = value;
            this.parent = value;
            count = 1;
        }
    }

    Map<Integer, Item> items = new HashMap<>();

    Item find(int item) {
        if (items.get(item) == null){
            return new Item(item);
        }
        if (items.get(item).parent == item) {
            return items.get(item);
        } else {
            return find(items.get(item).parent);
        }
    }

    public int merge(int left, int right) {
        Item leftParent = find(left);
        Item rightParent = find(right);

        rightParent.parent = leftParent.parent;
        leftParent.count += rightParent.count;

        return leftParent.count;
    }

    static int[] maxCircle(int[][] queries) {
        int len = queries[0].length;
        int [] circles = new int[len];
        int lmax = 0;

        DisjointSet set = new DisjointSet();

        for (int i = 0; i < len; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int merged = set.merge(left, right);
            lmax = Math.max(merged, lmax);
            circles[i] = lmax;
        }

        return circles;
    }

    public static void main(String[] args) {
    }
}
