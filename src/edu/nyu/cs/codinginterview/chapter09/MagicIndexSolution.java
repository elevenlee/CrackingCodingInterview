package edu.nyu.cs.codinginterview.chapter09;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * A magic index in an array A[0...n - 1] is defined to be an index such that A[i] = i. Given a sorted array, 
 * write a method to find a magic index, if one exists, in array A.
 * <p>
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndexSolution {
    
    private MagicIndexSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(1)
     */
    public static int magicIndex1(int[] a) {
        Check.nullCheck(a, "array");
        
        return magicIndex1Helper(a, 0, a.length - 1);
    }
    
    private static int magicIndex1Helper(int[] a, int low, int high) {
        assert a != null;
        
        if (low > high) {
            return -1;
        }
        int middle = (low + high) >> 1;
        if (a[middle] == middle) {
            return middle;
        } else if (low < a[middle] || a[middle] < high) {
            int magic = magicIndex1Helper(a, low, middle - 1);
            return magic == -1 ? magicIndex1Helper(a, middle + 1, high) : magic;
        }
        return -1;
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(1)
     */
    public static int magicIndex2(int[] a) {
        Check.nullCheck(a, "array");
        
        return magicIndex2Helper(a, 0, a.length - 1);
    }
    
    private static int magicIndex2Helper(int[] a, int low, int high) {
        assert a != null;
        
        if (low > high) {
            return -1;
        }
        int middle = (low + high) >> 1;
        if (a[middle] == middle) {
            return middle;
        }
        
        int leftIndex = middle - 1 > a[middle] ? a[middle] : middle - 1;
        int leftMagic = magicIndex2Helper(a, low, leftIndex);
        if (leftMagic != -1) {
            return leftMagic;
        }
        
        int rightIndex = middle + 1 > a[middle] ? middle + 1 : a[middle];
        int rightMagic = magicIndex2Helper(a, rightIndex, high);
        return rightMagic;
    }

}
