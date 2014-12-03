package edu.nyu.cs.codinginterview.chapter03;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class MyQueue1Test {
    private MyQueue1<String> emptyQueue;
    private MyQueue1<String> notEmptyQueue;
    private List<String> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        emptyQueue = new MyQueue1<String>();
        notEmptyQueue = new MyQueue1<String>();
        elements = Arrays.asList(
                "Java", "C", "C++", "Python",
                "PHP", "Javascript", "Shell", "HTML/CSS",
                "Scala", "Perl", "SQL", "Ruby");
        for (String s : elements) {
            notEmptyQueue.enQueue(s);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#MyQueue()}.
     */
    @Test
    public void testMyQueue() {
        MyQueue1<String> q = new MyQueue1<String>();
        assertTrue(q.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#deQueue()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testDeQueueInEmptyQueue() {
        emptyQueue.deQueue();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#deQueue()}.
     */
    @Test
    public void testDeQueueInNotEmptyQueue() {
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(elements.get(i), notEmptyQueue.deQueue());
        }
        assertTrue(notEmptyQueue.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#enQueue(java.lang.Object)}.
     */
    @Test
    public void testEnQueueWithNullObject() {
        assertFalse(emptyQueue.enQueue(null));
        assertFalse(notEmptyQueue.enQueue(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#enQueue(java.lang.Object)}.
     */
    @Test
    public void testEnQueueWithLegalObject() {
        String s = "Vim";
        assertTrue(emptyQueue.enQueue(s));
        assertEquals(1, emptyQueue.size());
        assertEquals(s, emptyQueue.peek());
        int length = notEmptyQueue.size();
        assertTrue(notEmptyQueue.enQueue(s));
        assertEquals(length + 1, notEmptyQueue.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#enQueue(java.lang.Object)}.
     */
    @Test
    public void testEnQueueDeQueue() {
        String[] items = {
                "Java", "C", "C++", "Python",
                "PHP", "Javascript", "Shell", "HTML/CSS",
                "Scala", "Perl", "SQL", "Ruby"
        };
        MyQueue1<String> queue = new MyQueue1<String>();
        assertTrue(queue.isEmpty());
        int pos = 4;
        for (int i = 0; i < pos; i++) {
            assertTrue(queue.enQueue(items[i]));
        }
        assertEquals(pos, queue.size());
        for (int i = 0; i < pos / 2; i++) {
            assertEquals(items[i], queue.deQueue());
        }
        assertEquals(pos - pos / 2, queue.size());
        for (int i = pos; i < items.length; i++) {
            assertTrue(queue.enQueue(items[i]));
        }
        assertEquals(items.length - pos / 2, queue.size());
        for (int i = pos / 2; i < items.length; i++) {
            assertEquals(items[i], queue.deQueue());
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(emptyQueue.isEmpty());
        assertFalse(notEmptyQueue.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#peek()}.
     */
    @Test
    public void testPeekInEmptyQueue() {
        assertTrue(emptyQueue.isEmpty());
        assertEquals(null, emptyQueue.peek());
        assertTrue(emptyQueue.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#peek()}.
     */
    @Test
    public void testPeekInNotEmptyQueue() {
        assertEquals(elements.get(0), notEmptyQueue.peek());
        assertEquals(elements.get(0), notEmptyQueue.peek());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter03.MyQueue1#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(0, emptyQueue.size());
        assertEquals(elements.size(), notEmptyQueue.size());
    }

}
