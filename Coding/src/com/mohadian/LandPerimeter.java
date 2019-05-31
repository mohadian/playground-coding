package com.mohadian;

public class LandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    count = countPermiter(grid, i, j);
                }
            }
        }

        return count;
    }

    private int countPermiter(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j]!=1){
            return 0;
        }
        int sides = 0;
        grid[i][j] = 2;
        sides += countPermiter(grid, i-1, j);
        sides += countPermiter(grid, i, j+1);
        sides += countPermiter(grid, i+1, j);
        sides += countPermiter(grid, i, j-1);

        if(i-1<0 || grid[i-1][j] == 0){
            sides+=1;
        }
        if(i+1>grid.length-1 || grid[i+1][j] == 0){
            sides+=1;
        }
        if(j-1<0 || grid[i][j-1] == 0){
            sides+=1;
        }
        if(j+1>grid[0].length-1 || grid[i][j+1] == 0){
            sides+=1;
        }

        return sides;
    }

    public static void main(String[] args) {
        int[][] land = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        LandPerimeter landPerimeter = new LandPerimeter();

        System.out.println(landPerimeter.islandPerimeter(land));

    }
}
