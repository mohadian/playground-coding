package com.mohadian;

public class Dijestra {

    static void findShortestPath(int n, int[][] e) {

        int source = 0;
        int[] length = new int[n];
        int[] touch = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = e[0][i];
            touch[i] = 0;
        }

        for (int i = 0; i < n - 1; i++) {
            int nearest = Integer.MAX_VALUE;
            int vnear = source;
            for (int j = 1; j < n; j++) {
                if (0 <= length[j] && length[j] < nearest) {
                    vnear = j;
                    nearest = length[j];
                }
            }

            System.out.println("Edge < " + touch[vnear] + " , " + vnear + " >");

            for (int j = 0; j < n; j++) {
                if (e[vnear][j] + length[vnear] > 0 && length[vnear] + e[vnear][j] < length[j]) {
                    length[j] = length[vnear] + e[vnear][j];
                    touch[j] = vnear;
                }
            }
            length[vnear] = -1;
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[5][];

        edges[0] = new int[]{0, 7, 4, 6, 1};
        edges[1] = new int[]{Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        edges[2] = new int[]{Integer.MAX_VALUE, 2, 0, 5, Integer.MAX_VALUE};
        edges[3] = new int[]{Integer.MAX_VALUE, 3, Integer.MAX_VALUE, 0, Integer.MAX_VALUE};
        edges[4] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0};

        findShortestPath(5, edges);
    }
}
