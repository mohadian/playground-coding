package com.mohadian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergingCommunities {
    private static class Query {
        String type;
        int arg1;
        int arg2;

        Query(String line) {
            if (line != null && line.length() > 0) {
                String[] nk = line.split(" ");

                type = nk[0];
                arg1 = Integer.parseInt(nk[1]);
                if (type.equals("M")) {
                    arg2 = Integer.parseInt(nk[2]);
                }
            }
        }
    }

    private static void processQueries(int n, Query[] queries) {
        int[] parents = new int[n + 1];
        long[] sizes = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }

        for (int i = 0; i < queries.length; i++) {
            Query query = queries[i];
            if (query.type.equals("M")) {
                int leftParent = findParent(query.arg1, parents);
                int rightParent = findParent(query.arg2, parents);

                if (leftParent != rightParent) {
                    if (sizes[leftParent] > sizes[rightParent]) {
                        parents[rightParent] = leftParent;
                        sizes[leftParent] += sizes[rightParent];
                    } else {
                        parents[leftParent] = rightParent;
                        sizes[rightParent] += sizes[leftParent];
                    }
                }
            } else {
                int parent = findParent(query.arg1, parents);
                System.out.println(sizes[parent]);
            }
        }
    }

    private static int findParent(int source, int[] parents) {
        int parent = source;
        while (parents[parent] != parent) {
            parent = parents[parent];
        }
        return parent;
    }

    public static void main(String[] args) {
        File file = new File("input.txt");

        Scanner scanner;
        try {
            scanner = new Scanner(file);

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int q = Integer.parseInt(nk[1]);

            Query[] queries = new Query[q];
            for (int i = 0; i < q; i++) {
                String line = scanner.nextLine();
                queries[i] = new Query(line);
            }

            processQueries(n, queries);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
