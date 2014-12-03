package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateMatrixSolutionTest {
    private int[][] a1 = {
            { 1,  2,  3,  4},
            { 5,  6,  7,  8},
            { 9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    private int[][] a2 = {
            { 1,  2,  3,  4,  5},
            { 6,  7,  8,  9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
    };
    private int[][] rotate1 = {
            { 4,  8, 12, 16},
            { 3,  7, 11, 15},
            { 2,  6, 10, 14},
            { 1,  5,  9, 13}
    };
    private int[][] rotate2 = {
            { 5, 10, 15, 20, 25},
            { 4,  9, 14, 19, 24},
            { 3,  8, 13, 18, 23},
            { 2,  7, 12, 17, 22},
            { 1,  6, 11, 16, 21}
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.RotateMatrixSolution#rotate90(int[][])}.
     */
    @Test(expected=NullPointerException.class)
    public void testRotate90WithNullMatrix() {
        RotateMatrixSolution.rotate90(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.RotateMatrixSolution#rotate90(int[][])}.
     */
    @Test
    public void testRotate90() {
        RotateMatrixSolution.rotate90(a1);
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length; j++) {
                assertEquals(rotate1[i][j], a1[i][j]);
            }
        }
        RotateMatrixSolution.rotate90(a2);
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                assertEquals(rotate2[i][j], a2[i][j]);
            }
        }
    }

}
