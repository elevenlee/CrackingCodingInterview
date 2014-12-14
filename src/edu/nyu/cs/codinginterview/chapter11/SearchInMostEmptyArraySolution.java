package edu.nyu.cs.codinginterview.chapter11;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the 
 * location of a given string.
 */
public class SearchInMostEmptyArraySolution {
    
    private SearchInMostEmptyArraySolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(1)
     */
    public static int binarySearch(String[] s, String key) {
        Check.nullCheck(s, "array s");
        Check.nullCheck(key, "key");
        if (key.isEmpty()) {
            return -1;
        }
        
        int low = 0;
        int high = s.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (s[middle].isEmpty()) {
                middle = findClosetMiddle(s, low, middle, high);
            }
            if (middle == -1) {
                return -1;
            } else if (key.compareTo(s[middle]) == 0) {
                return middle;
            } else if (key.compareTo(s[middle]) < 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
    
    private static int findClosetMiddle(String[] s, int low, int middle, int high) {
        assert s != null;
        assert low >= 0;
        assert middle >= 0;
        assert high >= 0;
        
        int left = middle - 1;
        int right = middle + 1;
        while (left >= low && right <= high) {
            if (s[left].isEmpty()) {
                left--;
            } else {
                return left;
            }
            if (s[right].isEmpty()) {
                right++;
            } else {
                return right;
            }
        }
        while (left >= low) {
            if (s[left].isEmpty()) {
                left--;
            } else {
                return left;
            }
        }
        while (right <= high) {
            if (s[right].isEmpty()) {
                right++;
            } else {
                return right;
            }
        }
        return -1;
    }

}
