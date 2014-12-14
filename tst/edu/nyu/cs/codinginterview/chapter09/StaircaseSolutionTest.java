package edu.nyu.cs.codinginterview.chapter09;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaircaseSolutionTest {
    private int[] num = {0, 1, 2, 3, 8, 10, 20};
    private long[] result = {0, 1, 2, 4, 81, 274, 121415};

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.StaircaseSolution#numberOfWays(int)}.
     */
    @Test
    public void testNumberOfWays() {
        for (int i = 0; i < num.length; i++) {
            assertEquals(result[i], StaircaseSolution.numberOfWays(num[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.StaircaseSolution#numberOfWaysBottomUp(int)}.
     */
    @Test
    public void testNumberOfWaysBottomUp() {
        for (int i = 0; i < num.length; i++) {
            assertEquals(result[i], StaircaseSolution.numberOfWaysBottomUp(num[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.StaircaseSolution#numberOfWaysTopDown(int)}.
     */
    @Test
    public void testNumberOfWaysTopDown() {
        for (int i = 0; i < num.length; i++) {
            assertEquals(result[i], StaircaseSolution.numberOfWaysTopDown(num[i]));
        }
    }

}
