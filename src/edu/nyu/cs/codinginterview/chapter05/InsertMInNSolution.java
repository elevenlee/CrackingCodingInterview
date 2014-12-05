package edu.nyu.cs.codinginterview.chapter05;

/**
 * @author shenli
 * <p>
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into 
 * N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space 
 * to fit all of M. That is, if M = 10011, you can assume that there are at least 5 bits between j and i. You 
 * would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 */
public class InsertMInNSolution {
    
    private InsertMInNSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(logn)
     */
    public static int insertAtPosition1(int n, int m, int i, int j) {
        if (i < 0 || j < 0 || i > 32 || j > 32) {
            throw new IllegalArgumentException();
        }
        
        int[] mBits = new int[32];
        int size = convertNumberIntoBits(m, mBits);
        if (j - i + 1 < size) {
            throw new IllegalArgumentException();
        }
        int result = n;
        for (int index = i, pos = 0; index <= j; index++, pos++) {
            result = BitBasicOperation.updateBit(result, index, mBits[pos]);
        }
        return result;
    }
    
    private static int convertNumberIntoBits(int m, int[] mBits) {
        int index = 0;
        while (m != 0) {
            mBits[index++] = m % 2;
            m = m >> 1;
        }
        return index;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static int insertAtPosition2(int n, int m, int i, int j) {
        if (i < 0 || j < 0 || i > 32 || j > 32 || i > j) {
            throw new IllegalArgumentException();
        }
        
        int mask = (~0 << (j + 1)) | ((1 << i) - 1);
        int nLeft = n & mask;
        int mShift = m << i;
        return nLeft | mShift;
    }

}
