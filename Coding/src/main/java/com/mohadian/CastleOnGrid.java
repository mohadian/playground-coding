package com.mohadian;

import java.util.Arrays;

public class CastleOnGrid {

    public static void main(String[] args) {
        char[][] maze = new char[][]{{'.', 'X', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 2;

        int turns = minimumMoves(maze, startX, startY, endX, endY);

        System.out.println(turns);
    }

    private static int minimumMoves(char[][] maze, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        boolean foundPath = minimumMoves(maze, startX, startY, endX, endY, visited);
        if (foundPath) {
            return calculateTurns(visited, startX, startY, endX, endY);
        } else {
            return 0;
        }
    }

    private static int calculateTurns(boolean[][] visited, int startX, int startY, int endX, int endY) {
        for (boolean[] booleans : visited) {
            System.out.println(Arrays.toString(booleans));
        }
        int x = startX;
        int y = startY;
        visited[x][y] = false;
        boolean vertical = false;
        int count = 0;
        boolean last_direction_vertical = false;
        if (x - 1 > 0 && visited[x - 1][y]) {
            vertical = true;
            last_direction_vertical = true;
        }
        if (x + 1 < visited.length && visited[x + 1][y]) {
            vertical = true;
            last_direction_vertical = true;
        }

        while (x != endX || y != endY) {
            if (x - 1 >= 0 && visited[x - 1][y]) {
                x--;
                vertical = true;
            } else if (x + 1 < visited.length && visited[x + 1][y]) {
                x++;
                vertical = true;
            } else {
                if (y - 1 >= 0 && visited[x][y - 1]) {
                    y--;
                    vertical = false;
                } else if (y + 1 < visited[0].length && visited[x][y + 1]) {
                    y++;
                    vertical = false;
                }
            }
            visited[x][y] = false;
            if (last_direction_vertical != vertical) {
                last_direction_vertical = vertical;
                count++;
            }
        }

        return count;
    }

    private static boolean minimumMoves(char[][] maze, int startX, int startY, int endX, int endY, boolean[][] visited) {
        if (startX == endX && startY == endY) {
            visited[startX][startY] = true;
            return true;
        }

        if (startX == maze.length || startY == maze[0].length || startX < 0 || startY < 0) {
            return false;
        }

        if (maze[startX][startY] == '.' && !visited[startX][startY]) {

            visited[startX][startY] = true;

            if (minimumMoves(maze, startX + 1, startY, endX, endY, visited)) {
                return true;
            }

            if (minimumMoves(maze, startX - 1, startY, endX, endY, visited)) {
                return true;
            }

            if (minimumMoves(maze, startX, startY + 1, endX, endY, visited)) {
                return true;
            }

            if (minimumMoves(maze, startX, startY - 1, endX, endY, visited)) {
                return true;
            }

            visited[startX][startY] = false;
        }
        return false;
    }
}
