package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniqueCharactersSolutionTest {
    private String s1;
    private String s2;
    private String s3;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            sb.append(i);
        }
        s1 = sb.toString();
        s2 = "qwerafsysiodpspskskdkjcmdkoiwoswkmskiwiw2817382929$&^%*&*(ajlfelwreowo";
        s3 = "zpxocivubyntmr,e.w/qa's;dlfkgjh`=1-203948576";
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacter1(java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testIsUniqueCharacter1WithNullString() {
        UniqueCharactersSolution.isUniqueCharacter1(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacter1(java.lang.String)}.
     */
    @Test
    public void testIsUniqueCharacter1() {
        assertTrue(UniqueCharactersSolution.isUniqueCharacter1(""));
        assertFalse(UniqueCharactersSolution.isUniqueCharacter1(s1));
        assertFalse(UniqueCharactersSolution.isUniqueCharacter1(s2));
        assertTrue(UniqueCharactersSolution.isUniqueCharacter1(s3));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacters2(java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testIsUniqueCharacters2WithNullString() {
        UniqueCharactersSolution.isUniqueCharacter2(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacters2(java.lang.String)}.
     */
    @Test
    public void testIsUniqueCharacters2() {
        assertTrue(UniqueCharactersSolution.isUniqueCharacter2(""));
        assertFalse(UniqueCharactersSolution.isUniqueCharacter2(s1));
        assertFalse(UniqueCharactersSolution.isUniqueCharacter2(s2));
        assertTrue(UniqueCharactersSolution.isUniqueCharacter2(s3));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacters3(java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testIsUniqueCharacters3WithNullObject() {
        UniqueCharactersSolution.isUniqueCharacter3(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacters3(java.lang.String)}.
     */
    @Test
    public void testIsUniqueCharacters3() {
        assertTrue(UniqueCharactersSolution.isUniqueCharacter3(""));
        assertFalse(UniqueCharactersSolution.isUniqueCharacter3(s1));
        assertFalse(UniqueCharactersSolution.isUniqueCharacter3(s2));
        assertTrue(UniqueCharactersSolution.isUniqueCharacter3(s3));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacters4(java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testIsUniqueCharacters4WithNullString() {
        UniqueCharactersSolution.isUniqueCharacter3(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.UniqueCharactersSolution#isUniqueCharacters4(java.lang.String)}.
     */
    @Test
    public void testIsUniqueCharacters4() {
//      assertTrue(UniqueCharactersSolution.isUniqueCharacter4(""));
//      assertFalse(UniqueCharactersSolution.isUniqueCharacter4(s1));
//      assertFalse(UniqueCharactersSolution.isUniqueCharacter4(s2));
//      assertTrue(UniqueCharactersSolution.isUniqueCharacter4(s3));
    }

}
