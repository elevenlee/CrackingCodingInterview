package edu.nyu.cs.codinginterview.chapter04;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import edu.nyu.cs.codinginterview.util.BST;

public class MinHeightBSTSolutionTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter04.MinHeightBSTSolution#minHeight(T[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testMinHeightWithNullArray() {
        MinHeightBSTSolution.minHeight(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter04.MinHeightBSTSolution#minHeight(T[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testMinHeightWithNullItem() {
        String[] s = {
                "Java", null, "C"
        };
        MinHeightBSTSolution.minHeight(s);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter04.MinHeightBSTSolution#minHeight(T[])}.
     */
    @Test
    public void testMinHeightWithEmptyArray() {
        String[] s = {};
        BST<String> bst = MinHeightBSTSolution.minHeight(s);
        assertTrue(bst.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter04.MinHeightBSTSolution#minHeight(T[])}.
     */
    @Test
    public void testMinHeightWithSingleItem() {
        String[] s = {"Java"};
        BST<String> bst = MinHeightBSTSolution.minHeight(s);
        List<String> order = bst.keysInOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(s[i], order.get(i));
        }
        order = bst.keysPreOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(s[i], order.get(i));
        }
        order = bst.keysPostOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(s[i], order.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter04.MinHeightBSTSolution#minHeight(T[])}.
     */
    @Test
    public void testMinHeightWithNoDuplicateOddItem() {
        Integer[] oddArray = {
                 1,  2,  5,  7,  9,
                12, 45, 53, 55, 59,
                61, 65, 70, 74, 90
        };
        BST<Integer> bst = MinHeightBSTSolution.minHeight(oddArray);
        List<Integer> order = bst.keysInOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(oddArray[i], order.get(i));
        }
        Integer[] preArray = {
                53,  7,  2,  1,  5,
                12,  9, 45, 65, 59,
                55, 61, 74, 70, 90
        };
        order = bst.keysPreOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(preArray[i], order.get(i));
        }
        Integer[] postArray = {
                 1,  5,  2,  9, 45,
                12,  7, 55, 61, 59,
                70, 90, 74, 65, 53
        };
        order = bst.keysPostOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(postArray[i], order.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter04.MinHeightBSTSolution#minHeight(T[])}.
     */
    @Test
    public void testMinHeightWithNoDuplicateEvenItem() {
        Integer[] evenArray = {
                 4,  7,  9, 10, 34,
                51, 59, 60, 63, 66,
                78, 80, 83, 88
        };
        BST<Integer> bst = MinHeightBSTSolution.minHeight(evenArray);
        List<Integer> order = bst.keysInOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(evenArray[i], order.get(i));
        }
        Integer[] preArray = {
                59,  9,  4,  7, 34,
                10, 51, 78, 63, 60,
                66, 83, 80, 88
        };
        order = bst.keysPreOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(preArray[i], order.get(i));
        }
        Integer[] postArray = {
                 7,  4, 10, 51, 34,
                 9, 60, 66, 63, 80,
                 88, 83, 78, 59
        };
        order = bst.keysPostOrder();
        for (int i = 0; i < order.size(); i++) {
            assertEquals(postArray[i], order.get(i));
        }
    }

}
