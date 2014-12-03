package edu.nyu.cs.codinginterview.chapter01;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateStringSolutionTest {
    private String[] s1 = {
            "waterbottle", "erbottlewat",
            "ottlewaterb", "waterbottle"
    };
    private String[] s2 = {
            "waterbottle", "retawttbole",
            "wetawerapdf", "awqopoofoaowiqkif"
    };

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.RotateStringSolution#isRotation(java.lang.String, java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testIsRotationNullString() {
        RotateStringSolution.isRotation(null, "Test");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.RotateStringSolution#isRotation(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testIsRotationEmptyString() {
        assertFalse(RotateStringSolution.isRotation("test", ""));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.RotateStringSolution#isRotation(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testIsRotationBothEmptyString() {
        assertTrue(RotateStringSolution.isRotation("", ""));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter01.RotateStringSolution#isRotation(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testIsRotation() {
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1.length; j++) {
                assertTrue(RotateStringSolution.isRotation(s1[i], s1[j]));
            }
        }
        for (int i = 0; i < s2.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                assertFalse(RotateStringSolution.isRotation(s2[i], s2[j]));
            }
        }
    }

}
