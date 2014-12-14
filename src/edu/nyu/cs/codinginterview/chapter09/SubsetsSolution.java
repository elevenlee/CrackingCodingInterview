package edu.nyu.cs.codinginterview.chapter09;

import java.util.ArrayList;
import java.util.List;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Write a method to return all subsets of a set
 */
public class SubsetsSolution {
    
    private SubsetsSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(2^n)
     * space complexity O(2^n)
     */
    public static <T> List<T>[] subsets1(List<T> items) {
        Check.nullCheck(items, "set");
        for (T t : items) {
            Check.nullCheck(t, "set element");
        }
        
        int size = items.size();
        @SuppressWarnings("unchecked")
        List<T>[] result = (List<T>[]) new List[1 << size];
        result[0] = new ArrayList<T>();
        T item = null;
        int end = 0;
        for (int i = 0; i < size; i++) {
            item = items.get(i);
            end = 1 << i;
            for (int j = 0; j < end; j++) {
                result[j + end] = new ArrayList<T>(result[j]);
                result[j + end].add(item);
            }
        }
        return result;
    }
    
    /**
     * time complexity O(2^n)
     * space complexity O(2^n)
     */
    public static <T> List<List<T>> subsets2(List<T> items) {
        Check.nullCheck(items, "set");
        for (T t : items) {
            Check.nullCheck(t, "set element");
        }
        
        List<List<T>> result = new ArrayList<List<T>>();
        int size = 1 << items.size();
        for (int i = 0; i < size; i++) {
            result.add(convertIntToSet(i, items));
        }
        return result;
    }
    
    private static <T> List<T> convertIntToSet(int n, List<T> items) {
        List<T> result = new ArrayList<T>();
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result.add(items.get(count));
            }
            n = n >> 1;
            count++;
        }
        return result;
    }

}
