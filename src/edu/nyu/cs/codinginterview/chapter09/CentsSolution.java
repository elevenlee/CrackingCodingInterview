package edu.nyu.cs.codinginterview.chapter09;

/**
 * @author shenli
 * <p>
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), 
 * write code to calculate the number of ways of representing n cents.
 */
public class CentsSolution {
    
    private enum Coin {
        QUARTER(25), DIME(10), NICKEL(5), PENNY(1), ZERO(0);
        
        private final int value;
        
        private Coin(int value) {
            assert value > 0;
            
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
        
        @SuppressWarnings("unused")
        public static Coin getCoinFromValue(int value) {
            Coin[] coins = Coin.values();
            for (Coin c : coins) {
                if (c.value == value) {
                    return c;
                }
            }
            return null;
        }
        
    }
    
    private CentsSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n!)
     * space complexity O(1)
     */
    public static int numberOfWays(int n) {
        if (n <= 0) {
            return 0;
        }
        return numberOfWaysHelper(n, Coin.QUARTER);
    }
    
    private static int numberOfWaysHelper(int i, Coin coin) {
        assert coin != null;
        
        Coin next = getNext(coin);
        if (next == Coin.ZERO) {
            return 1;
        }
        int ways = 0;
        for (int k = 0; k * coin.getValue() <= i; k++) {
            ways += numberOfWaysHelper(i - k * coin.getValue(), next);
        }
        return ways;
    }
    
    private static Coin getNext(Coin coin) {
        switch (coin) {
            case QUARTER:   return Coin.DIME;
            case DIME:      return Coin.NICKEL;
            case NICKEL:    return Coin.PENNY;
            case PENNY:     return Coin.ZERO;
            case ZERO:      return Coin.ZERO;
        }
        throw new IllegalArgumentException("no such coin!");
    }
    
}
