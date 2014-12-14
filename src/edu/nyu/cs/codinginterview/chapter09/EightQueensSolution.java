package edu.nyu.cs.codinginterview.chapter09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * <p>
 * Write an algorithm to print all ways of arranging eight queens on an 8*8 chess board so that none of them 
 * share the same row, column or diagonal. In this case, "diagonal" means all diagonals, not just the two 
 * that bisect the board.
 */
public class EightQueensSolution {
    private static final int GRID_SIZE = 8;
    
    private EightQueensSolution() {
        throw new AssertionError();
    }
    
    public static List<Integer[]> validQueens(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        List<Integer[]> result = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        placeQueens(0, columns, result);
        return result;
    }
    /**
     * time complexity O(n!)
     * space complexity O(n)
     */
    private static void placeQueens(int row, Integer[] columns, List<Integer[]> result) {
        if (row == GRID_SIZE) {     // Found valid placement
            result.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (isValid(columns, row, col)) {
                    columns[row] = col;     // Place Queen
                    placeQueens(row + 1, columns, result);
                }
            }
        }
    }
    
    /**
     * Check if (row, column) is a valid spot for a queen by checking if there is a queen in the same column 
     * or diagonal, We do not need to check it for queens in the same row because the calling placeQueens 
     * only attempts to place one queen at a time. We know this row is empty.
     */
    private static boolean isValid(Integer[] columns, int row, int column) {
        for (int i = 0; i < row; i++) {
            int j = columns[i];
            
            /* Check if rows have a queen in the same column */
            if (j == column) {
                return false;
            }
            
            /* Check diagonal: if the distance between the columns equals the distance
             * between the rows, then they're in the same diagonal. */
            int colDiff = Math.abs(j - column);
            int rowDiff = row - i;
            if (colDiff == rowDiff) {
                return false;
            }
        }
        return true;
    }

}
