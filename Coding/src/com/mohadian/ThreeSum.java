package com.mohadian;

import java.util.*;

public class ThreeSum {

    private static ArrayList<Integer[]> threeSums(int[] input) {
        ArrayList<Integer[]> result = new ArrayList<>();
        Arrays.sort(input);

        int length = input.length;
        for (int i = 0; i < length - 3; i++) {
            if (i == 0 || input[i] > input[i - 1]) {
                int current = input[i];
                int lower = i + 1;
                int upper = length - 1;
                while (lower <= upper) {
                    int diff = input[upper] + input[lower];
                    if (diff == -1 * current) {
                        System.out.println("" + current + " " + input[lower] + " " + input[upper]);
                        result.add(new Integer[]{current, input[lower], input[upper]});
                        break;
                    } else if (diff < -1 * current) {
                        do {
                            lower++;
                        } while (lower + 1 < length && input[lower] == input[lower + 1]);
                        if (lower == upper) break;
                    } else if (diff > -1 * current) {
                        do {
                            upper--;
                        } while (upper > i && input[upper] == input[upper - 1]);
                        if (upper == lower) break;
                    }
                }
            }
        }

        return result;
    }

    private static Set<Integer[]> findThreeSums(int[] input) {
        Map<Integer, Integer> elements = new HashMap<>();
        int length = input.length;
        Set<Integer[]> result = new HashSet<>();

        Arrays.sort(input);

        for (int i = 0; i < length; i++) {
            elements.put(input[i], i);
        }

        for (int i = 0; i < length; i++) {
            int current = input[i];
            int complement = -1 * current;

            for (int j = i + 1; j < length; j++) {
                int second = input[j];
                if (elements.containsKey(complement - second)) {
                    if (elements.get(complement - second) != j) {
                        System.out.println("" + current + " " + second + " " + (complement - second));
                        result.add(new Integer[]{current, second, (complement - second)});

                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -1};

        Set<Integer[]> result = findThreeSums(input);
        Iterator<Integer[]> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(Arrays.toString(iterator.next()));
        }

        threeSums(input);
    }
}
