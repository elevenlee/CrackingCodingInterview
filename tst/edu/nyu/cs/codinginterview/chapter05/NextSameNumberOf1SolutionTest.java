package edu.nyu.cs.codinginterview.chapter05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NextSameNumberOf1SolutionTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextSmallest1(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextSmallest1WithNegativeInt() {
        NextSameNumberOf1Solution.nextSmallest1(-6);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextSmallest1(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextSmallest1WithZeroInt() {
        NextSameNumberOf1Solution.nextSmallest1(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextSmallest1(int)}.
     */
    @Test
    public void testNextSmallest1() {
        assertEquals(104, NextSameNumberOf1Solution.nextSmallest1(100));
        assertEquals(47, NextSameNumberOf1Solution.nextSmallest1(31));
        assertEquals(64, NextSameNumberOf1Solution.nextSmallest1(32));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextSmallest2(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextSmallest2WithNegativeInt() {
        NextSameNumberOf1Solution.nextSmallest2(-6);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextSmallest2(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextSmallest2WithZeroInt() {
        NextSameNumberOf1Solution.nextSmallest2(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextSmallest2(int)}.
     */
    @Test
    public void testNextSmallest2() {
        assertEquals(104, NextSameNumberOf1Solution.nextSmallest2(100));
        assertEquals(47, NextSameNumberOf1Solution.nextSmallest2(31));
        assertEquals(64, NextSameNumberOf1Solution.nextSmallest2(32));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest1(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextLargest1WithNegativeInt() {
        NextSameNumberOf1Solution.nextLargest1(-32);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest1(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextLargest1WithZeroInt() {
        NextSameNumberOf1Solution.nextLargest1(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest1(int)}.
     */
    @Test
    public void testNextLargest1WithOneInt() {
        assertEquals(-1, NextSameNumberOf1Solution.nextLargest1(1));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest1(int)}.
     */
    @Test
    public void testNextLargest1() {
        assertEquals(98, NextSameNumberOf1Solution.nextLargest1(100));
        assertEquals(-1, NextSameNumberOf1Solution.nextLargest1(31));
        assertEquals(16, NextSameNumberOf1Solution.nextLargest1(32));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest2(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextLargest2WithNegativeInt() {
        NextSameNumberOf1Solution.nextLargest2(-32);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest2(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNextLargest2WithZeroInt() {
        NextSameNumberOf1Solution.nextLargest2(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest2(int)}.
     */
    @Test
    public void testNextLargest2WithOneInt() {
        assertEquals(-1, NextSameNumberOf1Solution.nextLargest2(1));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NextSameNumberOf1Solution#nextLargest2(int)}.
     */
    @Test
    public void testNextLargest2() {
        assertEquals(98, NextSameNumberOf1Solution.nextLargest2(100));
        assertEquals(-1, NextSameNumberOf1Solution.nextLargest2(31));
        assertEquals(16, NextSameNumberOf1Solution.nextLargest2(32));
    }

}
