package edu.nyu.cs.codinginterview.chapter05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwapOddEvenBitsSolutionTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.SwapOddEvenBitsSolution#swapOddEvenBits1(int)}.
     */
    @Test
    public void testSwapOddEvenBits1() {
        int[] numbers = {0, 1, 2, 3, 4, 15, 31, 100, 180};
        int[] results = {0, 2, 1, 3, 8, 15, 47, 152, 120};
        for (int i = 0; i < numbers.length; i++) {
            assertEquals(results[i], SwapOddEvenBitsSolution.swapOddEvenBits1(numbers[i]));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.SwapOddEvenBitsSolution#swapOddEvenBits2(int)}.
     */
    @Test
    public void testSwapOddEvenBits2() {
        int[] numbers = {0, 1, 2, 3, 4, 15, 31, 100, 180};
        int[] results = {0, 2, 1, 3, 8, 15, 47, 152, 120};
        for (int i = 0; i < numbers.length; i++) {
            assertEquals(results[i], SwapOddEvenBitsSolution.swapOddEvenBits2(numbers[i]));
        }
    }

}
