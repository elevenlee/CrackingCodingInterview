package edu.nyu.cs.codinginterview.chapter02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PalindromeLinkedListSolutionTest {
    private List<PalindromeLinkedListSolution<Integer>> lists;
    private final int[][] items = {
            {5},
            {2, 3},
            {6, 6},
            {1, 7, 2, 5, 5, 2, 7, 1},
            {1, 6, 9, 2, 2, 1, 9, 6},
            {4, 6, 8, 2, 7, 2, 8, 6, 4},
            {4, 3, 5, 2, 7, 2, 4, 6, 4}
    };
    private final boolean[] result = {true, false, true, true, false, true, false};

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        lists = new ArrayList<PalindromeLinkedListSolution<Integer>>();
        PalindromeLinkedListSolution<Integer> list = null;
        for (int i = 0; i < items.length; i++) {
            list = new PalindromeLinkedListSolution<Integer>();
            for (int j = 0; j < items[i].length; j++) {
                list.add(items[i][j]);
            }
            lists.add(list);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PalindromeLinkedListSolution#isPalindrome1()}.
     */
    @Test
    public void testIsPalindrome1WithEmptyList() {
        PalindromeLinkedListSolution<String> list =
                new PalindromeLinkedListSolution<String>();
        assertTrue(list.isPalindrome1());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PalindromeLinkedListSolution#isPalindrome1()}.
     */
    @Test
    public void testIsPalindrome1() {
        int index = 0;
        for (PalindromeLinkedListSolution<Integer> list : lists) {
            assertEquals(result[index++], list.isPalindrome1());
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PalindromeLinkedListSolution#isPalindrome2()}.
     */
    @Test
    public void testIsPalindrome2WithEmptyList() {
        PalindromeLinkedListSolution<String> list = 
                new PalindromeLinkedListSolution<String>();
        assertTrue(list.isPalindrome2());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.PalindromeLinkedListSolution#isPalindrome2()}.
     */
    @Test
    public void testIsPalindrome2() {
        int index = 0;
        for (PalindromeLinkedListSolution<Integer> list : lists) {
            assertEquals(result[index++], list.isPalindrome2());
        }
    }

}
