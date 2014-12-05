package edu.nyu.cs.codinginterview.chapter05;

/**
 * @author shenli
 * <p>
 * Given a real number between 0 and 1 that is passed in as a double, print the binary representation. If the 
 * number cannot be represented accurately in binary with at most 32 characters, print "ERROR".
 */
public class ConvertDoubleToBinarySolution {
    public static final String ERROR_MESSAGE = "ERROR";
    
    private ConvertDoubleToBinarySolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(logn)
     */
    public static String convertDoubleToBinary1(double num) {
        if (num <= 0 || num >= 1) {
            throw new IllegalArgumentException();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (Double.compare(num, 0) != 0) {
            if (sb.length() >= 32) {
                return ERROR_MESSAGE;
            }
            num *= 2;
            if (Double.compare(num, 1) >= 0) {
                sb.append(1);
                num = num - 1;
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(logn)
     */
    public static String convertDoubleToBinary2(double num) {
        if (num <= 0 || num >= 1) {
            throw new IllegalArgumentException();
        }
        
        double frac = 0.5;
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (Double.compare(num, 0) > 0) {
            if (sb.length() >= 32) {
                return ERROR_MESSAGE;
            }
            if (Double.compare(num, frac) >= 0) {
                sb.append(1);
                num -= frac;
            } else {
                sb.append(0);
            }
            frac /= 2;
        }
        return sb.toString();
    }

}
