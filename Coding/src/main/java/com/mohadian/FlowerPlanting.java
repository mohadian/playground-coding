package com.mohadian;

import java.util.*;

public class FlowerPlanting {

    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }
        int[] ans = new int[N];
        for (int i = 1; i <= N; i++) {
            Set<Integer> neiColor = new HashSet<>();
            for (int nei : map.get(i)) {
                neiColor.add(ans[nei - 1]);
            }
            for (int color = 1; color <= 4; color++) {
                if (!neiColor.contains(color)) {
                    ans[i - 1] = color;
                }
            }
        }
        return ans;
    }

    public int[] gardenNoAdjRecursive(int N, int[][] paths) {
        int[] flowers = new int[N];
        plantFlower(paths, N, 1, 1, flowers);
        return flowers;
    }

    private void plantFlower(int [][] paths, int N, int flower, int garden, int[] flowers) {
        if(garden > N) {
            return ;
        }

        if(isFlowerPossible(paths, garden, flower, flowers)) {
            flowers[garden-1] = flower;
            plantFlower(paths, N,  1, garden+1, flowers);
        } else {
            flowers[garden-1] = 0;
            plantFlower(paths, N,  (flower+1) % 4, garden, flowers);
        }
    }

    private boolean isFlowerPossible(int [][] paths, int garden, int flower, int[] flowers) {
        for(int i=0; i<paths.length; i++){
            if(paths[i][0] == garden){
                if(flowers[paths[i][1]-1] == flower) return false;
            }
            if(paths[i][1] == garden){
                if(flowers[paths[i][0]-1] == flower) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        FlowerPlanting flowerPlanting = new FlowerPlanting();

        int [] flowers = flowerPlanting.gardenNoAdj(4, new int[][]{{1,2},{3,4}});

        System.out.println(Arrays.toString(flowers));

    }
}
