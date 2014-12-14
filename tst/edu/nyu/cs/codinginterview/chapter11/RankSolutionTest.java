package edu.nyu.cs.codinginterview.chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankSolutionTest {
    private final Integer[] noDuplicateArray = {
            5, 1, 4, 9, 7, 10, 13
    };
    private final Integer[] duplicateArray = {
            41, 101,  70,  7,  7, 23, 55, 64, 126,
            55,   7,   2, 90, 89, 31, 40, 10,  31,
            94, 105, 126, 88, 55, 10,  5,  7,  62
    };
    private final Integer[] emptyArray = {};

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.RankSolution#getRank(T[], java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testGetRankWithNullArray() {
        RankSolution.getRank(null, 9);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.RankSolution#getRank(T[], java.lang.Comparable)}.
     */
    @Test
    public void testGetRankWithNullKey() {
        assertEquals(-1, RankSolution.getRank(noDuplicateArray, null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.RankSolution#getRank(T[], java.lang.Comparable)}.
     */
    @Test
    public void testGetRankWithNoSuchKey() {
        assertEquals(-1, RankSolution.getRank(emptyArray, 8));
        assertEquals(-1, RankSolution.getRank(noDuplicateArray, -8));
        assertEquals(-1, RankSolution.getRank(noDuplicateArray, 6));
        assertEquals(-1, RankSolution.getRank(noDuplicateArray, 20));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.RankSolution#getRank(T[], java.lang.Comparable)}.
     */
    @Test
    public void testGetRankInNoDuplicateArray() {
        int[] result = {2, 0, 1, 4, 3, 5, 6};
        for (int i = 0; i < result.length; i++) {
            assertEquals(
                    result[i], RankSolution.getRank(
                            noDuplicateArray, noDuplicateArray[i]));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.RankSolution#getRank(T[], java.lang.Comparable)}.
     */
    @Test
    public void testGetRankInDuplicateArray() {
        int[] result = {
                12, 23, 18,  5,  5,  8, 15, 17, 26,
                15,  5,  0, 21, 20, 10, 11,  7, 10,
                22, 24, 26, 19, 15,  7,  1,  5, 16
        };
        for (int i = 0; i < result.length; i++) {
            assertEquals(
                    result[i], RankSolution.getRank(
                            duplicateArray, duplicateArray[i]));
        }
    }

}
