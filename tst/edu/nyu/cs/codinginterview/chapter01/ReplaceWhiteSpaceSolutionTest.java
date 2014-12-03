package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReplaceWhiteSpaceSolutionTest {
    private String noFrontAndBackSpaceString;
    private String noFrontSpaceString;
    private String noBackSpaceString;
    private String frontAndBackSpaceString;
    private String result;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        noFrontAndBackSpaceString = "Mr John Smith";
        noFrontSpaceString = "Mr John Smith    ";
        noBackSpaceString = "   Mr John Smith";
        frontAndBackSpaceString = "      Mr John Smith ";
        result = "Mr%20John%20Smith";
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.ReplaceWhiteSpaceSolution#replaceWhiteSpace(char[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testReplaceWhiteSpaceCharArrayWithNullCharArray() {
        ReplaceWhiteSpaceSolution.replaceWhiteSpace((char[]) null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.ReplaceWhiteSpaceSolution#replaceWhiteSpace(char[])}.
     */
    @Test
    public void testReplaceWhiteSpaceCharArray() {
        
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.ReplaceWhiteSpaceSolution#replaceWhiteSpace(java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testReplaceWhiteSpaceStringWithNullString() {
        ReplaceWhiteSpaceSolution.replaceWhiteSpace((String) null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.ReplaceWhiteSpaceSolution#replaceWhiteSpace(java.lang.String)}.
     */
    @Test
    public void testReplaceWhiteSpaceString() {
        assertEquals(result, ReplaceWhiteSpaceSolution.replaceWhiteSpace(
                noFrontAndBackSpaceString));
        assertEquals(result, ReplaceWhiteSpaceSolution.replaceWhiteSpace(
                noFrontSpaceString));
        assertEquals(result, ReplaceWhiteSpaceSolution.replaceWhiteSpace(
                noBackSpaceString));
        assertEquals(result, ReplaceWhiteSpaceSolution.replaceWhiteSpace(
                frontAndBackSpaceString));
    }

}
