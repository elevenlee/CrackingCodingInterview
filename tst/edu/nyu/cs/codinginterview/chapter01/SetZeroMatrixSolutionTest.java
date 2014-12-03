package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetZeroMatrixSolutionTest {
    private int[][][] a = {
            {
                { 1,  0,  3},
                { 4,  5,  6},
                { 0,  8,  9},
                {10, 11, 12}
            },
            {
                {1,  0,  3,  4},
                {5,  6,  7,  0},
                {0, 10, 11, 12},
            },
            {
                { 1,  0,  0,  4},
                { 0,  6,  7,  8},
                { 9,  0, 11,  0},
                {13,  0,  0, 16}
            }
    };
    private int[][][] after = {
            {
                { 0,  0,  0},
                { 0,  0,  6},
                { 0,  0,  0},
                { 0,  0, 12}
            },
            {
                {0,  0,  0,  0},
                {0,  0,  0,  0},
                {0,  0,  0,  0},
            },
            {
                { 0,  0,  0,  0},
                { 0,  0,  0,  0},
                { 0,  0,  0,  0},
                { 0,  0,  0,  0}
            }
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.SetZeroMatrixSolution#setZero(int[][])}.
     */
    @Test(expected=NullPointerException.class)
    public void testSetZeroWithNullMatrix() {
        SetZeroMatrixSolution.setZero(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.SetZeroMatrixSolution#setZero(int[][])}.
     */
    @Test
    public void testSetZero() {
        for (int k = 0; k < a.length; k++) {
            SetZeroMatrixSolution.setZero(a[k]);
            int m = a[k].length;
            int n = a[k][0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    assertEquals(after[k][i][j], a[k][i][j]);
                }
            }
        }
    }

}
