package edu.nyu.cs.codinginterview.chapter05;

/**
 * @author shenli
 * <p>
 * Given a positive integer, print the next smallest and the next largest number that have the same number of 
 * 1 bits in their binary representation.
 */
public class NextSameNumberOf1Solution {
    
    private NextSameNumberOf1Solution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static int nextSmallest1(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        int num = numberOf1s(n);
        for (int i = n + 1; ; i++) {
            if (num == numberOf1s(i)) {
                return i;
            }
        }
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(1)
     */
    public static int nextSmallest2(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int pos = first1s(n);
        int count = numberOfContiguous1s(n, pos + 1);
        if (pos + count == 31) {
            return -1;
        }
        int p = pos + count + 1;
        return (n | (1 << p)) & (~0 << p) | ((1 << count) - 1);
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static int nextLargest1(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        int num = numberOf1s(n);
        for (int i = n - 1; i >= 0; i--) {
            if (num == numberOf1s(i)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(1)
     */
    public static int nextLargest2(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int pos = first0s(n);
        int count = numberOfContiguous0s(n, pos + 1);
        if (pos + count == 31) {
            return -1;
        }
        int p = pos + count + 1;
        return (n & (~0 << (p + 1))) | (((1 << p) - 1) & (~0 << count));
    }
    
    private static int numberOf1s(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    
    private static int first1s(int n) {
        int i = 0;
        while (!BitBasicOperation.getBit(n, i)) {
            i++;
        }
        return i;
    }
    
    private static int first0s(int n) {
        int i = 0;
        while (BitBasicOperation.getBit(n, i)) {
            i++;
        }
        return i;
    }
    
    private static int numberOfContiguous1s(int n, int start) {
        int count = 0;
        int i = start;
        while (BitBasicOperation.getBit(n, i)) {
            count++;
            i++;
        }
        return count;
    }
    
    private static int numberOfContiguous0s(int n, int start) {
        int count = 0;
        int i = start;
        while (!BitBasicOperation.getBit(n, i)) {
            count++;
            i++;
        }
        return count;
    }

}
