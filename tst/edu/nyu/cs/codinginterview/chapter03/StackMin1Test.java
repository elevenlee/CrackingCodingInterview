package edu.nyu.cs.codinginterview.chapter03;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class StackMin1Test {
    private StackMin1<String> emptyStack;
    private StackMin1<String> notEmptyStack;
    private List<String> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        emptyStack = new StackMin1<String>();
        notEmptyStack = new StackMin1<String>();
        elements = Arrays.asList(
                "Shell", "Python", "Ruby", "Javascript",
                "SQL", "Perl", "Java", "C++",
                "C", "PHP", "HTML/CSS", "Scala");
        for (String s : elements) {
            notEmptyStack.push(s);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#StackMin1()}.
     */
    @Test
    public void testStackMin1() {
        StackMin1<String> s = new StackMin1<String>();
        assertTrue(s.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(emptyStack.isEmpty());
        assertFalse(notEmptyStack.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#min()}.
     */
    @Test
    public void testMinInEmptyStack() {
        assertTrue(emptyStack.isEmpty());
        assertEquals(null, emptyStack.min());
        assertTrue(emptyStack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#min()}.
     */
    @Test
    public void testMinInNotEmptyStack() {
        String[] results = {
                "C", "C", "C", "C",
                "C++", "Java", "Javascript", "Javascript",
                "Javascript", "Python", "Python", "Shell"
        };
        for (String s : results) {
            assertEquals(s, notEmptyStack.min());
            notEmptyStack.pop();
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#peek()}.
     */
    @Test
    public void testPeekInEmptyStack() {
        assertTrue(emptyStack.isEmpty());
        assertEquals(null, emptyStack.peek());
        assertTrue(emptyStack.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#peek()}.
     */
    @Test
    public void testPeekInNotEmptyStack() {
        assertEquals(elements.get(elements.size() - 1), notEmptyStack.peek());
        assertEquals(elements.get(elements.size() - 1), notEmptyStack.peek());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#pop()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testPopInEmptyStack() {
        emptyStack.pop();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#pop()}.
     */
    @Test
    public void testPopInNotEmptyStack() {
        for (int i = elements.size() - 1; i >= 0; i--) {
            assertEquals(elements.get(i), notEmptyStack.pop());
        }
        assertTrue(notEmptyStack.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#push(java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testPushWithNullObject() {
        notEmptyStack.push(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#push(java.lang.Comparable)}.
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
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterator() {
        Iterator<String> iter = notEmptyStack.iterator();
        int i = elements.size() - 1;
        while (iter.hasNext()) {
            assertEquals(elements.get(i), iter.next());
            i--;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterable() {
        int i = elements.size() - 1;
        for (String s : notEmptyStack) {
            assertEquals(elements.get(i), s);
            i--;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#iterator()}.
     */
    @Test
    public void testIteratorContiguousHasNext() {
        Iterator<String> iterEmpty = emptyStack.iterator();
        assertFalse(iterEmpty.hasNext());
        assertFalse(iterEmpty.hasNext());
        Iterator<String> iterNotEmpty = notEmptyStack.iterator();
        assertTrue(iterNotEmpty.hasNext());
        assertTrue(iterNotEmpty.hasNext());
        assertEquals(elements.get(elements.size() - 1), iterNotEmpty.next());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#iterator()}.
     */
    @Test
    public void testIteratorContiguousNext() {
        Iterator<String> iter = notEmptyStack.iterator();
        for (int i = elements.size() - 1; i >= 0; i--) {
            assertEquals(elements.get(i), iter.next());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorEmptyStack() {
        Iterator<String> iter = emptyStack.iterator();
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorNotEmptyStack() {
        Iterator<String> iter = notEmptyStack.iterator();
        for (int i = 0; i < elements.size(); i++) {
            iter.next();
        }
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.StackMin1#iterator()}.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Iterator<String> iter = notEmptyStack.iterator();
        iter.remove();
    }

}
