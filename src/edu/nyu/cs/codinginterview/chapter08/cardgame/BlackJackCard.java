package edu.nyu.cs.codinginterview.chapter08.cardgame;

public class BlackJackCard extends Card {
    
    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
    }
    
    public int minValue() {
        return isAce() ? 1 : value();
    }
    
    public int maxValue() {
        return isAce() ? 11 : value();
    }
    
    public boolean isAce() {
        return faceValue == 1;
    }
    
    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }
    
    @Override
    public int value() {
        if (isAce()) {
            return 1;
        } else if (faceValue >= 11 && faceValue <= 13) {
            return 10;
        } else {
            return faceValue;
        }
    }
    
}
