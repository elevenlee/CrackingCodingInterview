package edu.nyu.cs.codinginterview.chapter08.cardgame;

public enum Suit {
    CLUB(0), DIAMOND(1), HEART(2), SPADE(3);
    
    private final int value;
    
    private Suit(int value) {
        assert value >= 0;
        
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public static Suit getSuitFromValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        
        Suit[] suits = Suit.values();
        for (Suit s : suits) {
            if (value == s.value) {
                return s;
            }
        }
        return null;
    }
    
}
