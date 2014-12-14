package edu.nyu.cs.codinginterview.chapter08.cardgame;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Design the data structures for a generic deck of cards. Explain how you would subclasses the data structures 
 * to implement blackjack.
 */
public abstract class Card {
    private boolean available;
    protected final int faceValue;
    protected final Suit suit;
    
    public Card(int faceValue, Suit suit) {
        Check.nullCheck(suit, "suit");
        if (faceValue <= 0) {
            throw new IllegalArgumentException();
        }
        this.faceValue = faceValue;
        this.suit = suit;
        this.available = true;
    }
    
    public int getFaceValue() {
        return faceValue;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void markAvailable() {
        available = true;
    }
    
    public void markUnAvailable() {
        available = false;
    }
    
    public abstract int value();

}
