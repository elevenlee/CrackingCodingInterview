package edu.nyu.cs.codinginterview.chapter05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberOfConvertsSolutionTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.NumberOfConvertsSolution#numberOfConverts(int, int)}.
     */
    @Test
    public void testNumberOfConverts() {
        int[] numbers1 = {0, 1, 1, 2, 21, 31, 100};
        int[] numbers2 = {0, 1, 2, 3, 10, 14,  55};
        int[] results  = {0, 0, 2, 1,  5,  2,   4};
        for (int i = 0; i < numbers1.length; i++) {
            assertEquals(
                    results[i], NumberOfConvertsSolution.numberOfConverts(
                            numbers1[i], numbers2[i]));
        }
    }

}
