package edu.nyu.cs.codinginterview.vi;

public class SwapMinMaxSolution {
    
    private SwapMinMaxSolution() {
        throw new AssertionError();
    }
    
    public static void swapMinMax(int[] a) {
        if (a.length == 0) {
            return;
        }
        
        int min = getMin(a);
        int max = getMax(a);
        swap(a, min, max);
    }

    private static int getMin(int[] a) {
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    private static int getMax(int[] a) {
        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
}
