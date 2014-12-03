package edu.nyu.cs.codinginterview.chapter02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KthToLastElementSolutionTest {
    private KthToLastElementSolution<Integer> integers;
    private final Integer[] i = {5, 7, 8, 1, 34, 5, 9, 10, 2, 22, 190};

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        integers = new KthToLastElementSolution<Integer>(i);
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.KthToLastElementSolution#kthToLastElementIterative(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testKthToLastElementIterativeWithNegativeKth() {
        integers.kthToLastElementIterative(-5);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.KthToLastElementSolution#kthToLastElementIterative(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testKthToLastElementIterativeWithZeroKth() {
        integers.kthToLastElementIterative(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.KthToLastElementSolution#kthToLastElementIterative(int)}.
     */
    @Test
    public void testKthToLastElementIterativeWithTooBigKth() {
        assertEquals(null, integers.kthToLastElementIterative(100));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.KthToLastElementSolution#kthToLastElementIterative(int)}.
     */
    @Test
    public void testKthToLastElementIterative() {
        for (int k = 1; k <= i.length; k++) {
            assertEquals(i[k - 1], integers.kthToLastElementIterative(k));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.KthToLastElementSolution#kthToLastElementRecursive(int)}.
     */
    @Test
    public void testKthToLastElementRecursive() {
        
    }

}
