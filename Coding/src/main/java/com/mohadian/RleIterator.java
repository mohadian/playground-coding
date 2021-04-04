package com.mohadian;


/**
 * ["RLEIterator","next","next","next","next"]
 * [[[3,8,0,9,2,5], 2, 1, 1, 2]]
 */

public class RleIterator {
    int[] sequence;
    int index;

    public RleIterator(int[] A) {
        index = 0;
        sequence = A;
    }

    public int next(int n) {
        if (index < sequence.length) {
            sequence[index] -= n;

            if (sequence[index] >= 0) {
                return sequence[index + 1];
            } else {
                int i = index;
                while (i < sequence.length && sequence[i] <= 0) {
                    index = i;
                    i = index + 2;
                    if (i < sequence.length) {
                        sequence[i] += sequence[index];
                    }
                }
                index = i;
            }

            return (index < sequence.length) ? sequence[index + 1] : -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        //RleIterator iterator = new RleIterator(new int[]{3,8,0,9,2,5});
        RleIterator iterator = new RleIterator(new int[]{635, 606, 576, 391, 370, 981, 36, 21, 961, 185, 124, 210, 801, 937, 22, 426, 101, 260, 221, 647, 350, 180, 504, 39, 101, 989, 199, 358, 732, 839, 919, 169, 673, 967, 58, 676, 846, 342, 250, 597, 442, 174, 472, 410, 569, 509, 311, 357, 838, 251});
        int[] next = {5039, 62, 3640, 671, 67, 395, 262, 839, 74, 43, 42, 77, 13, 6, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 0; i < next.length; i++) {
            System.out.println(iterator.next(next[i]));
        }
    }

}
