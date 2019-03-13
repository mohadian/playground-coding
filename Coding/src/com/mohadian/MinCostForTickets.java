package com.mohadian;

import java.util.Arrays;

public class MinCostForTickets {

    public static void main(String[] args) {
        int maxDay = 0;
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};

        maxDay = days[days.length - 1];

        int[] wholePerios = new int[maxDay + 1];

        int d = 0;
        for (int i = 1; i < wholePerios.length; i++) {
            if (d < days.length && days[d] == i) {
                int cost = wholePerios[i - 1] + costs[0]; // day ticket
                // Check 7 days
                int i7 = Math.max(0, i - 7);
                int cost7 = wholePerios[i7] + costs[1];
                if (cost > cost7) {
                    cost = cost7;
                    for (int j = i7; j < i; j++) {
                        wholePerios[j] = cost;
                    }
                }
                // Check 30 days
                int i30 = Math.max(0, i - 30);
                int cost30 = wholePerios[i30] + costs[2];
                if (cost > cost30) {
                    cost = cost30;
                    for (int j = i30; j < i; j++) {
                        wholePerios[j] = cost;
                    }
                }

                wholePerios[i] = cost;
                d++;
            } else {
                wholePerios[i] = wholePerios[i - 1];
            }
        }
        System.out.println(Arrays.toString(wholePerios));
        System.out.println(wholePerios[wholePerios.length - 1]);
    }
}
