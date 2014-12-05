package edu.nyu.cs.codinginterview.chapter07;

/**
 * @author shenli
 * <p>
 * Write methods to implement the multiply, subtract,and divide operations for integers. Use only the add 
 * operator.
 */
public class IntegerBasicOperation {
    
    private IntegerBasicOperation() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public static int subtract(int a, int b) {
        return a + negate(b);
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);      // algorithm is faster if b < a
        }
        int sum = 0;
        for (int i = 0; i < abs(b); i++) {
            sum += a;
        }
        return b > 0 ? sum : negate(sum);
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static int divide1(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        int res = 0;
        int d1 = abs(a);
        int d2 = abs(b);
        while (d1 + negate(d2) >= 0) {
            res++;
            d1 = d1 + negate(d2);
        }
        return ((a > 0 && b > 0 || (a < 0 && b < 0))) ? res : negate(res);
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static int divide2(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        int res = 0;
        int sum = 0;
        int d1 = abs(a);
        int d2 = abs(b);
        while (sum + d2 <= d1) {
            res++;
            sum += d2;
        }
        return ((a > 0 && b > 0 || (a < 0 && b < 0))) ? res : negate(res);
    }
    
    private static int abs(int n) {
        return n > 0 ? n : negate(n);
    }
    
    private static int negate(int n) {
        return ~n + 1;
    }

}
