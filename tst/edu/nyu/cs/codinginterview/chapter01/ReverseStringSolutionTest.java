package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReverseStringSolutionTest {
    private String s;
    private String result;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        s = "asdfghjkl;'";
        result = "';lkjhgfdsa";
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.ReverseStringSolution#reverse(char[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testReverseWithNullString() {
        ReverseStringSolution.reverse(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.ReverseStringSolution#reverse(char[])}.
     */
    @Test
    public void testReverse() {
        char[] chars = s.toCharArray();
        ReverseStringSolution.reverse(chars);
        char[] expect = result.toCharArray();
        for (int i = 0; i < expect.length; i++) {
            assertEquals(expect[i], chars[i]);
        }
    }

}
