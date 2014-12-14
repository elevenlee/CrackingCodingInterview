package edu.nyu.cs.codinginterview.chapter08.callcenter;

public abstract class Employee {
    private Call currentCall;
    protected Rank rank;
    
    public Employee() {
        
    }
    
    public void receiveCall(Call call) {
        // TODO Auto-generated method stub
    }
    
    public void callCompleted() {
        // TODO Auto-generated method stub
    }
    
    public void escalateAndReassign() {
        // TODO Auto-generated method stub
    }
    
    public boolean assignNewCall() {
        // TODO Auto-generated method stub
        return false;
    }
    
    public boolean isFree() {
        return currentCall == null;
    }
    
    public Rank getRank() {
        return rank;
    }
    
}
