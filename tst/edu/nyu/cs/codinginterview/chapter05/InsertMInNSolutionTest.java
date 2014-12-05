package edu.nyu.cs.codinginterview.chapter05;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertMInNSolutionTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition1AtNegativeIPosition() {
        InsertMInNSolution.insertAtPosition1(999, 12, -8, 9);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition1AtNegativeJPosition() {
        InsertMInNSolution.insertAtPosition1(123, 9, 2, -9);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition1AtIBiggerThan32Position() {
        InsertMInNSolution.insertAtPosition1(123, 9, 40, 2);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition1AtJBiggerThan32Position() {
        InsertMInNSolution.insertAtPosition1(123, 9, 4, 52);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition1IBiggerThanJPosition() {
        InsertMInNSolution.insertAtPosition1(123, 9, 2, 1);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition1CouldNotFullyFit() {
        InsertMInNSolution.insertAtPosition1(12345, 19, 2, 5);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test
    public void testInsertAtPosition1AtLongPosition() {
        assertEquals(1100, InsertMInNSolution.insertAtPosition1(1024, 19, 2, 9));
        assertEquals(1100, InsertMInNSolution.insertAtPosition1(1116, 19, 2, 9));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition1(int, int, int, int)}.
     */
    @Test
    public void testInsertAtPosition1() {
        assertEquals(1216, InsertMInNSolution.insertAtPosition1(1024, 19, 6, 10));
        assertEquals(4864, InsertMInNSolution.insertAtPosition1(1024, 19, 8, 12));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition2(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition2AtNegativeIPosition() {
        InsertMInNSolution.insertAtPosition2(999, 12, -8, 9);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition2(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition2AtNegativeJPosition() {
        InsertMInNSolution.insertAtPosition2(123, 9, 2, -9);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition2(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition2AtIBiggerThan32Position() {
        InsertMInNSolution.insertAtPosition2(123, 9, 40, 2);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition2(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition2AtJBiggerThan32Position() {
        InsertMInNSolution.insertAtPosition2(123, 9, 4, 52);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition2(int, int, int, int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInsertAtPosition2IBiggerThanJPosition() {
        InsertMInNSolution.insertAtPosition2(123, 9, 2, 1);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition2(int, int, int, int)}.
     */
    @Test
    public void testInsertAtPosition2AtLongPosition() {
        assertEquals(1100, InsertMInNSolution.insertAtPosition2(1024, 19, 2, 9));
        assertEquals(1100, InsertMInNSolution.insertAtPosition2(1116, 19, 2, 9));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter05.InsertMInNSolutionTest#insertAtPosition2(int, int, int, int)}.
     */
    @Test
    public void testInsertAtPosition2() {
        assertEquals(1216, InsertMInNSolution.insertAtPosition2(1024, 19, 6, 10));
        assertEquals(4864, InsertMInNSolution.insertAtPosition2(1024, 19, 8, 12));
    }

}
