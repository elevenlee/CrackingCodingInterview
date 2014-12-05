package edu.nyu.cs.codinginterview.chapter05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConvertDoubleToBinarySolutionTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary1(double)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertDoubleToBinary1WithNegativeDouble() {
        ConvertDoubleToBinarySolution.convertDoubleToBinary1(-5.90);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary1(double)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertDoubleToBinary1WithBiggerThan1Double() {
        ConvertDoubleToBinarySolution.convertDoubleToBinary1(3.89);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary1(double)}.
     */
    @Test
    public void testConvertDoubleToBinary1MoreThan32Bits() {
        assertEquals(ConvertDoubleToBinarySolution.ERROR_MESSAGE,
                ConvertDoubleToBinarySolution.convertDoubleToBinary1(0.72));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary1(double)}.
     */
    @Test
    public void testConvertDoubleToBinary1() {
        assertEquals(".101101",
                ConvertDoubleToBinarySolution.convertDoubleToBinary1(0.703125));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary2(double)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertDoubleToBinary2WithNegativeDouble() {
        ConvertDoubleToBinarySolution.convertDoubleToBinary2(-2.111);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary2(double)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertDoubleToBinary2WithBiggerThan1Double() {
        ConvertDoubleToBinarySolution.convertDoubleToBinary2(1.99);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary2(double)}.
     */
    @Test
    public void testConvertDoubleToBinary2MoreThan32Bits() {
        assertEquals(ConvertDoubleToBinarySolution.ERROR_MESSAGE,
                ConvertDoubleToBinarySolution.convertDoubleToBinary2(0.72));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.ConvertDoubleToBinarySolution#convertDoubleToBinary2(double)}.
     */
    @Test
    public void testConvertDoubleToBinary2() {
        assertEquals(".101101",
                ConvertDoubleToBinarySolution.convertDoubleToBinary2(0.703125));
    }

}
