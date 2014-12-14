package edu.nyu.cs.codinginterview.chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestPeopleSolutionTest {
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.LargestPeopleSolution#largestPeople(edu.nyu.cs.codinginterview.chapter11.Person[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testLargestPeopleInNullArray() {
        LargestPeopleSolution.largestPeople(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.LargestPeopleSolution#largestPeople(edu.nyu.cs.codinginterview.chapter11.Person[])}.
     */
    @Test(expected=NullPointerException.class)
    public void testLargestPeopleWithNullPerson() {
        Person[] people = {
                new Person(65, 100), new Person(70, 150), new Person(56, 90),
                null, new Person(60, 95), new Person(68, 100)
        };
        LargestPeopleSolution.largestPeople(people);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.LargestPeopleSolution#largestPeople(edu.nyu.cs.codinginterview.chapter11.Person[])}.
     */
    @Test
    public void testLargestPeopleInEmptyArray() {
        Person[] people = {};
        assertEquals(0, LargestPeopleSolution.largestPeople(people));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.LargestPeopleSolution#largestPeople(edu.nyu.cs.codinginterview.chapter11.Person[])}.
     */
    @Test
    public void testLargestPeople1() {
        Person[] people1 = {
                new Person(65, 100), new Person(70, 150), new Person(56, 90),
                new Person(75, 190), new Person(60, 95), new Person(72, 110)
        };
        assertEquals(5, LargestPeopleSolution.largestPeople(people1));
        Person[] people2 = {
                new Person(68, 100), new Person(60, 150), new Person(75, 90),
                new Person(56, 190), new Person(70, 95), new Person(65, 110)
        };
        assertEquals(1, LargestPeopleSolution.largestPeople(people2));
    }

    /**
     * Test method for {@link edu.nyu.cs.codinginterview.chapter11.LargestPeopleSolution#largestPeople(edu.nyu.cs.codinginterview.chapter11.Person[])}.
     */
    @Test
    public void testLargestPeople2() {
        Person[] people = {
                new Person(65, 100), new Person(70, 150), new Person(56, 90),
                new Person(75, 190), new Person(60, 95), new Person(68, 110)
        };
        assertEquals(6, LargestPeopleSolution.largestPeople(people));
    }

}
