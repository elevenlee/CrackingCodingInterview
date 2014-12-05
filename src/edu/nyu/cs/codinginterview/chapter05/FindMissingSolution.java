package edu.nyu.cs.codinginterview.chapter05;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * An array A contains all the integers from 0 through n, expect for one number which is missing. In this 
 * problem, we cannot access an entire integer in A with a single operation. The elements of A are represented 
 * in binary, and the only operation we can use to access them is "fetch the jth bit of A[i]", which takes 
 * constant time. Write code to find the missing integer. Can you do it in O(n) time?
 */
public class FindMissingSolution {
    
    private FindMissingSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(nlogn)
     * space complexity O(1)
     */
    public static int findMissing(int[][] a, int n) {
        Check.nullCheck(a, "array binary representation");
        if ((n <= 0) || (n != a.length + 1)) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += convertToDec(a[i]);
        }
        return n * (n + 1) / 2 - sum;
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(1)
     */
    private static int convertToDec(int[] a) {
        int num = 0;
        int pow = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            num += pow * a[i];
            pow = pow << 1;
        }
        return num;
    }
    
    /**
     * time complexity O(nlogn)
     * space complexity O(1)
     */
    public static int findMissingIterative(List<BitSet> a, int n) {
        int zeroCount = 0;
        int oneCount = 0;
        int miss = 0;
        int pow = 1;
        int size = bitSize(n);
        for (int i = 0; i < size; i++) {
            for (BitSet b : a) {
                if (b.get(i)) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            if (zeroCount > oneCount) {
                miss += pow;
            }
            pow = pow << 1;
            zeroCount = oneCount = 0;
        }
        return miss;
    }
    
    private static int bitSize(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            n = n >> 1;
            count++;
        }
        return count;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static int findMissingRecursive(List<BitSet> a, int n) {
        return findMissingHelper(a, bitSize(n) - 1);
    }
    
    private static int findMissingHelper(List<BitSet> input, int column) {
        if (column < 0) {
            return 0;
        }
        List<BitSet> oneBits = new ArrayList<BitSet>(input.size() / 2);
        List<BitSet> zeroBits = new ArrayList<BitSet>(input.size() / 2);
        for (BitSet b : input) {
            if (b.get(column)) {
                oneBits.add(b);
            } else {
                zeroBits.add(b);
            }
        }
        int v = 0;
        if (zeroBits.size() <= oneBits.size()) {
            v = findMissingHelper(zeroBits, column - 1);
            return (v << 1) | 0;
        } else {
            v = findMissingHelper(oneBits, column - 1);
            return (v << 1) | 1;
        }
    }

}
