package edu.nyu.cs.codinginterview.chapter03;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class SetsOfStacksTest {
    private static final int CAPACITY = 5;
    private SetsOfStacks<String> emptyStack;
    private SetsOfStacks<String> notEmptyStack;
    private List<String> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        emptyStack = new SetsOfStacks<String>();
        notEmptyStack = new SetsOfStacks<String>(CAPACITY);
        elements = Arrays.asList(
                "Java", "C", "C++", "Python",
                "PHP", "Javascript", "Shell", "HTML/CSS",
                "Scala", "Perl", "SQL", "Ruby");
        for (String s : elements) {
            notEmptyStack.push(s);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#SetsOfStacks()}.
     */
    @Test
    public void testSetsOfStacks() {
        SetsOfStacks<Integer> s = new SetsOfStacks<Integer>();
        assertTrue(s.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#SetsOfStacks(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetsOfStacksIntWithNegativeCapacity() {
        new SetsOfStacks<Integer>(-7);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#SetsOfStacks(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetsOfStacksIntWithZeroCapacity() {
        new SetsOfStacks<Integer>(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#SetsOfStacks(int)}.
     */
    @Test
    public void testSetsOfStacksInt() {
        SetsOfStacks<Integer> s = new SetsOfStacks<Integer>(7);
        assertTrue(s.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(emptyStack.isEmpty());
        assertFalse(notEmptyStack.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#peek()}.
     */
    @Test
    public void testPeekInEmptyStack() {
        assertTrue(emptyStack.isEmpty());
        assertEquals(null, emptyStack.peek());
        assertTrue(emptyStack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#peek()}.
     */
    @Test
    public void testPeekInNotEmptyStack() {
        assertEquals(elements.get(elements.size() - 1), notEmptyStack.peek());
        assertEquals(elements.get(elements.size() - 1), notEmptyStack.peek());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#pop()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testPopInEmptyStack() {
        emptyStack.pop();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#pop()}.
     */
    @Test
    public void testPopInNotEmptyStack() {
        for (int i = elements.size() - 1; i >= 0; i--) {
            assertEquals(elements.get(i), notEmptyStack.pop());
        }
        assertTrue(notEmptyStack.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#popAt(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testPopAtNegativeIndex() {
        notEmptyStack.popAt(-8);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#popAt(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testPopAtBigIndex() {
        notEmptyStack.popAt(CAPACITY);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#popAt(int)}.
     */
    @Test
    public void testPopAtFirstIndex() {
        for (int i = elements.size() - 1; i >= 0; i--) {
            assertEquals(elements.get(i), notEmptyStack.popAt(0));
        }
        assertTrue(notEmptyStack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#popAt(int)}.
     */
    @Test
    public void testPopAtMiddleIndex() {
        for (int i = CAPACITY * 2 - 1; i >= CAPACITY; i--) {
            assertEquals(elements.get(i), notEmptyStack.popAt(1));
            assertEquals(elements.get(elements.size() - 1), notEmptyStack.peek());
        }
        assertEquals(elements.get(CAPACITY - 1), notEmptyStack.popAt(1));
        assertFalse(notEmptyStack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#popAt(int)}.
     */
    @Test
    public void testPopAtLastIndex() {
        for (int i = CAPACITY - 1; i >= 0; i--) {
            assertEquals(elements.get(i), notEmptyStack.popAt(2));
        }
        assertEquals(elements.get(CAPACITY * 2 - 1), notEmptyStack.popAt(1));
        assertFalse(notEmptyStack.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#push(java.lang.Object)}.
     */
    @Test(expected=NullPointerException.class)
    public void testPushWithNullObject() {
        notEmptyStack.push(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#push(java.lang.Object)}.
     */
    @Test
    public void testPushWithLegalObject() {
        String s = "Vim";
        assertEquals(s, emptyStack.push(s));
        assertEquals(s, emptyStack.peek());
        assertEquals(s, notEmptyStack.push(s));
        assertEquals(s, notEmptyStack.peek());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.SetsOfStacks#push(java.lang.Object)}.
     */
    @Test
    public void testPushInNewSubStack() {
        String[] items = {
                "Vim", "Amy", "Sheldon", "Leonard"
        };
        for (String s : items) {
            assertEquals(s, notEmptyStack.push(s));
            assertEquals(s, notEmptyStack.peek());
        }
    }

}
