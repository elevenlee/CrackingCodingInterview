package edu.nyu.cs.codinginterview.chapter06;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocksSolutionTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter06.LocksSolution#LocksSolution(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testLocksSolutionWithNegativeN() {
        @SuppressWarnings("unused")
        LocksSolution s = new LocksSolution(-4);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter06.LocksSolution#LocksSolution(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testLocksSolutionWithZeroN() {
        @SuppressWarnings("unused")
        LocksSolution s = new LocksSolution(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter06.LocksSolution#LocksSolution(int)}.
     */
    @Test
    public void testLocksSolution() {
        @SuppressWarnings("unused")
        LocksSolution s = new LocksSolution(5);
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter06.LocksSolution#numberOfOpens()}.
     */
    @Test
    public void testNumberOfOpens() {
        assertEquals(1, new LocksSolution(1).numberOfOpens());
        assertEquals(3, new LocksSolution(10).numberOfOpens());
        assertEquals(7, new LocksSolution(50).numberOfOpens());
        assertEquals(10, new LocksSolution(100).numberOfOpens());
        assertEquals(14, new LocksSolution(200).numberOfOpens());
    }

}
