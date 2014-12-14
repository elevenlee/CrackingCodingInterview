package edu.nyu.cs.codinginterview.chapter11;

import edu.nyu.cs.codinginterview.util.Check;

public class MatrixSearchSolution {
    
    private MatrixSearchSolution() {
        throw new AssertionError();
    }
    
    public static <T extends Comparable<? super T>> MatrixIndex linearSearch(
            T[][] items, T key) {
        Check.nullCheck(items, "item matrix");
        for (T[] row : items) {
            Check.nullCheck(row, "row");
            for (T item : row) {
                Check.nullCheck(item, "item");
            }
        }
        if (key == null) {
            return null;
        } else if (items.length <= 0) {
            return null;
        }
        
        int row = 0;
        int column = items[0].length - 1;
        while (row < items.length && column >= 0) {
            if (key.compareTo(items[row][column]) == 0) {
                return new MatrixIndex(row, column);
            } else if (key.compareTo(items[row][column]) < 0) {
                column--;
            } else {
                row++;
            }
        }
        return null;
    }

}
