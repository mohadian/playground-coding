package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSize {

    private static final int SEA_LEVEL = 0;

    private Object[] findPonds(int[][] land) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == SEA_LEVEL) {
                    list.add(findPondSize(land, i, j));
                }
            }
        }
        return list.toArray();
    }

    private Integer findPondSize(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length) {
            return 0;
        }

        if (land[i][j] != SEA_LEVEL) {
            return 0;
        }


        land[i][j] = -1;
        return 1 + findPondSize(land, i - 1, j - 1) + findPondSize(land, i - 1, j) + findPondSize(land, i - 1, j + 1)
                + findPondSize(land, i, j - 1) + findPondSize(land, i, j + 1)
                + findPondSize(land, i + 1, j - 1) + findPondSize(land, i + 1, j) + findPondSize(land, i + 1, j + 1);
    }

    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};

        PondSize pondSize = new PondSize();


        Object[] ponds = pondSize.findPonds(land);

        System.out.println(Arrays.toString(ponds));
    }
}
