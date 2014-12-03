package edu.nyu.cs.codinginterview.chapter01;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Give an image represented by an N*N matrix, where each pixel in the image is 4 bytes, write a method to 
 * rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrixSolution {
    
    private RotateMatrixSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(1)
     */
    public static void rotate90(int[][] a) {
        Check.nullCheck(a, "n*n matrix");
        
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = a[i][j];
                a[i][j] = a[n - i - 1][j];
                a[n - i - 1][j] = tmp;
            }
        }
    }

}
