package edu.nyu.cs.codinginterview.chapter01;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Write a method to replace all spaces in a string with "%20".
 */
public class ReplaceWhiteSpaceSolution {
    
    private ReplaceWhiteSpaceSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static void replaceWhiteSpace(char[] s) {
        Check.nullCheck(s, "char array");
        
        int spaceCount = 0;
        int newLength = -1;
        for (char c : s) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        newLength = s.length + spaceCount * 2;
        s[newLength] = '\0';
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[newLength - 1] = '0';
                s[newLength - 2] = '2';
                s[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                s[newLength - 1] = s[i];
                newLength = newLength - 1;
            }
        }
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(n)
     */
    public static String replaceWhiteSpace(String s) {
        Check.nullCheck(s, "string");
        
        String str = s.trim();
        return str.replaceAll(" ", "%20");
    }

}
