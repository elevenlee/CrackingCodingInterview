package edu.nyu.cs.codinginterview.chapter01;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Write an algorithm such that if an element is an M*N matrix is 0, its entire row an column are set to 0.
 */
public class SetZeroMatrixSolution {
    
    private SetZeroMatrixSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(mn)
     * space complexity O(n)
     */
    public static void setZero(int[][] a) {
        Check.nullCheck(a, "matrix");
        
        int m = a.length;
        int n = a[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    a[i][j] = 0;
                }
            }
        }
    }

}
