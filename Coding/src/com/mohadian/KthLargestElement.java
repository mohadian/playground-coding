package com.mohadian;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargestElement(int[] list, int k){

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < list.length; i++) {
            if(heap.size() < k+1){
                heap.add(list[i]);
            } else {
                if(heap.peek() < list[i]){
                    heap.add(list[i]);
                    heap.remove();
                }
            }
        }

        return heap.remove();
    }


    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargestElement(new int[]{5,3,9,1}, 3));
    }
}
