package edu.nyu.cs.codinginterview.chapter11;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B, Write a 
 * method to merge B into A in sorted order.
 */
public class MergeSortedSolution {

    private MergeSortedSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static <T extends Comparable<? super T>> void merge1(T[] a, T[] b) {
        Check.nullCheck(a, "array a");
        Check.nullCheck(b, "array b");
        
        int aSize = size(a);
        int bSize = size(b);
        if (a.length < aSize + bSize) {
            throw new IllegalArgumentException();
        }
        
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Comparable[aSize];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = a[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < tmp.length && j < bSize) {
            if (tmp[i].compareTo(b[j]) < 0) {
                a[k++] = tmp[i++];
            } else {
                a[k++] = b[j++];
            }
        }
        if (i >= tmp.length) {
            while (j < bSize) {
                a[k++] = b[j++];
            }
        } else {
            while (i < tmp.length) {
                a[k++] = tmp[i++];
            }
        }
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(1)
     */
    public static <T extends Comparable<? super T>> void merge2(T[] a, T[] b) {
        Check.nullCheck(a, "array a");
        Check.nullCheck(b, "array b");
        
        int aSize = size(a);
        int bSize = size(b);
        if (a.length < aSize + bSize) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        int j = 0;
        while (i < aSize && j < bSize) {
            if (a[i].compareTo(b[j]) > 0) {
                shift(a, i);
                a[i] = b[j++];
                aSize++;
            }
            i++;
        }
        while (j < bSize) {
            a[i++] = b[j++];
        }
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static <T extends Comparable<? super T>> void merge3(T[] a, T[] b) {
        Check.nullCheck(a, null);
        Check.nullCheck(b, null);
        
        int aSize = size(a);
        int bSize = size(b);
        if (a.length < aSize + bSize) {
            throw new IllegalArgumentException();
        }
        int mergeSize = aSize + bSize;
        int i = aSize - 1;
        int j = bSize - 1;
        int k = mergeSize - 1;
        while (i >= 0 && j >= 0) {
            if (a[i].compareTo(b[j]) > 0) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
        while (j >= 0) {
            a[k--] = b[j--];
        }
    }
    
    private static <T extends Comparable<? super T>> int size(T[] a) {
        assert a != null;
        
        int size = 0;
        while (size < a.length && a[size] != null) {
            size++;
        }
        return size;
    }
    
    private static <T extends Comparable<? super T>> void shift(T[] a, int i) {
        for (int j = a.length - 1; j > i; j--) {
            a[j] = a[j - 1];
        }
    }
    
}
