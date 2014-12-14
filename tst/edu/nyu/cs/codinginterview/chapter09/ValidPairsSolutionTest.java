package edu.nyu.cs.codinginterview.chapter09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ValidPairsSolutionTest {

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.ValidPairsSolution#generateParens1(int)}.
     */
    @Test
    public void testGenerateParens1() {
        Set<String> result = new HashSet<String>();
        result.add("((()))");
        result.add("(()())");
        result.add("(())()");
        result.add("()(())");
        result.add("()()()");
        assertEquals(result, ValidPairsSolution.generateParens1(3));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter09.ValidPairsSolution#generateParens2(int)}.
     */
    @Test
    public void testGenerateParens2() {
        List<String> result = new ArrayList<String>();
        result.add("((()))");
        result.add("(()())");
        result.add("(())()");
        result.add("()(())");
        result.add("()()()");
        assertEquals(result, ValidPairsSolution.generateParens2(3));
    }

}
