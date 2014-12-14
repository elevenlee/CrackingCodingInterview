package edu.nyu.cs.codinginterview.chapter08.music;

import edu.nyu.cs.codinginterview.util.Check;

public class User {
    private long id;
    private String name;
    
    public User(long id, String name) {
        Check.nullCheck(name, "user name");
        
        this.id = id;
        this.name = name;
    }
    
    public long getID()     { return id; }
    public String getName() { return name; }
    
    public void setID(long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        Check.nullCheck(name, "user name");
        
        this.name = name;
    }

}
