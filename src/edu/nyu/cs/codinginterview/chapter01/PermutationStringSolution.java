package edu.nyu.cs.codinginterview.chapter01;

import java.util.Arrays;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Given two strings, write a method to decide if one is a permutation of the other. (Assume the string 
 * comparison is case sensitive and whitespace is significant.)
 */
public class PermutationStringSolution {
    
    private PermutationStringSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(nlogn)
     * space complexity O(n)
     */
    public static boolean isPermutation1(String s1, String s2) {
        Check.nullCheck(s1, "string 1");
        Check.nullCheck(s2, "string 2");
        
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }
    
    private static String sort(String s) {
        assert s != null;
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static boolean isPermutation2(String s1, String s2) {
        Check.nullCheck(s1, "string 1");
        Check.nullCheck(s2, "string 2");
        
        if (s1.length() != s2.length()) {
            return false;
        }
        return hashEquals(hashString(s1), hashString(s2));
    }
    
    private static int[] hashString(String s) {
        assert s != null;
        
        char[] chars = s.toCharArray();
        int[] result = new int[256];
        for (char c : chars) {
            result[c]++;
        }
        return result;
    }
    
    private static boolean hashEquals(int[] a1, int[] a2) {
        assert a1 != null;
        assert a2 != null;
        
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
    
}
