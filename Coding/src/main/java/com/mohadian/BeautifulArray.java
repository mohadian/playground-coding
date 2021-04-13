package com.mohadian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {

    private int[] beautifulArray(int num) {
        return calculateBeautifulArray(num, new HashMap<>());
    }

    private int[] calculateBeautifulArray(int N, Map<Integer, int[]> memo) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x: calculateBeautifulArray((N+1)/2, memo))  // odds
                ans[t++] = 2*x - 1;
            for (int x: calculateBeautifulArray(N/2, memo))  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }

    public static void main(String[] args) {
        BeautifulArray beautifulArray = new BeautifulArray();

        System.out.println(Arrays.toString(beautifulArray.beautifulArray(5)));
        System.out.println(Arrays.toString(beautifulArray.beautifulArray(10)));
    }
}
