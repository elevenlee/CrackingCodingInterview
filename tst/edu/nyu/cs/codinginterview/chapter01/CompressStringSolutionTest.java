package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompressStringSolutionTest {
    private final String[] s = {
            "aabcccccaaa", "aaabcccceeeeab",
            "abcddeeacbcabb", "abcccccccccccceca"
    };
    private final String[] compressed = {
            "a2b1c5a3", "a3b1c4e4a1b1",
            "abcddeeacbcabb", "a1b1c12e1c1a1"
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.CompressStringSolution#compress(java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testCompressNullString() {
        CompressStringSolution.compress(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.CompressStringSolution#compress(java.lang.String)}.
     */
    @Test
    public void testCompressEmptyString() {
        assertEquals("", CompressStringSolution.compress(""));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.CompressStringSolution#compress(java.lang.String)}.
     */
    @Test
    public void testCompress() {
        for (int i = 0; i < s.length; i++) {
            assertEquals(compressed[i], CompressStringSolution.compress(s[i]));
        }
    }

}
