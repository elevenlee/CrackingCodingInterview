package edu.nyu.cs.codinginterview.chapter08.callcenter;

public class Call {
    private Rank rank;
    @SuppressWarnings("unused")
    private Caller caller;
    @SuppressWarnings("unused")
    private Employee handler;
    
    public Call(Caller caller) {
        rank = Rank.RESPONDENT;
        this.caller = caller;
    }
    
    public void setHandler(Employee e) {
        // TODO Auto-generated method stub
    }
    
    public void reply(String message) {
        // TODO Auto-generated method stub
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
    public Rank incrementRank() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public void disconnect() {
        // TODO Auto-generated method stub
    }
    
}
