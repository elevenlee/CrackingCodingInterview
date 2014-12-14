package edu.nyu.cs.codinginterview.chapter09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubsetsSolutionTest {
    private final List<Integer> items = Arrays.asList(1, 2, 3);

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.SubsetsSolution#subsets1(java.util.List)}.
     */
    @Test
    public void testSubsets1() {
        @SuppressWarnings("unchecked")
        List<Integer>[] result = (List<Integer>[]) new List[8];
        for (int i = 0; i < result.length; i++) {
            result[i] = new ArrayList<Integer>();
        }
        result[1].add(1);
        result[2].add(2);
        result[3].add(1);
        result[3].add(2);
        result[4].add(3);
        result[5].add(1);
        result[5].add(3);
        result[6].add(2);
        result[6].add(3);
        result[7].add(1);
        result[7].add(2);
        result[7].add(3);
        
        List<Integer>[] subsets = SubsetsSolution.subsets1(items);
        List<Integer> actual = null;
        List<Integer> expect = null;
        for (int i = 0; i < result.length; i++) {
            actual = subsets[i];
            expect = result[i];
            for (int j = 0; j < expect.size(); j++) {
                assertEquals(expect.get(j), actual.get(j));
            }
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.SubsetsSolution#subsets2(java.util.List)}.
     */
    @Test
    public void testSubsets2() {
        @SuppressWarnings("unchecked")
        List<Integer>[] result = (List<Integer>[]) new List[8];
        for (int i = 0; i < result.length; i++) {
            result[i] = new ArrayList<Integer>();
        }
        result[1].add(1);
        result[2].add(2);
        result[3].add(1);
        result[3].add(2);
        result[4].add(3);
        result[5].add(1);
        result[5].add(3);
        result[6].add(2);
        result[6].add(3);
        result[7].add(1);
        result[7].add(2);
        result[7].add(3);
        
        List<List<Integer>> subsets = SubsetsSolution.subsets2(items);
        List<Integer> actual = null;
        List<Integer> expect = null;
        for (int i = 0; i < result.length; i++) {
            actual = subsets.get(i);
            expect = result[i];
            for (int j = 0; j < expect.size(); j++) {
                assertEquals(expect.get(j), actual.get(j));
            }
        }
    }

}
