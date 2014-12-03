package edu.nyu.cs.codinginterview.chapter02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularLinkedListSolutionTest {
    private final Integer[] numbers = {2, 4, 5, 8, 6, 7, 1, 3};
    private CircularLinkedListSolution<Integer> integers;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        integers = new CircularLinkedListSolution<Integer>(numbers);
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.CircularLinkedListSolution#circular()}.
     */
    @Test
    public void testCircularEmptyLinkedList() {
        assertEquals(null, new CircularLinkedListSolution<String>().circular());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.CircularLinkedListSolution#circular()}.
     */
    @Test
    public void testCircularNoCycle() {
        assertEquals(null, integers.circular());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.CircularLinkedListSolution#circular()}.
     */
    @Test
    public void testCircularAtHead() {
        integers.addCircular(0);
        assertEquals(numbers[numbers.length - 1], integers.circular());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.CircularLinkedListSolution#circular()}.
     */
    @Test
    public void testCircularAtMiddle() {
        integers.addCircular(3);
        assertEquals(numbers[numbers.length - 4], integers.circular());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.CircularLinkedListSolution#circular()}.
     */
    @Test
    public void testCircularAtLast() {
        integers.addCircular(numbers.length - 1);
        assertEquals(numbers[0], integers.circular());
    }

}
