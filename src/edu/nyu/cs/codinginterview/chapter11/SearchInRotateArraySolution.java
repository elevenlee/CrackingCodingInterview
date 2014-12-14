package edu.nyu.cs.codinginterview.chapter11;

/**
 * @author shenli
 * <p>
 * Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an 
 * element in the array. You may assume that the array was originally sorted in increasing order.
 */
public class SearchInRotateArraySolution {
    
    private SearchInRotateArraySolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(nlogn)
     * space complexity O(1)
     */
    public static <T extends Comparable<? super T>> int binarySerach(T[] a, T key) {
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (key.compareTo(a[middle]) == 0) {
                return middle;
            }
            if (a[low].compareTo(a[middle]) <= 0) { // left is normally ordered
                if (a[low].compareTo(key) <= 0 && key.compareTo(a[middle]) < 0) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else if (a[low].compareTo(a[middle]) > 0) {   // right is normally ordered
                if (a[middle].compareTo(key) < 0 && key.compareTo(a[high]) <= 0) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

}
