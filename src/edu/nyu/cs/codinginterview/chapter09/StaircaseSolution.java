package edu.nyu.cs.codinginterview.chapter09;

/**
 * @author shenli
 * <p>
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 step at a time. 
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class StaircaseSolution {

    private StaircaseSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(3^n)
     * space complexity O(1)
     */
    public static long numberOfWays(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        return numberOfWays(n - 1) + numberOfWays(n - 2) + numberOfWays(n - 3);
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static long numberOfWaysBottomUp(int n) {
        if (n <= 0) {
            return 0;
        }
        long[] num = n < 4 ? new long[4] : new long[n + 1];
        num[1] = 1;
        num[2] = 2;
        num[3] = 4;
        for (int i = 4; i < n + 1; i++) {
            num[i] = num[i - 1] + num[i - 2] + num[i - 3];
        }
        return num[n];
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static long numberOfWaysTopDown(int n) {
        if (n <= 0) {
            return 0;
        }
        long[] num = new long[n + 1];
        return numberOfWaysTopDownHelper(n, num);
    }
    
    private static long numberOfWaysTopDownHelper(int i, long[] num) {
        if (i == 1) {
            return 1;
        } else if (i == 2) {
            return 2;
        } else if (i == 3) {
            return 4;
        } else if (num[i] != 0) {
            return num[i];
        }
        num[i] = numberOfWaysTopDownHelper(i - 1, num)
                + numberOfWaysTopDownHelper(i - 2, num)
                + numberOfWaysTopDownHelper(i - 3, num);
        return num[i];
    }
    
}
