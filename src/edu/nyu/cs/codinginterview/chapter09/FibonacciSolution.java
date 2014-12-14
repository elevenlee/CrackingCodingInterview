package edu.nyu.cs.codinginterview.chapter09;

/**
 * @author shenli
 * <p>
 * Fibonacci Numbers
 */
public class FibonacciSolution {
    
    private FibonacciSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(2^n)
     * space complexity O(1)
     */
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static long fibonacciBottomUp(int n) {
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static long fibonacciTopDown(int n) {
        long[] f = new long[n + 1];
        return fibonacciTopDownHelper(n, f);
    }
    
    private static long fibonacciTopDownHelper(int i, long[] f) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else if (f[i] != 0) {
            return f[i];
        }
        f[i] = fibonacciTopDownHelper(i - 1, f)
                + fibonacciTopDownHelper(i - 2, f);
        return f[i];
    }
    
    public static void main(String[] args) {
        System.out.println(fibonacciTopDown(50));
    }

}
