package edu.nyu.cs.codinginterview.chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInRotateArraySolutionTest {
    private final Integer[] notEmptyList = {
            15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
    };
    private final Integer[] emptyList = {};

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInRotateArraySolution#binarySerach(T[], java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testBinarySerachWithNullArray() {
        SearchInRotateArraySolution.binarySerach(null, 8);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInRotateArraySolution#binarySerach(T[], java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testBinarySerachWithNullKey() {
        SearchInRotateArraySolution.binarySerach(notEmptyList, null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInRotateArraySolution#binarySerach(T[], java.lang.Comparable)}.
     */
    @Test
    public void testBinarySerachInEmptyArray() {
        assertEquals(-1, SearchInRotateArraySolution.binarySerach(emptyList, 9));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInRotateArraySolution#binarySerach(T[], java.lang.Comparable)}.
     */
    @Test
    public void testBinarySerachInNotEmptyArray() {
        for (int i = 0; i < notEmptyList.length; i++) {
            assertEquals(
                    i, SearchInRotateArraySolution.binarySerach(
                            notEmptyList, notEmptyList[i]));
        }
    }

}
