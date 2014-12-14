package edu.nyu.cs.codinginterview.chapter09;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagicIndexSolutionTest {
    private final int[][] a = {
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18},
            {-6, 1, 5, 9, 12, 15, 18, 20, 21},
            {-7, -4, 2, 10, 45, 67, 123, 921, 1011},
            {-6, -1, 1, 3, 6, 10, 23, 56, 99, 101},
            {-11, -9, 0, 2, 4, 6, 12, 22, 23, 41, 50},
            {-15, -10, -5, -1, 1, 5, 12, 22, 23, 41},
            {-5, -1, 0, 1, 2, 3, 6, 9, 10, 12},
            {-5, -1, 0, 1, 2, 3, 4, 7, 10, 12, 22},
            {-5, -1, 0, 1, 2, 3, 4, 6, 8, 12, 22, 33},
            {-5, -1, 0, 1, 2, 3, 4, 5, 6, 9},
            {-5, -1, 0, 1, 2, 3, 4, 5, 6, 7, 10},
    };
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex1(int[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testMagicIndex1WithNullArray() {
        MagicIndexSolution.magicIndex1(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex1(int[])}.
     */
    @Test
    public void testMagicIndex1WithEmpty() {
        int[] empty = {};
        assertEquals(-1, MagicIndexSolution.magicIndex1(empty));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex1(int[])}.
     */
    @Test
    public void testMagicIndex1WithNoMagicIndex() {
        int[] items = {-5, -2, 0, 5, 9, 33, 89, 101, 1234};
        assertEquals(-1, MagicIndexSolution.magicIndex1(items));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex1(int[])}.
     */
    @Test
    public void testMagicIndex1WithDuplicateValue() {
        int[] items = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1};
        assertEquals(1, MagicIndexSolution.magicIndex1(items));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex1(int[])}.
     */
    @Test
    public void testMagicIndex1() {
        int[] items = {-1, 0, 2, 5};
        assertEquals(2, MagicIndexSolution.magicIndex1(items));
        for (int i = 0; i < a.length; i++) {
            assertEquals(i, MagicIndexSolution.magicIndex1(a[i]));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex2(int[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testMagicIndex2WithNullArray() {
        MagicIndexSolution.magicIndex2(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex2(int[])}.
     */
    @Test
    public void testMagicIndex2WithEmpty() {
        int[] empty = {};
        assertEquals(-1, MagicIndexSolution.magicIndex2(empty));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex2(int[])}.
     */
    @Test
    public void testMagicIndex2WithNoMagicIndex() {
        int[] items = {-5, -2, 0, 5, 9, 33, 89, 101, 1234};
        assertEquals(-1, MagicIndexSolution.magicIndex2(items));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex2(int[])}.
     */
    @Test
    public void testMagicIndex2WithDuplicateValue() {
        int[] items = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1};
        assertEquals(1, MagicIndexSolution.magicIndex2(items));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.MagicIndexSolution#magicIndex2(int[])}.
     */
    @Test
    public void testMagicIndex2() {
        int[] items = {-1, 0, 2, 5};
        assertEquals(2, MagicIndexSolution.magicIndex2(items));
        for (int i = 0; i < a.length; i++) {
            assertEquals(i, MagicIndexSolution.magicIndex2(a[i]));
        }
    }

}
