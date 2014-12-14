package edu.nyu.cs.codinginterview.chapter14;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class CircularArrayTest {
    private static final int SIZE = 12;
    private CircularArray<String> circularArray;
    private final String[] items = {
            "Amy", "Sheldon", "Howard", "Leonard",
            "Penny", "Rajesh", "Eleven", "Lucy",
            "Circle", "Amazon", "Google", "Facebook"};

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        circularArray = new CircularArray<String>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            circularArray.set(i, items[i]);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#CircularArray(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCircularArrayWithNegativeSize() {
        @SuppressWarnings("unused")
        CircularArray<Integer> circularArray = new CircularArray<Integer>(-5);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#CircularArray(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCircularArrayWithZeroSize() {
        @SuppressWarnings("unused")
        CircularArray<Boolean> circularArray = new CircularArray<Boolean>(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#CircularArray(int)}.
     */
    @Test
    public void testCircularArray() {
        @SuppressWarnings("unused")
        CircularArray<Double> circularArray = new CircularArray<Double>(8);
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#get(int)}.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetAtNegativeIndex() {
        circularArray.get(-4);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#get(int)}.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetAtOutOfBoundsIndex() {
        circularArray.get(SIZE + 12);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#get(int)}.
     */
    @Test
    public void testGetAtLegalIndex() {
        for (int i = 0; i < SIZE; i++) {
            assertEquals(items[i], circularArray.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#get(int)}.
     */
    @Test
    public void testGetAfterRotate() {
        int shift = 5;
        circularArray.rotate(shift);
        for (int i = 0; i < SIZE; i++) {
            assertEquals(items[(i + shift) % items.length], circularArray.get(i));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#set(int, java.lang.Object)}.
     */
    @Test
    public void testSetWithNullItem() {
        assertFalse(circularArray.set(4, null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#set(int, java.lang.Object)}.
     */
    @Test
    public void testSetAtNegativeIndex() {
        String s = "Bernie";
        int index = -3;
        assertTrue(circularArray.set(index, s));
        assertEquals(s, circularArray.get(index + SIZE));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#set(int, java.lang.Object)}.
     */
    @Test
    public void testSetAtOutOfBoundsIndex() {
        String s = "Bernie";
        int index = 20;
        assertTrue(circularArray.set(index, s));
        assertEquals(s, circularArray.get(index - SIZE));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#set(int, java.lang.Object)}.
     */
    @Test
    public void testSetAtRegularIndex() {
        String s = "Bernie";
        int index = 8;
        assertTrue(circularArray.set(index, s));
        assertEquals(s, circularArray.get(index));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#set(int, java.lang.Object)}.
     */
    @Test
    public void testSetAfterRotate() {
        String s = "Bernie";
        int shift = 9;
        int index = 5;
        circularArray.rotate(shift);
        assertTrue(circularArray.set(index, s));
        assertEquals(s, circularArray.get(index));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#rotate(int)}.
     */
    @Test
    public void testRotateWithNegativeShift() {
        int shift = -6;
        circularArray.rotate(shift);
        for (int i = 0; i < SIZE; i++) {
            assertEquals(items[(i + shift + SIZE) % SIZE], circularArray.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#rotate(int)}.
     */
    @Test
    public void testRotateWithZeroShift() {
        int shift = 0;
        circularArray.rotate(shift);
        for (int i = 0; i < SIZE; i++) {
            assertEquals(items[i], circularArray.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#rotate(int)}.
     */
    @Test
    public void testRotateWithPositiveShift() {
        int shift = 3;
        circularArray.rotate(shift);
        for (int i = 0; i < SIZE; i++) {
            assertEquals(items[(i + shift) % SIZE], circularArray.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#rotate(int)}.
     */
    @Test
    public void testRotateWithOutOfBoundsShift() {
        int shift = 16;
        circularArray.rotate(shift);
        for (int i = 0; i < SIZE; i++) {
            assertEquals(items[(i + shift) % SIZE], circularArray.get(i));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterator() {
        Iterator<String> iter = circularArray.iterator();
        int i = 0;
        while (iter.hasNext()) {
            assertEquals(items[i++], iter.next());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterable() {
        int i = 0;
        for (String s : circularArray) {
            assertEquals(items[i++], s);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#iterator()}.
     */
    @Test
    public void testIteratorHappyPathAfterRotate() {
        int shift = 10;
        circularArray.rotate(shift);
        int i = 0;
        for (String s : circularArray) {
            assertEquals(items[(shift + i) % SIZE], s);
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#iterator()}.
     */
    @Test
    public void testIteratorContiguousHasNext() {
        Iterator<String> iter = circularArray.iterator();
        assertTrue(iter.hasNext());
        assertTrue(iter.hasNext());
        assertTrue(iter.hasNext());
        assertEquals(items[0], iter.next());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#iterator()}.
     */
    @Test
    public void testIteratorContiguousNext() {
        Iterator<String> iter = circularArray.iterator();
        for (int i = 0; i < SIZE; i++) {
            assertEquals(items[i], iter.next());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorOutOfBounds() {
        Iterator<String> iter = circularArray.iterator();
        while (true) {
            iter.next();
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter14.CircularArray#iterator()}.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Iterator<String> iter = circularArray.iterator();
        iter.remove();
    }

}
