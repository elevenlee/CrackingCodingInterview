package edu.nyu.cs.codinginterview.chapter11;

import java.util.Arrays;
import java.util.Comparator;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * A circus is designing a tower routine consisting of people standing atop one another's shoulders. For 
 * practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or 
 * her. Given the heights and weights of each person in the circus, write a method to compute the largest
 * possible number of people in such a tower.
 */
public class LargestPeopleSolution {
    
    private LargestPeopleSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(n^2)
     */
    public static int largestPeople(Person[] items) {
        Check.nullCheck(items, "person array");
        for (Person p : items) {
            Check.nullCheck(p, "person");
        }
        
        Person[] heightOrder = copy(items);
        Arrays.sort(heightOrder, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                Check.nullCheck(o1, "person 1");
                Check.nullCheck(o2, "person 2");
                
                return Double.compare(o1.getHeight(), o2.getHeight());
            }
            
        });
        Person[] weightOrder = copy(items);
        Arrays.sort(weightOrder, new Comparator<Person>() {
            
            @Override
            public int compare(Person o1, Person o2) {
                Check.nullCheck(o1, "person 1");
                Check.nullCheck(o2, "person 2");
                
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        
        final int size = items.length + 1;
        int[][] largest = new int[size][size];
        for (int i = 0; i < size; i++) {
            largest[i][0] = 0;
        }
        for (int j = 0; j < size; j++) {
            largest[0][j] = 0;
        }
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (heightOrder[i - 1].equals(weightOrder[j - 1])) {
                    largest[i][j] = largest[i - 1][j - 1] + 1;
                } else if (largest[i - 1][j] >= largest[i][j - 1]) {
                    largest[i][j] = largest[i - 1][j];
                } else {
                    largest[i][j] = largest[i][j - 1];
                }
            }
        }
        return largest[size - 1][size - 1];
    }
    
    private static Person[] copy(Person[] items) {
        assert items != null;
        
        Person[] p = new Person[items.length];
        for (int i = 0; i < items.length; i++) {
            p[i] = items[i];
        }
        return p;
    }

}
