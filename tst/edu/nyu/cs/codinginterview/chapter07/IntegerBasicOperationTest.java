package edu.nyu.cs.codinginterview.chapter07;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerBasicOperationTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#subtract(int, int)}.
     */
    @Test
    public void testSubstractWithBothZeros() {
        assertEquals(0, IntegerBasicOperation.subtract(0, 0));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#subtract(int, int)}.
     */
    @Test
    public void testSubstractWithOneZero() {
        assertEquals(7, IntegerBasicOperation.subtract(7, 0));
        assertEquals(-12, IntegerBasicOperation.subtract(-12, 0));
        assertEquals(-9, IntegerBasicOperation.subtract(0, 9));
        assertEquals(33, IntegerBasicOperation.subtract(0, -33));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#subtract(int, int)}.
     */
    @Test
    public void testSubstractWithOneNegative() {
        assertEquals(14, IntegerBasicOperation.subtract(5, -9));
        assertEquals(-18, IntegerBasicOperation.subtract(-6, 12));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#subtract(int, int)}.
     */
    @Test
    public void testSubstractWithBothNegatives() {
        assertEquals(1, IntegerBasicOperation.subtract(-1, -2));
        assertEquals(-7, IntegerBasicOperation.subtract(-9, -2));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#subtract(int, int)}.
     */
    @Test
    public void testSubstractWithBothPositives() {
        assertEquals(38, IntegerBasicOperation.subtract(60, 22));
        assertEquals(-8, IntegerBasicOperation.subtract(14, 22));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#multiply(int, int)}.
     */
    @Test
    public void testMultiplyWithBothZero() {
        assertEquals(0, IntegerBasicOperation.multiply(0, 0));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#multiply(int, int)}.
     */
    @Test
    public void testMultiplyWithOneZero() {
        assertEquals(0, IntegerBasicOperation.multiply(5, 0));
        assertEquals(0, IntegerBasicOperation.multiply(-6, 0));
        assertEquals(0, IntegerBasicOperation.multiply(0, 99));
        assertEquals(0, IntegerBasicOperation.multiply(0, -29));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#multiply(int, int)}.
     */
    @Test
    public void testMultiplyWithOneNegative() {
        assertEquals(-30, IntegerBasicOperation.multiply(5, -6));
        assertEquals(-24, IntegerBasicOperation.multiply(-3, 8));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#multiply(int, int)}.
     */
    @Test
    public void testMultiplyWithBothNegatives() {
        assertEquals(16, IntegerBasicOperation.multiply(-8, -2));
        assertEquals(150, IntegerBasicOperation.multiply(-15, -10));
        assertEquals(25, IntegerBasicOperation.multiply(-5, -5));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#multiply(int, int)}.
     */
    @Test
    public void testMultiplyWithBothPositives() {
        assertEquals(110, IntegerBasicOperation.multiply(22, 5));
        assertEquals(144, IntegerBasicOperation.multiply(18, 8));
        assertEquals(225, IntegerBasicOperation.multiply(15, 15));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide1(int, int)}.
     */
    @Test(expected=ArithmeticException.class)
    public void testDivide1WithBothZeros() {
        IntegerBasicOperation.divide1(0, 0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide1(int, int)}.
     */
    @Test(expected=ArithmeticException.class)
    public void testDivide1WithOneZero1() {
        IntegerBasicOperation.divide1(9, 0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide1(int, int)}.
     */
    @Test
    public void testDivide1WithOneZero2() {
        assertEquals(0, IntegerBasicOperation.divide1(0, 77));
        assertEquals(0, IntegerBasicOperation.divide1(0, -15));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide1(int, int)}.
     */
    @Test
    public void testDivide1WithOneNegative() {
        assertEquals(-4, IntegerBasicOperation.divide1(-23, 5));
        assertEquals(-7, IntegerBasicOperation.divide1(-49, 7));
        assertEquals(0, IntegerBasicOperation.divide1(-8, 33));
        assertEquals(-1, IntegerBasicOperation.divide1(-10, 10));
        assertEquals(-15, IntegerBasicOperation.divide1(46, -3));
        assertEquals(-49, IntegerBasicOperation.divide1(98, -2));
        assertEquals(0, IntegerBasicOperation.divide1(12, -122));
        assertEquals(-1, IntegerBasicOperation.divide1(12, -12));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide1(int, int)}.
     */
    @Test
    public void testDivide1WithBothNegatives() {
        assertEquals(4, IntegerBasicOperation.divide1(-23, -5));
        assertEquals(7, IntegerBasicOperation.divide1(-49, -7));
        assertEquals(0, IntegerBasicOperation.divide1(-8, -33));
        assertEquals(1, IntegerBasicOperation.divide1(-10, -10));
        assertEquals(15, IntegerBasicOperation.divide1(-46, -3));
        assertEquals(49, IntegerBasicOperation.divide1(-98, -2));
        assertEquals(0, IntegerBasicOperation.divide1(-12, -122));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide1(int, int)}.
     */
    @Test
    public void testDivide1WithBothPositives() {
        assertEquals(2, IntegerBasicOperation.divide1(12, 5));
        assertEquals(13, IntegerBasicOperation.divide1(65, 5));
        assertEquals(1, IntegerBasicOperation.divide1(100, 100));
        assertEquals(0, IntegerBasicOperation.divide1(22, 90));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide2(int, int)}.
     */
    @Test(expected=ArithmeticException.class)
    public void testDivide2WithBothZeros() {
        IntegerBasicOperation.divide2(0, 0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide2(int, int)}.
     */
    @Test(expected=ArithmeticException.class)
    public void testDivide2WithOneZero1() {
        IntegerBasicOperation.divide2(9, 0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide2(int, int)}.
     */
    @Test
    public void testDivide2WithOneZero2() {
        assertEquals(0, IntegerBasicOperation.divide2(0, 77));
        assertEquals(0, IntegerBasicOperation.divide2(0, -15));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide2(int, int)}.
     */
    @Test
    public void testDivide2WithOneNegative() {
        assertEquals(-4, IntegerBasicOperation.divide2(-23, 5));
        assertEquals(-7, IntegerBasicOperation.divide2(-49, 7));
        assertEquals(0, IntegerBasicOperation.divide2(-8, 33));
        assertEquals(-1, IntegerBasicOperation.divide2(-10, 10));
        assertEquals(-15, IntegerBasicOperation.divide2(46, -3));
        assertEquals(-49, IntegerBasicOperation.divide2(98, -2));
        assertEquals(0, IntegerBasicOperation.divide2(12, -122));
        assertEquals(-1, IntegerBasicOperation.divide2(12, -12));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide2(int, int)}.
     */
    @Test
    public void testDivide2WithBothNegatives() {
        assertEquals(4, IntegerBasicOperation.divide2(-23, -5));
        assertEquals(7, IntegerBasicOperation.divide2(-49, -7));
        assertEquals(0, IntegerBasicOperation.divide2(-8, -33));
        assertEquals(1, IntegerBasicOperation.divide2(-10, -10));
        assertEquals(15, IntegerBasicOperation.divide2(-46, -3));
        assertEquals(49, IntegerBasicOperation.divide2(-98, -2));
        assertEquals(0, IntegerBasicOperation.divide2(-12, -122));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter07.IntegerBasicOperation#divide2(int, int)}.
     */
    @Test
    public void testDivide2WithBothPositives() {
        assertEquals(2, IntegerBasicOperation.divide2(12, 5));
        assertEquals(13, IntegerBasicOperation.divide2(65, 5));
        assertEquals(1, IntegerBasicOperation.divide2(100, 100));
        assertEquals(0, IntegerBasicOperation.divide2(22, 90));
    }

}
