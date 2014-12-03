package edu.nyu.cs.codinginterview.vi;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwapMinMaxSolutionTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.SwapMinMaxSolution#swapMinMax(int[])}.
     */
    @Test
    public void testSwapMinMaxWithEmptyArray() {
        int[] a = {};
        int[] expect = {};
        SwapMinMaxSolution.swapMinMax(a);
        assertEquals(expect.length, a.length);
        for (int i = 0; i < a.length; i++) {
            assertEquals(expect[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.SwapMinMaxSolution#swapMinMax(int[])}.
     */
    @Test
    public void testSwapMinMaxAtFirstPosition() {
        int[] a = {5, 21, 10, 32, 9, 6, 90, 123, 91, 43, 88};
        int[] expect = {123, 21, 10, 32, 9, 6, 90, 5, 91, 43, 88};
        SwapMinMaxSolution.swapMinMax(a);
        assertEquals(expect.length, a.length);
        for (int i = 0; i < a.length; i++) {
            assertEquals(expect[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.SwapMinMaxSolution#swapMinMax(int[])}.
     */
    @Test
    public void testSwapMinMaxAtLastPosition() {
        int[] a = {88, 21, 10, 32, 9, 6, 90, 123, 91, 43, 5};
        int[] expect = {88, 21, 10, 32, 9, 6, 90, 5, 91, 43, 123};
        SwapMinMaxSolution.swapMinMax(a);
        assertEquals(expect.length, a.length);
        for (int i = 0; i < a.length; i++) {
            assertEquals(expect[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.SwapMinMaxSolution#swapMinMax(int[])}.
     */
    @Test
    public void testSwapMinMaxAtLastMiddlePosstion() {
        int[] a = {88, 21, 10, 32, 9, 6, 90, 123, 91, 5, 43};
        int[] expect = {88, 21, 10, 32, 9, 6, 90, 5, 91, 123, 43};
        SwapMinMaxSolution.swapMinMax(a);
        assertEquals(expect.length, a.length);
        for (int i = 0; i < a.length; i++) {
            assertEquals(expect[i], a[i]);
        }
    }

}
