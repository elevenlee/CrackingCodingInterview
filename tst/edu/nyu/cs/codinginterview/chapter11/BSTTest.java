package edu.nyu.cs.codinginterview.chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {
    private final Integer[] noDuplicateArray = {
            5, 1, 4, 9, 7, 10, 13
    };
    private final Integer[] duplicateArray = {
            41, 101,  70,  7,  7, 23, 55, 64, 126,
            55,   7,   2, 90, 89, 31, 40, 10,  31,
            94, 105, 126, 88, 55, 10,  5,  7,  62
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.BST#getRank(java.lang.Comparable)}.
     */
    @Test
    public void testGetRankWithNullItem() {
        assertEquals(-1, new BST<String>().getRank(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.BST#getRank(java.lang.Comparable)}.
     */
    @Test
    public void testGetRankInEmptyArray() {
        BST<Integer> bst = new BST<Integer>();
        assertEquals(-1, bst.getRank(90));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.BST#getRank(java.lang.Comparable)}.
     */
    @Test
    public void testGetRankInNotEmptyNoDuplicateArray() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(noDuplicateArray);
        int[] result = {2, 0, 1, 4, 3, 5, 6};
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], bst.getRank(noDuplicateArray[i]));
        }
        assertEquals(-1, bst.getRank(-3));
        assertEquals(-1, bst.getRank(6));
        assertEquals(-1, bst.getRank(20));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.BST#getRank(java.lang.Comparable)}.
     */
    @Test
    public void testGetRankInNotEmptyDuplicateArray() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(duplicateArray);
        int[] result = {
                12, 23, 18,  5,  5,  8, 15, 17, 26,
                15,  5,  0, 21, 20, 10, 11,  7, 10,
                22, 24, 26, 19, 15,  7,  1,  5, 16
        };
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], bst.getRank(duplicateArray[i]));
        }
        assertEquals(-1, bst.getRank(-3));
        assertEquals(-1, bst.getRank(50));
        assertEquals(-1, bst.getRank(801));
    }

}
