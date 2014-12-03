package edu.nyu.cs.codinginterview.vi;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Write a function to check if the value of a binary number (passed as a string) equals the hexadecimal 
 * representation of a string.
 */
public class CompareBinAndHexSolution {
    
    private CompareBinAndHexSolution() {
        throw new AssertionError();
    }
    
    public static boolean compareBinAndHex(String binary, String hex) {
        Check.nullCheck(binary, "binary");
        Check.nullCheck(hex, "hex");
        Check.emptyCheck(binary, "binary");
        Check.emptyCheck(hex, "hex");
        
        int n1 = convertToBase(binary, 2);
        int n2 = convertToBase(hex, 16);
        if (n1 < 0 || n2 < 0) {
            return false;
        } else {
            return n1 == n2;
        }
    }
    
    private static int convertToBase(String num, int base) {
        assert num != null;
        assert !num.equals("");
        assert ((base >= 2 && base <= 10) || base == 16);
        
        int value = 0;
        int digit = 0;
        int exp = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            digit = digitToValue(num.charAt(i));
            if (digit < 0 || digit >= base) {
                return -1;
            }
            exp = num.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }
    
    private static int digitToValue(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'F') {
            return 10 + c - 'A';
        } else if (c >= 'a' && c <= 'f') {
            return 10 + c - 'a';
        }
        return -1;
    }
    
}
