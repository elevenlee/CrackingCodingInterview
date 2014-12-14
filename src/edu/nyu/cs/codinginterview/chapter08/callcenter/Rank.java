package edu.nyu.cs.codinginterview.chapter08.callcenter;

public enum Rank {
    RESPONDENT(0), MANAGER(1), DIRECTOR(2);
    
    private final int priority;
    
    private Rank(int priority) {
        this.priority = priority;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public static Rank getRankFromPriority(int priority) {
        Rank[] ranks = Rank.values();
        for (Rank r : ranks) {
            if (r.priority == priority) {
                return r;
            }
        }
        return null;
    }
    
}
