package edu.nyu.cs.codinginterview.chapter04.graph;

import edu.nyu.cs.codinginterview.util.Check;

public class Vertex {
    protected final int id;
    protected Vertex parent;
    protected State state;
    private volatile int hashCode;
    
    Vertex(int id) {
        this.id = id;
        this.parent = null;
        this.state = State.UNVISITED;
    }
    
    public int getId() {
        return id;
    }
    
    public Vertex getParent() {
        return parent;
    }
    
    public State getState() {
        return state;
    }
    
    public void setParent(Vertex parent) {
        this.parent = parent;
    }
    
    public void setState(State state) {
        Check.nullCheck(state, "edge state");
        
        this.state = state;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex v = (Vertex) o;
        return id == v.id;
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + id;
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "" + id;
    }
    
}
