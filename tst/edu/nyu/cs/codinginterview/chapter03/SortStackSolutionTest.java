package edu.nyu.cs.codinginterview.chapter03;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import edu.nyu.cs.codinginterview.util.Stack;

public class SortStackSolutionTest {
    private Stack<Integer> stack;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        stack = new Stack<Integer>();
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort1(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test(expected=NullPointerException.class)
    public void testSort1WithNullStack() {
        SortStackSolution.sort1(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort1(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort1WithEmptyStack() {
        SortStackSolution.sort1(stack);
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort1(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort1WithSingleElementStack() {
        int item = 1;
        stack.push(item);
        SortStackSolution.sort1(stack);
        assertEquals((Integer) item, stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort1(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort1WithAscendingStack() {
        int[] items = {1, 3, 4, 5, 5, 7, 9, 9, 14, 35};
        for (int i : items) {
            stack.push(i);
        }
        SortStackSolution.sort1(stack);
        for (int i = items.length - 1; i >= 0; i--) {
            assertEquals((Integer) items[i], stack.pop());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort1(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort1WithDescendingStack() {
        int[] items = {78, 50, 32, 15, 9, 6, 4, 4, 2, 2};
        for (int i : items) {
            stack.push(i);
        }
        SortStackSolution.sort1(stack);
        for (int i : items) {
            assertEquals((Integer) i, stack.pop());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort1(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort1WithRandomStack() {
        int[] items = {4, 6, 5, 3, 1, 7, 8, 2};
        for (int i : items) {
            stack.push(i);
        }
        SortStackSolution.sort1(stack);
        Arrays.sort(items);
        for (int i = items.length - 1; i >= 0; i--) {
            assertEquals((Integer) items[i], stack.pop());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort2(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test(expected=NullPointerException.class)
    public void testSort2WithNullStack() {
        SortStackSolution.sort2(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort2(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort2WithEmptyStack() {
        SortStackSolution.sort2(stack);
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort2(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort2WithSingleElementStack() {
        int item = 1;
        stack.push(item);
        SortStackSolution.sort2(stack);
        assertEquals((Integer) item, stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort2(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort2WithAscendingStack() {
        int[] items = {1, 3, 4, 5, 5, 7, 9, 9, 14, 35};
        for (int i : items) {
            stack.push(i);
        }
        SortStackSolution.sort2(stack);
        for (int i = items.length - 1; i >= 0; i--) {
            assertEquals((Integer) items[i], stack.pop());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort2(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort2WithDescendingStack() {
        int[] items = {78, 50, 32, 15, 9, 6, 4, 4, 2, 2};
        for (int i : items) {
            stack.push(i);
        }
        SortStackSolution.sort2(stack);
        for (int i : items) {
            assertEquals((Integer) i, stack.pop());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SortStackSolution#sort2(edu.nyu.cs.codinginterview.util.Stack)}.
     */
    @Test
    public void testSort2WithRandomStack() {
        int[] items = {4, 6, 5, 3, 1, 7, 8, 2};
        for (int i : items) {
            stack.push(i);
        }
        SortStackSolution.sort2(stack);
        Arrays.sort(items);
        for (int i = items.length - 1; i >= 0; i--) {
            assertEquals((Integer) items[i], stack.pop());
        }
    }

}
