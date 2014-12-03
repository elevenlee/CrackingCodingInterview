package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PermutationStringSolutionTest {
    private String s1;
    private String s2;
    private String longString;
    private String notMatchString;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        s1 = "aabcccccaaa";
        s2 = "bcacacaccaa";
        longString = "abcabababcccbbababa";
        notMatchString = "aaabbbccaac";
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.PermutationStringSolution#isPermutation1(java.lang.String, java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testIsPermutation1WithNullString() {
        PermutationStringSolution.isPermutation1(null, "test");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.PermutationStringSolution#isPermutation1(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testIsPermutation1() {
        assertTrue(PermutationStringSolution.isPermutation1("", ""));
        assertTrue(PermutationStringSolution.isPermutation1(s1, s2));
        assertFalse(PermutationStringSolution.isPermutation1(s1, longString));
        assertFalse(PermutationStringSolution.isPermutation1(s2, longString));
        assertFalse(PermutationStringSolution.isPermutation1(s1, notMatchString));
        assertFalse(PermutationStringSolution.isPermutation1(s2, notMatchString));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.PermutationStringSolution#isPermutation2(java.lang.String, java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testIsPermutation2WithNullString() {
        PermutationStringSolution.isPermutation2(null, "test");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.PermutationStringSolution#isPermutation2(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testIsPermutation2() {
        assertTrue(PermutationStringSolution.isPermutation2("", ""));
        assertTrue(PermutationStringSolution.isPermutation2(s1, s2));
        assertFalse(PermutationStringSolution.isPermutation2(s1, longString));
        assertFalse(PermutationStringSolution.isPermutation2(s2, longString));
        assertFalse(PermutationStringSolution.isPermutation2(s1, notMatchString));
        assertFalse(PermutationStringSolution.isPermutation2(s2, notMatchString));
    }

}
