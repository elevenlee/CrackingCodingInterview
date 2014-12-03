package edu.nyu.cs.codinginterview.chapter02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicateLinkedListSolutionTest {
    private RemoveDuplicateLinkedListSolution<String> listString;
    private RemoveDuplicateLinkedListSolution<Integer> listInteger;
    private RemoveDuplicateLinkedListSolution<Boolean> listBoolean;
    private final String[] resultString = {"F", "O", "L", "W", " ", "U", "P"};
    private final Integer[] resultInteger = {6, 5, 0, 2, 4, 1};
    private final Boolean[] resultBoolean = {false, true};

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        String[] s = {"P", "U", " ", "W", "O", "L", "L", "O", "F"};
        listString = new RemoveDuplicateLinkedListSolution<String>(s);
        Integer[] i = {1, 6, 4, 6, 6, 2, 0, 5, 6, 6, 6};
        listInteger = new RemoveDuplicateLinkedListSolution<Integer>(i);
        Boolean[] b = {true, false, false, true, false, false, true, true, true, false};
        listBoolean = new RemoveDuplicateLinkedListSolution<Boolean>(b);
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.RemoveDuplicateLinkedListSolution#removeDuplicates1()}.
     */
    @Test
    public void testRemoveDuplicates1WithEmptyList() {
        RemoveDuplicateLinkedListSolution<String> l =
                new RemoveDuplicateLinkedListSolution<String>();
        l.removeDuplicates1();
        assertEquals(0, l.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.RemoveDuplicateLinkedListSolution#removeDuplicates1()}.
     */
    @Test
    public void testRemoveDuplicates1WithNoDuplicate() {
        Integer[] i = {1, 2, 3, 4, 5, 6, 7, 8};
        RemoveDuplicateLinkedListSolution<Integer> l =
                new RemoveDuplicateLinkedListSolution<Integer>(i);
        l.removeDuplicates1();
        assertEquals(i.length, l.size());
        Integer[] expect = {8, 7, 6, 5, 4, 3, 2, 1};
        int index = 0;
        for (Integer integer : l) {
            assertEquals(expect[index++], integer);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.RemoveDuplicateLinkedListSolution#removeDuplicates1()}.
     */
    @Test
    public void testRemoveDuplicates1() {
        listString.removeDuplicates1();
        assertEquals(resultString.length, listString.size());
        int index = 0;
        for (String s : listString) {
            assertEquals(resultString[index++], s);
        }
        
        listInteger.removeDuplicates1();
        assertEquals(resultInteger.length, listInteger.size());
        index = 0;
        for (Integer i : listInteger) {
            assertEquals(resultInteger[index++], i);
        }
        
        listBoolean.removeDuplicates1();
        assertEquals(resultBoolean.length, listBoolean.size());
        index = 0;
        for (Boolean b : listBoolean) {
            assertEquals(resultBoolean[index++], b);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.RemoveDuplicateLinkedListSolution#removeDuplicates2()}.
     */
    @Test
    public void testRemoveDuplicates2WithEmptyList() {
        RemoveDuplicateLinkedListSolution<String> l =
                new RemoveDuplicateLinkedListSolution<String>();
        l.removeDuplicates2();
        assertEquals(0, l.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.RemoveDuplicateLinkedListSolution#removeDuplicates2()}.
     */
    @Test
    public void testRemoveDuplicates2WithNoDuplicate() {
        Integer[] i = {1, 2, 3, 4, 5, 6, 7, 8};
        RemoveDuplicateLinkedListSolution<Integer> l =
                new RemoveDuplicateLinkedListSolution<Integer>(i);
        l.removeDuplicates2();
        assertEquals(i.length, l.size());
        Integer[] expect = {8, 7, 6, 5, 4, 3, 2, 1};
        int index = 0;
        for (Integer integer : l) {
            assertEquals(expect[index++], integer);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.RemoveDuplicateLinkedListSolution#removeDuplicates2()}.
     */
    @Test
    public void testRemoveDuplicates2() {
        listString.removeDuplicates2();
        assertEquals(resultString.length, listString.size());
        int index = 0;
        for (String s : listString) {
            assertEquals(resultString[index++], s);
        }
        
        listInteger.removeDuplicates2();
        assertEquals(resultInteger.length, listInteger.size());
        index = 0;
        for (Integer i : listInteger) {
            assertEquals(resultInteger[index++], i);
        }
        
        listBoolean.removeDuplicates2();
        assertEquals(resultBoolean.length, listBoolean.size());
        index = 0;
        for (Boolean b : listBoolean) {
            assertEquals(resultBoolean[index++], b);
        }
    }

}
