package edu.nyu.cs.codinginterview.chapter01;

import edu.nyu.cs.codinginterview.util.Check;
import edu.nyu.cs.codinginterview.util.Utility;

/**
 * @author shenli
 * <p>
 * Implement a function which reverses a null-terminated string.
 */
public class ReverseStringSolution {
    
    private ReverseStringSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static void reverse(char[] s) {
        Check.nullCheck(s, "string");
        
        for (int start = 0, end = s.length - 1; start < end; start++, end--) {
            Utility.exchange(s, start, end);
        }
    }

}
