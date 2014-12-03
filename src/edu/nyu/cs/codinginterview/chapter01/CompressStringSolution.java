package edu.nyu.cs.codinginterview.chapter01;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Implement a method to perform basic compression using the counts of repeated characters. For example, the 
 * string aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the 
 * original string, your method should return the original string.
 */
public class CompressStringSolution {
    
    private CompressStringSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static String compress(String s) {
        Check.nullCheck(s, "string");
        
        if (s.equals("")) {
            return s;
        } else if (compressSize(s) > s.length()) {
            return s;
        }
        char last = s.charAt(0);
        int count = 1;
//      StringBuilder sb = new StringBuilder();
//      for (int i = 1; i < s.length(); i++) {
//          if (last == s.charAt(i)) {
//              count++;
//          } else {
//              sb.append(last);
//              sb.append(count);
//              last = s.charAt(i);
//              count = 1;
//          }
//      }
//      sb.append(last);
//      sb.append(count);
//      return sb.toString();
        char[] chars = new char[compressSize(s)];
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (last == s.charAt(i)) {
                count++;
            } else {
                index = setChar(chars, index, last, count);
                last = s.charAt(i);
                count = 1;
            }
        }
        setChar(chars, index, last, count);
        return new String(chars);
    }
    
    private static int compressSize(String s) {
        assert s != null;
        assert !s.equals("");
        
        char last = s.charAt(0);
        int count = 1;
        int size = 0;
        for (int i = 1; i < s.length(); i++) {
            if (last == s.charAt(i)) {
                count++;
            } else {
                size += 1 + String.valueOf(count).length();
                last = s.charAt(i);
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }
    
    private static int setChar(char[] s, int index, final char c, final int count) {
        s[index++] = c;
        char[] tmp = String.valueOf(count).toCharArray();
        for (char t : tmp) {
            s[index++] = t;
        }
        return index;
    }

}
