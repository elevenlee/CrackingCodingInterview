package edu.nyu.cs.codinginterview.chapter01;

import edu.nyu.cs.codinginterview.util.Check;
import edu.nyu.cs.codinginterview.util.QuickSort;

/**
 * @author shenli
 * <p>
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional 
 * data structures? (We will assume for simplicity that the character set is ASCII.)
 */
public class UniqueCharactersSolution {
    
    private UniqueCharactersSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(1)
     */
    public static boolean isUniqueCharacter1(String s) {
        Check.nullCheck(s, "string");
        
        if (s.length() > 256) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * time complexity O(nlogn)
     * space complexity O(n)
     */
    public static boolean isUniqueCharacter2(String s) {
        Check.nullCheck(s, "string");
        
        if (s.length() > 256) {
            return false;
        }
        char[] chars = s.toCharArray();
        QuickSort.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static boolean isUniqueCharacter3(String s) {
        Check.nullCheck(s, "string");
        
        final int size = 256;
        if (s.length() > size) {
            return false;
        }
        boolean[] result = new boolean[size];
        int val = -1;
        for (int i = 0; i < s.length(); i++) {
            val = s.charAt(i);
            if (result[val]) {
                return false;
            }
            result[val] = true;
        }
        return true;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static boolean isUniqueCharacter4(String s) {
        Check.nullCheck(s, "string");
        
        if (s.length() > 256) {
            return false;
        }
        int checker = 0;
        int val = -1;
        for (int i = 0; i < s.length(); i++) {
            val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

}
