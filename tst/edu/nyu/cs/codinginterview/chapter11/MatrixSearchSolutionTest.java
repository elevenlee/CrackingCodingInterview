package edu.nyu.cs.codinginterview.chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixSearchSolutionTest {
    private final Integer[][] notEmptyMatrix1 = {
            {15, 21, 42, 87},
            {20, 35, 85, 96},
            {30, 55, 94, 105},
            {46, 82, 100, 120}
    };
    private final Integer[][] notEmptyMatrix2 = {
            {15, 20, 30, 46},
            {21, 35, 55, 82},
            {42, 85, 96, 100},
            {87, 94, 105, 120}
    };
    private final Integer[][] emptyMatrix = {};

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MatrixSearchSolutionTest#linearSearch(T[][], java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testLinearSearchWithNullMatrix() {
        MatrixSearchSolution.linearSearch(null, 6);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MatrixSearchSolutionTest#linearSearch(T[][], java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testLinearSearchWithNullRow() {
        Integer[][] matrix = {
                {1, 2, 3},
                null,
                {4, 5, 6}
        };
        MatrixSearchSolution.linearSearch(matrix, 6);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MatrixSearchSolutionTest#linearSearch(T[][], java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testLinearSearchWithNullItem() {
        Integer[][] matrix = {
                {1, 2, 3},
                {null, 5, 6},
                {7, 8, 9}
        };
        MatrixSearchSolution.linearSearch(matrix, 6);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MatrixSearchSolutionTest#linearSearch(T[][], java.lang.Comparable)}.
     */
    @Test
    public void testLinearSearchWithNullKey() {
        assertEquals(null, MatrixSearchSolution.linearSearch(notEmptyMatrix1, null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MatrixSearchSolutionTest#linearSearch(T[][], java.lang.Comparable)}.
     */
    @Test
    public void testLinearSearchWithNoSuchKey() {
        assertEquals(null, MatrixSearchSolution.linearSearch(emptyMatrix, 8));
        assertEquals(null, MatrixSearchSolution.linearSearch(notEmptyMatrix1, 5));
        assertEquals(null, MatrixSearchSolution.linearSearch(notEmptyMatrix1, 75));
        assertEquals(null, MatrixSearchSolution.linearSearch(notEmptyMatrix1, 150));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MatrixSearchSolutionTest#linearSearch(T[][], java.lang.Comparable)}.
     */
    @Test
    public void testLinearSearch() {
        for (int i = 0; i < notEmptyMatrix1.length; i++) {
            for (int j = 0; j < notEmptyMatrix1[0].length; j++) {
                assertEquals(
                        new MatrixIndex(i, j), MatrixSearchSolution.linearSearch(
                                notEmptyMatrix1, notEmptyMatrix1[i][j]));
            }
        }
        for (int i = 0; i < notEmptyMatrix2.length; i++) {
            for (int j = 0; j < notEmptyMatrix2[0].length; j++) {
                assertEquals(
                        new MatrixIndex(i, j), MatrixSearchSolution.linearSearch(
                                notEmptyMatrix2, notEmptyMatrix2[i][j]));
            }
        }
    }

}
