package edu.nyu.cs.codinginterview.chapter09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * <p>
 * Write a method to compute all permutations of a string
 */
public class PermutationSolution {

    private PermutationSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n!)
     * space complexity O(n!)
     */
    public static List<String> getPermutation(String s) {
        if (s == null) {
            return null;
        }
        List<String> permutations = new ArrayList<String>();
        if (s.length() == 0) {
            permutations.add("");
            return permutations;
        }
        
        char first = s.charAt(0);
        String remainder = s.substring(1);
        List<String> words = getPermutation(remainder);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                permutations.add(insertCharAt(word, first, i));
            }
        }
        return permutations;
    }
    
    private static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
    
}
