package edu.nyu.cs.codinginterview.vi;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompareBinAndHexSolutionTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testCompareBinAndHexWithNullStringBinary() {
        assertFalse(CompareBinAndHexSolution.compareBinAndHex(null, "12AF"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testCompareBinAndHexWithNullStringHex() {
        assertFalse(CompareBinAndHexSolution.compareBinAndHex("011101011", null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCompareBinAndHexWithEmptyStringBinary() {
        assertFalse(CompareBinAndHexSolution.compareBinAndHex("", "17BCA"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCompareBinAndHexWithEmptyStringHex() {
        assertFalse(CompareBinAndHexSolution.compareBinAndHex("011101011", ""));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCompareBinAndHexWithIllegalBinary() {
        assertFalse(CompareBinAndHexSolution.compareBinAndHex("0923111001011101", "12AF"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCompareBinAndHexWithIllegalHex() {
        assertFalse(CompareBinAndHexSolution.compareBinAndHex("10011110001", "TYR2AF"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCompareBinAndHexWithEqualNumber() {
        assertTrue(CompareBinAndHexSolution.compareBinAndHex("11000011010000010111111", "61A0BF"));
        assertTrue(CompareBinAndHexSolution.compareBinAndHex("11000011010000010111111", "61a0bf"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.vi.CompareBinAndHexSolution#compareBinAndHex(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCompareBinAndHexWithNotEqualNumber() {
        assertFalse(CompareBinAndHexSolution.compareBinAndHex("1010001110101", "12AF"));
        assertFalse(CompareBinAndHexSolution.compareBinAndHex("1010001110101", "12af"));
    }

}
