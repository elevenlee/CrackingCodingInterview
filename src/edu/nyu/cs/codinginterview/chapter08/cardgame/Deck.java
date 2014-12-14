package edu.nyu.cs.codinginterview.chapter08.cardgame;

import java.util.List;

public class Deck <T extends Card> {
    private List<T> cards;
    private int dealtIndex = 0;
    
    public void setDeckOfCards(List<T> deckOfCards) {
        // TODO Auto-generated method stub
    }
    
    public void shuffle() {
        // TODO Auto-generated method stub
    }
    
    public int remainingCards() {
        return cards.size() - dealtIndex;
    }
    
    public T[] dealHand(int number) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public T dealCard() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
