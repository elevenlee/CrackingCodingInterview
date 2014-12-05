package edu.nyu.cs.codinginterview.chapter05;

/**
 * @author shenli
 * <p>
 * Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 
 * and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on)
 */
public class SwapOddEvenBitsSolution {
    private static final int SIZE = 32;
    private static final int ODD_MASK = 0xaaaaaaaa;
    private static final int EVEN_MASK = 0x55555555;
    
    private SwapOddEvenBitsSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static int swapOddEvenBits1(int n) {
        int odd = clearBits(n, 1, 2);
        int even = clearBits(n, 0, 2);
        return (odd << 1) | (even >> 1);
    }

    private static int clearBits(int n, int start, int steps) {
        assert start >= 0;
        assert steps > 0;
        
        int result = n;
        for (int i = start; i < SIZE; i += steps) {
            result = BitBasicOperation.clearBit(result, i);
        }
        return result;
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public static int swapOddEvenBits2(int n) {
        return ((n & ODD_MASK) >> 1) | ((n & EVEN_MASK) << 1);
    }
    
}
