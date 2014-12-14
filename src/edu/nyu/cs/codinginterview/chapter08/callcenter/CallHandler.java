package edu.nyu.cs.codinginterview.chapter08.callcenter;

import java.util.List;

public enum CallHandler {
    INSTSANCE;
    
    @SuppressWarnings("unused")
    private final int LEVELS = 3;
    
    @SuppressWarnings("unused")
    private final int NUM_RESPONDENTS = 10;
    @SuppressWarnings("unused")
    private final int NUM_MANAGERS = 4;
    @SuppressWarnings("unused")
    private final int NUM_DIRECTORS = 2;
    
    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;
    
    private CallHandler() {
        // TODO Auto-generated method stub
    }
    
    public Employee getHandlerForCall(Call call) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public boolean assignCall(Employee e) {
        // TODO Auto-generated method stub
        return false;
    } 
    
    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }
    
    public void dispatchCall(Call call) {
        Employee e = getHandlerForCall(call);
        if (e != null) {
            e.receiveCall(call);
            call.setHandler(e);
        } else {
            call.reply("Please wait for free employee to reply!");
            callQueues.get(call.getRank().getPriority()).add(call);
        }
    }
    
}
