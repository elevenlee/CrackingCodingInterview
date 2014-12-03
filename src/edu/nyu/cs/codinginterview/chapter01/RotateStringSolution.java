package edu.nyu.cs.codinginterview.chapter01;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Assume you have a method isSubstring which checks if one word is a substring of another. Give two strings, 
 * s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
 */
public class RotateStringSolution {
    
    private RotateStringSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static boolean isRotation(String s1, String s2) {
        Check.nullCheck(s1, "string 1");
        Check.nullCheck(s2, "string 2");
        
        if (s1.length() != s2.length()) {
            return false;
        } else if (s1.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        return isSubstring(s1.toString(), s2);
    }
    
    private static boolean isSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] pi = computePrefixFunction(s2);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && s2.charAt(q + 1) != s1.charAt(i)) {
                q = pi[q];
            }
            if (s2.charAt(q + 1) == s1.charAt(i)) {
                q++;
            }
            if (q == m) {
                return true;
            }
        }
        return false;
    }
    
    private static int[] computePrefixFunction(String s) {
        int n = s.length();
        int[] pi = new int[n];
        pi[0] = 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            while (count > 0 && s.charAt(count + 1) != s.charAt(i)) {
                count = pi[count];
            }
            if (s.charAt(count + 1) == s.charAt(i)) {
                count++;
            }
            pi[i] = count;
        }
        return pi;
    }

}
