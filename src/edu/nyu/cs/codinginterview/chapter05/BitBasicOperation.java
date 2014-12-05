package edu.nyu.cs.codinginterview.chapter05;

public class BitBasicOperation {
    
    private BitBasicOperation() {
        throw new AssertionError();
    }
    
    public static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }
    
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }
    
    public static int clearBit(int num, int i) {
        return num & (~(1 << i));
    }
    
    public static int clearBitsMSBthroughI(int num, int i) {
        return num & ((1 << i) - 1);
    }
    
    public static int clearBitsIthrough0(int num, int i) {
        return num & (~((1 << (i + 1)) - 1));
    }
    
    public static int updateBit(int num, int i, int v) {
        return (num & (~(1 << i))) | (v << i);
    }
    
}
