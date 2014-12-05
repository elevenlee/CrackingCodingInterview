package edu.nyu.cs.codinginterview.chapter04;

import edu.nyu.cs.codinginterview.util.BST;
import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Given a sorted (increasing order) array, write an algorithm to create a binary search tree with minimal height.
 */
public class MinHeightBSTSolution {
    
    private MinHeightBSTSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static <T extends Comparable<? super T>> BST<T> minHeight(T[] a) {
        Check.nullCheck(a, "item array");
        for (T item : a) {
            Check.nullCheck(item, "item");
        }
        
        BST<T> bst = new BST<T>();
        minHeightHelper(bst, a, 0, a.length - 1);
        return bst;
    }
    
    private static <T extends Comparable<? super T>> void minHeightHelper(
            BST<T> bst, T[] a, int low, int high) {
        if (low > high) {
            return;
        }
        int middle = (low + high) >> 1;
        bst.add(a[middle]);
        minHeightHelper(bst, a, low, middle - 1);
        minHeightHelper(bst, a, middle + 1, high);
    }

}
