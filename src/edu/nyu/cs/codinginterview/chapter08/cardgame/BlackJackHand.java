package edu.nyu.cs.codinginterview.chapter08.cardgame;

import java.util.List;

public class BlackJackHand extends Hand<BlackJackCard> {
    
    public int score() {
        List<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }
    
    public boolean busted() {
        return score() > 21;
    }
    
    public boolean is21() {
        return score() == 21;
    }
    
    public boolean isBlackJack() {
        // TODO Auto-generated method stub
        return false;
    }
    
    private List<Integer> possibleScores() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
