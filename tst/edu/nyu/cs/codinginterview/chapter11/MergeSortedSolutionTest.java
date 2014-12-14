package edu.nyu.cs.codinginterview.chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortedSolutionTest {
    private final Integer[] a = {
            2, 5, 8, 9, 23,
            55, null, null, null, null,
            null, null, null, null, null,
            null, null, null, null, null,
            null, null, null, null, null,
            null, null, null, null, null,
    };
    private final Integer[] b = {
            0, 1, 7, 9, 12,
            22, 31, 32, 89, 100,
            129, 901,
    };
    private final Integer[] empty = {
            null, null, null, null, null,
            null, null, null, null, null,
            null, null, null, null, null,
            null, null, null, null, null
    };
    private final Integer[] result = {
            0, 1, 2, 5, 7,
            8, 9, 9, 12, 22,
            23, 31, 32, 55, 89,
            100, 129, 901
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge1(T[], T[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testMerge1WithNullArray() {
        MergeSortedSolution.merge1(null, b);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge1(T[], T[])}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testMerge1WithNotEnoughLengthArrayA() {
        Integer[] tmp = {1, 2};
        MergeSortedSolution.merge1(tmp, b);
    }
    
    @Test
    public void testMerge1WithEmptyArray() {
        MergeSortedSolution.merge1(empty, b);
        for (int i = 0; i < b.length; i++) {
            assertEquals(empty[i], b[i]);
        }
        Integer[] tmp = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[i] = a[i];
        }
        for (int i = 0; i < empty.length; i++) {
            empty[i] = null;
        }
        MergeSortedSolution.merge1(a, empty);
        for (int i = 0; i < a.length; i++) {
            assertEquals(tmp[i], a[i]);
        }
    }
    
    @Test
    public void testMerge1() {
        MergeSortedSolution.merge1(a, b);
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], a[i]);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge2(T[], T[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testMerge2WithNullArray() {
        MergeSortedSolution.merge2(a, null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge2(T[], T[])}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testMerge2WithNotEnoughLengthArrayA() {
        Integer[] tmp = {1, 2};
        MergeSortedSolution.merge2(tmp, b);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge2(T[], T[])}.
     */
    @Test
    public void testMerge2WithEmptyArray() {
        MergeSortedSolution.merge2(empty, b);
        for (int i = 0; i < b.length; i++) {
            assertEquals(empty[i], b[i]);
        }
        Integer[] tmp = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[i] = a[i];
        }
        for (int i = 0; i < empty.length; i++) {
            empty[i] = null;
        }
        MergeSortedSolution.merge2(a, empty);
        for (int i = 0; i < a.length; i++) {
            assertEquals(tmp[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge2(T[], T[])}.
     */
    @Test
    public void testMerge2() {
        MergeSortedSolution.merge2(a, b);
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], a[i]);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge3(T[], T[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testMerge3WithNullArray() {
        MergeSortedSolution.merge3(a, null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge3(T[], T[])}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testMerge3WithNotEnoughLengthA() {
        Integer[] tmp = {1, 2};
        MergeSortedSolution.merge3(tmp, b);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge3(T[], T[])}.
     */
    @Test
    public void testMerge3WithEmptyArray() {
        MergeSortedSolution.merge3(empty, b);
        for (int i = 0; i < b.length; i++) {
            assertEquals(empty[i], b[i]);
        }
        Integer[] tmp = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[i] = a[i];
        }
        for (int i = 0; i < empty.length; i++) {
            empty[i] = null;
        }
        MergeSortedSolution.merge3(a, empty);
        for (int i = 0; i < a.length; i++) {
            assertEquals(tmp[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.MergeSortedSolution#merge3(T[], T[])}.
     */
    @Test
    public void testMerge3() {
        MergeSortedSolution.merge3(a, b);
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], a[i]);
        }
    }

}
