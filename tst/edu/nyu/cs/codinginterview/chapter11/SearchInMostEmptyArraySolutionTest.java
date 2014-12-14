package edu.nyu.cs.codinginterview.chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInMostEmptyArraySolutionTest {
    private final String[] s1 = {
            "at", "", "", "", "ball",
            "", "", "car", "", "",
            "dad", "", ""
    };
    private final String[] s2 = {
            "", "", "at", "", "", "", "ball",
            "", "", "car", "", "", "dad"
    };
    private final String[] s3 = {
            "at", "", "", "", "ball",
            "", "", "car", "", "", "dad"
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInMostEmptyArraySolutionTest#binarySearch(java.lang.String[], java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testBinarySearchWithNullArray() {
        SearchInMostEmptyArraySolution.binarySearch(null, "test");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInMostEmptyArraySolutionTest#binarySearch(java.lang.String[], java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testBinarySearchWithNullKey() {
        SearchInMostEmptyArraySolution.binarySearch(s1, null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInMostEmptyArraySolutionTest#binarySearch(java.lang.String[], java.lang.String)}.
     */
    @Test
    public void testBinarySearchWithEmptyKey() {
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s1, ""));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInMostEmptyArraySolutionTest#binarySearch(java.lang.String[], java.lang.String)}.
     */
    @Test
    public void testBinarySearchNoSuchKey() {
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s1, "a"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s1, "boy"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s1, "eye"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s2, "a"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s2, "boy"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s2, "eye"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s3, "a"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s3, "boy"));
        assertEquals(-1, SearchInMostEmptyArraySolution.binarySearch(s3, "eye"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.SearchInMostEmptyArraySolutionTest#binarySearch(java.lang.String[], java.lang.String)}.
     */
    @Test
    public void testBinarySearch() {
        assertEquals(0, SearchInMostEmptyArraySolution.binarySearch(s1, "at"));
        assertEquals(4, SearchInMostEmptyArraySolution.binarySearch(s1, "ball"));
        assertEquals(7, SearchInMostEmptyArraySolution.binarySearch(s1, "car"));
        assertEquals(10, SearchInMostEmptyArraySolution.binarySearch(s1, "dad"));
        assertEquals(2, SearchInMostEmptyArraySolution.binarySearch(s2, "at"));
        assertEquals(6, SearchInMostEmptyArraySolution.binarySearch(s2, "ball"));
        assertEquals(9, SearchInMostEmptyArraySolution.binarySearch(s2, "car"));
        assertEquals(12, SearchInMostEmptyArraySolution.binarySearch(s2, "dad"));
        assertEquals(0, SearchInMostEmptyArraySolution.binarySearch(s3, "at"));
        assertEquals(4, SearchInMostEmptyArraySolution.binarySearch(s3, "ball"));
        assertEquals(7, SearchInMostEmptyArraySolution.binarySearch(s3, "car"));
        assertEquals(10, SearchInMostEmptyArraySolution.binarySearch(s3, "dad"));
    }

}
