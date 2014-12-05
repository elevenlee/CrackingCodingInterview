package edu.nyu.cs.codinginterview.chapter05;

public class NumberOfConvertsSolution {
    
    private NumberOfConvertsSolution() {
        throw new AssertionError();
    }
    
    public static int numberOfConverts(int a, int b) {
        return numberOf1s(a ^ b);
    }
    
    private static int numberOf1s(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
