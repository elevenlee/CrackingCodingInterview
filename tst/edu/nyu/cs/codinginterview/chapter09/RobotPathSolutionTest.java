package edu.nyu.cs.codinginterview.chapter09;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotPathSolutionTest {
    private int[] xs = {0, 0, 8, 5, 8, 10};
    private int[] ys = {0, 4, 0, 5, 6, 15};
    private int[] result = {0, 1, 1, 252, 3003, 3268760};

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.RobotPathSolution#numberOfPaths(int, int)}.
     */
    @Test
    public void testNumberOfPaths() {
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], RobotPathSolution.numberOfPaths(xs[i], ys[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.RobotPathSolution#numberOfPathsBottomUp(int, int)}.
     */
    @Test
    public void testNumberOfPathsBottomUp() {
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], RobotPathSolution.numberOfPathsBottomUp(xs[i], ys[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.RobotPathSolution#numberOfPathsTopDown(int, int)}.
     */
    @Test
    public void testNumberOfPathsTopDown() {
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], RobotPathSolution.numberOfPathsTopDown(xs[i], ys[i]));
        }
    }

}
