package edu.nyu.cs.codinginterview.chapter09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shenli
 * <p>
 * Implement an algorithm to print all valid combinations of n-pairs of parentheses.
 */
public class ValidPairsSolution {
    private static final String PAIR = "()";
    
    private ValidPairsSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(n)
     */
    public static Set<String> generateParens1(int i) {
        Set<String> result = new HashSet<String>();
        if (i == 0) {
            result.add("");
        } else {
            Set<String> prev = generateParens1(i - 1);
            for (String s : prev) {
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == '(') {
                        String str = insertInside(s, k);
                        result.add(str);
                    }
                }
                if (!result.contains(PAIR + s)) {
                    result.add(PAIR + s);
                }
            }
        }
        return result;
    }
    
    private static String insertInside(String s, int k) {
        String left = s.substring(0, k + 1);
        String right = s.substring(k + 1);
        return left + PAIR + right;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static List<String> generateParens2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        char[] c = new char[n * 2];
        addParens(result, n, n, c, 0);
        return result;
    }
    
    private static void addParens(
            List<String> result, int leftRemain, int rightRemain, char[] c, int count) {
        if (leftRemain < 0 || rightRemain < 0) {
            return;
        }
        if (leftRemain == 0 && rightRemain == 0) {
            result.add(String.copyValueOf(c));
        } else {
            if (leftRemain > 0) {
                c[count] = '(';
                addParens(result, leftRemain - 1, rightRemain, c, count + 1);
            }
            if (rightRemain > leftRemain) {
                c[count] = ')';
                addParens(result, leftRemain, rightRemain - 1, c, count + 1);
            }
        }
    }
    
}
