package edu.nyu.cs.codinginterview.chapter02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AddNumberSolutionTest {
    private final int[][] numbers = {
            {7, 1, 6},
            {5, 9, 2},
            {3, 1, 5, 9},
            {7, 8, 4},
            {3, 9, 8, 9, 9, 2, 8}
    };
    private List<AddNumberSolution> listNumber;
    private final int[][] results = {
            {2, 1, 9},
            {8, 0, 8, 9},
            {0, 0, 0, 0, 1},
            {0, 8, 3, 0, 0, 3, 8}
    };

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        listNumber = new ArrayList<AddNumberSolution>();
        for (int i = 0; i < numbers.length; i++) {
            listNumber.add(new AddNumberSolution(numbers[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.AddNumberSolution#add(edu.nyu.cs.codinginterview.chapter02.AddNumberSolution, edu.nyu.cs.codinginterview.chapter02.AddNumberSolution)}.
     */
    @Test(expected=NullPointerException.class)
    public void testAddAddNumberSolutionAddNumberSolutionWithNull() {
        AddNumberSolution.add(null, new AddNumberSolution());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.AddNumberSolution#add(edu.nyu.cs.codinginterview.chapter02.AddNumberSolution, edu.nyu.cs.codinginterview.chapter02.AddNumberSolution)}.
     */
    @Test
    public void testAddAddNumberSolutionAddNumberSolutionWithEmpty() {
        AddNumberSolution result = AddNumberSolution.add(
                new AddNumberSolution(), listNumber.get(0));
        int index = 0;
        for (int i : result) {
            assertEquals(numbers[0][index++], i);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter02.AddNumberSolution#add(edu.nyu.cs.codinginterview.chapter02.AddNumberSolution, edu.nyu.cs.codinginterview.chapter02.AddNumberSolution)}.
     */
    @Test
    public void testAddAddNumberSolutionAddNumberSolution() {
        AddNumberSolution result = null;
        for (int i = 0; i < listNumber.size() - 1; i++) {
            result = AddNumberSolution.add(listNumber.get(i), listNumber.get(i + 1));
            int index = 0;
            for (int n : result) {
                assertEquals(results[i][index++], n);
            }
        }
    }

}
