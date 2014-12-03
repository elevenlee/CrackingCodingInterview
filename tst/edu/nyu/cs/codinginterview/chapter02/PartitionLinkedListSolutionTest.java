package edu.nyu.cs.codinginterview.chapter02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitionLinkedListSolutionTest {
    private PartitionLinkedListSolution<Integer> integers;
    private final Integer[] i = {2, 8, 7, 1, 3, 5, 6, 4};

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        integers = new PartitionLinkedListSolution<Integer>(i);
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PartitionLinkedListSolution#partition(java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testPartitionWithNullValue() {
        integers.partition(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PartitionLinkedListSolution#partition(java.lang.Comparable)}.
     */
    @Test
    public void testPartitionWithSmallValue() {
        integers.partition(0);
        int index = i.length - 1;
        for (Integer integer : integers) {
            assertEquals(i[index--], integer);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PartitionLinkedListSolution#partition(java.lang.Comparable)}.
     */
    @Test
    public void testPartitionWithBigValue() {
        integers.partition(20);
        int index = i.length - 1;
        for (Integer integer : integers) {
            assertEquals(i[index--], integer);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PartitionLinkedListSolution#partition(java.lang.Comparable)}.
     */
    @Test
    public void testPartitionWithMiddleValue1() {
        integers.partition(1);
        int index = i.length - 1;
        for (Integer integer : integers) {
            assertEquals(i[index--], integer);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PartitionLinkedListSolution#partition(java.lang.Comparable)}.
     */
    @Test
    public void testPartitionWithMiddleValue2() {
        Integer[] result = {4, 6, 5, 3, 1, 7, 2, 8};
        integers.partition(8);
        int index = 0;
        for (Integer integer : integers) {
            assertEquals(result[index++], integer);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PartitionLinkedListSolution#partition(java.lang.Comparable)}.
     */
    @Test
    public void testPartitionWithMiddleValue3() {
        Integer[] result = {4, 3, 1, 2, 5, 7, 8, 6};
        integers.partition(5);
        int index = 0;
        for (Integer integer : integers) {
            assertEquals(result[index++], integer);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PartitionLinkedListSolution#partition(java.lang.Comparable)}.
     */
    @Test
    public void testPartitionWithMiddleValue4() {
        Integer[] result = {1, 6, 5, 3, 4, 7, 8, 2};
        integers.partition(2);
        int index = 0;
        for (Integer integer : integers) {
            assertEquals(result[index++], integer);
        }
    }

}
