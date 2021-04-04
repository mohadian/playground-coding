package com.mohadian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    public enum QueryType {
        PUSH, DELETE, PRINT_MAX, UNKNOWN
    }

    public static class Query {
        QueryType type;
        int arg;

        public Query(String raw) {
            String[] tokens = raw.split(" ");
            type = getType(tokens);
            arg = getArgs(tokens);
        }

        QueryType getType(String[] tokens) {
            if (tokens.length > 0) {
                if (tokens[0].equals("1")) {
                    return QueryType.PUSH;
                }
                if (tokens[0].equals("2")) {
                    return QueryType.DELETE;
                }
                if (tokens[0].equals("3")) {
                    return QueryType.PRINT_MAX;
                }
            }
            return QueryType.UNKNOWN;
        }

        int getArgs(String[] tokens) {
            if (tokens.length > 1) {
                return Integer.valueOf(tokens[1]);
            }
            return 0;
        }
    }

    public static void executeQueries(Query[] queries) {
        Stack<Integer> max = new Stack();
        Stack<Integer> vals = new Stack();
        for (Query query : queries) {
            if (query.type == QueryType.PUSH) {
                vals.push(query.arg);
                if (max.isEmpty() || query.arg > max.peek()) {
                    max.push(query.arg);
                }
            }
            if (query.type == QueryType.DELETE) {
                int val = vals.pop();
                if (max.peek() == val) {
                    max.pop();
                }
            }
            if (query.type == QueryType.PRINT_MAX) {
                System.out.println(max.peek());
            }
        }
    }


    public static void main(String[] args) {
        File file = new File("input.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);

            int query_count = scanner.nextInt();
            scanner.nextLine();
            Query[] queries = new Query[query_count];
            for (int i = 0; i < query_count; i++) {
                String line = scanner.nextLine();
                queries[i] = new Query(line);
            }

            executeQueries(queries);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
