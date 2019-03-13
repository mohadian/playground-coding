package com.mohadian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {

    private static int [][] findClosestToOrigin(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        buildQueue(points, queue);
        int [][] extracted = extractClosest(queue, k);
        return extracted;
    }

    private static int[][] extractClosest(PriorityQueue<int[]> queue, int k) {
        int[][] result = new int[k][2];

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            int[] item = queue.poll();
            result[i] = new int[] {item[1], item[2]};
        }
        return  result;
    }

    private static void buildQueue(int[][] points, PriorityQueue<int[]> queue) {
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int[] npoint = {(x*x) + (y*y), x,y};
            queue.offer(npoint);
        }
    }

    public static void main(String[] args) {
        int [][] points = {};
        int k = 1;

        int [][] closest = findClosestToOrigin(points, k);
    }
}
