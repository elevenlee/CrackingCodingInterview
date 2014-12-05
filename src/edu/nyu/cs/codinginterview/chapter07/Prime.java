package edu.nyu.cs.codinginterview.chapter07;

public class Prime {
    
    private Prime() {
        throw new AssertionError();
    }
    
    public static boolean primeNative(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean primeSlightlyBetter(int n) {
        if (n < 2) {
            return false;
        }
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
        int prime = 2;
        while (prime <= max) {
            /* Cross off remaining multiples of prime*/
            crossOff(flags, prime);
            /* Find next value which is true*/
            prime = getNextPrime(flags, prime);
            
            if (prime >= flags.length) {
                break;
            }
        }
        return flags;
    }
    
    private static void crossOff(boolean[] flags, int prime) {
        /* Cross off remaining multiples of prime. We can start with
         * (prime * prime), because if we have a k * prime, where
         * k < prime, this value would have already been crossed off
         * in a prior iteration. */
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }
    
    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

}
