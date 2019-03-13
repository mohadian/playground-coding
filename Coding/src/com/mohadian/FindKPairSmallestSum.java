package com.mohadian;

import java.util.*;

public class FindKPairSmallestSum {

    private ArrayList<int[]> kSmallestPairs(final int[] nums1, final int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        ArrayList<int[]> res = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(new int[]{nums1[cur[0]], nums2[cur[1]]});
            if (cur[1] == nums2.length - 1) continue; //Dont' add the next index if there is no more left in 2nd array
            pq.offer(new int[]{cur[0], cur[1] + 1});
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 10};
        int k = 3;

        FindKPairSmallestSum search = new FindKPairSmallestSum();

        ArrayList<int[]> list = search.kSmallestPairs(nums1, nums2, k);

        System.out.println(Arrays.toString(list.toArray()));
    }
}
