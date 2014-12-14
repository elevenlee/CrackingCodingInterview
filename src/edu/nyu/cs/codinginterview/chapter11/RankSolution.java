package edu.nyu.cs.codinginterview.chapter11;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of 
 * a number x (the number of values less than or equal to x). implement the data structure and algorithms to 
 * support these operations. That is, implement the method track(int x), which is called when each number is 
 * generated, and the method getRankOfNumber(int x), which returns the number of values less than or equal to 
 * x (not including x itself)
 */
public class RankSolution {
    
    private RankSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(klogn)
     * space complexity O(1)
     */
    public static <T extends Comparable<? super T>> int getRank(T[] a, T key) {
        Check.nullCheck(a, "array");
        if (key == null || a.length <= 0) {
            return -1;
        }
        
        T[] tmp = copy(a);
        int heapSize = buildMaxHeap(tmp);
        int i = tmp.length - 1;
        while (i >= 0 && key.compareTo(tmp[0]) < 0) {
            exchange(tmp, 0, i--);
            heapSize--;
            maxHeapify(tmp, 0, heapSize);
        }
        return key.compareTo(tmp[0]) == 0 ? heapSize - 1 : -1;
    }
    
    private static <T extends Comparable<? super T>> int buildMaxHeap(T[] a) {
        int heapSize = a.length;
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
        return heapSize;
    }
    
    private static <T extends Comparable<? super T>> void maxHeapify(T[] a, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < heapSize && a[left].compareTo(a[largest]) > 0) {
            largest = left;
        }
        if (right < heapSize && a[right].compareTo(a[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            exchange(a, largest, i);
            maxHeapify(a, largest, heapSize);
        }
    }
    
    private static <T extends Comparable<? super T>> T[] copy(T[] a) {
        assert a != null;
        
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        return result;
    }
    
    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
