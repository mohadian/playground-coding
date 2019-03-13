package com.mohadian;

public class SmallestChange {

    private static int minimumNumberOfCoins(int[] coins, int change, int[] cache) {
        if (change == 0) {
            return 0;
        }
        int min = change;

        for (int coin : coins) {
            if (change - coin >= 0) {
                int cc;
                if (cache[change - coin] > 0) {
                    cc = cache[change - coin];
                } else {
                    cc = minimumNumberOfCoins(coins, change - coin, cache);
                    cache[change - coin] = cc;
                }
                if (min > cc + 1) {
                    min = cc + 1;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int change = 32;
        int[] cache = new int[change];
        int numCoins = minimumNumberOfCoins(coins, change, cache);
        System.out.println(numCoins);
    }
}
