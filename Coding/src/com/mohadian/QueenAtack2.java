package com.mohadian;

import com.sun.javafx.binding.StringFormatter;

public class QueenAtack2 {
    public static void main(String[] args) {
        int boardSize = 8;

        int queenRow = 1;
        int queenCol = 7;

        int row = rowAttack(boardSize);
        int col = colAttack(boardSize);
        int left = leftDiagAttack(boardSize, queenRow, queenCol);
        int right = rightDiagAttack(boardSize, queenRow, queenCol);

        System.out.println(StringFormatter.format("Row %d, Col %d, Right D %d Left %d", row, col, right, left).getValue());
    }

    private static int rightDiagAttack(int boardSize, int queenRow, int queenCol) {
        int leftS = Math.min(queenCol, queenRow);
        int rightS = Math.min(boardSize - queenRow - 1, boardSize - queenCol - 1);
        return leftS + rightS;
    }

    private static int leftDiagAttack(int boardSize, int queenRow, int queenCol) {
        int leftS = Math.min(boardSize - queenCol - 1, queenRow > 0 ? queenRow - 1 : 0);
        int rightS = Math.min(boardSize - queenRow - 1, queenCol > 0 ? queenCol - 1 : 0);
        return leftS + rightS;
    }

    private static int colAttack(int boardSize) {
        return boardSize - 1;
    }

    private static int rowAttack(int boardSize) {
        return boardSize - 1;
    }
}
