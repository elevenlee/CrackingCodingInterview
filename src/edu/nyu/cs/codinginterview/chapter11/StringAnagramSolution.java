package edu.nyu.cs.codinginterview.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class StringAnagramSolution {
    
    private StringAnagramSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(nlogn)
     * space complexity O(1)
     */
    public static void sort(String[] a) {
        Check.nullCheck(a, "string array");
        for (String s : a) {
            Check.nullCheck(s, "string");
        }
        
        Map<Integer, List<String>> table = new HashMap<Integer, List<String>>();
        int hashCode = 0;
        String sorted = null;
        for (String s : a) {
            sorted = sortChar(s);
            hashCode = sorted.hashCode();
            if (!table.containsKey(hashCode)) {
                table.put(hashCode, new ArrayList<String>());
            }
            table.get(hashCode).add(s);
        }
        int index = 0;
        List<String> strList = null;
        for (Map.Entry<Integer, List<String>> entry : table.entrySet()) {
            strList = entry.getValue();
            for (String s : strList) {
                a[index++] = s;
            }
        }
    }

    private static String sortChar(String s) {
        assert s != null;
        
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    
}
