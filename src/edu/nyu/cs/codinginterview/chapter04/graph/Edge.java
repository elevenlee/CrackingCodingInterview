package edu.nyu.cs.codinginterview.chapter04.graph;

import edu.nyu.cs.codinginterview.util.Check;

public class Edge {
    private final Vertex start;
    private final Vertex end;
    private int weight;
    private EdgeType type;
    private volatile int hashCode;
    
    public Edge(Vertex start, Vertex end) {
        this(start, end, 1);
    }
    
    public Edge(Vertex start, Vertex end, int weight) {
        Check.nullCheck(start, "vertex start");
        Check.nullCheck(end, "vertex end");
        
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.type = EdgeType.NONE;
    }
    
    public Vertex getStart() {
        return start;
    }
    
    public Vertex getEnd() {
        return end;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public EdgeType getType() {
        return type;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public void setType(EdgeType type) {
        Check.nullCheck(type, "edge type");
        
        this.type = type;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Edge)) {
            return false;
        }
        Edge e = (Edge) o;
        return start.equals(e.start)
                && end.equals(e.end);
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + start.hashCode();
            result = 31 * result + end.hashCode();
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "(" + start.toString() + "," + end.toString() + ")";
    }

}
