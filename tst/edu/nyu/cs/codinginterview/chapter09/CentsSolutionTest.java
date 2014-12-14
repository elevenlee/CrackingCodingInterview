package edu.nyu.cs.codinginterview.chapter09;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentsSolutionTest {
    private final int[] nums = {
             0,  1,  3,  5,  8,
            10, 12, 15, 18, 20,
            23, 25, 31, 50, 61,
            75, 80, 83, 99, 100
    };
    private final int[] results = {
              0,   1,   1,   2,   2,
              4,   4,   6,   6,   9,
              9,  13,  18,  49,  73,
            121, 141, 141, 213, 242
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.CentsSolutionTest#numberOfWays(int)}.
     */
    @Test
    public void testNumberOfWaysWithNegativeN() {
        assertEquals(0, CentsSolution.numberOfWays(-9));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.CentsSolutionTest#numberOfWays(int)}.
     */
    @Test
    public void testNumberOfWaysWithPositiveN() {
        for (int i = 0; i < nums.length; i++) {
            assertEquals(results[i], CentsSolution.numberOfWays(nums[i]));
        }
    }

}
