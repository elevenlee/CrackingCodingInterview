package edu.nyu.cs.codinginterview.chapter09;

public class Index implements Comparable<Index> {
    private int height;
    private Box above;
    private volatile int hashCode;
    
    public Index() {
        this(0, null);
    }
    
    public Index(int height) {
        this(height, null);
    }
    
    public Index(int height, Box above) {
        if (height < 0) {
            throw new IllegalArgumentException();
        }
        
        this.height = height;
        this.above = above;
    }
    
    public Box getAbove() {
        return above;
    }
    
    public void setAbove(Box above) {
        this.above = above;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException();
        }
        
        this.height = height;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Index)) {
            return false;
        }
        Index index = (Index) o;
        return height == index.height;
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + height;
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "" + height + " -- " + above.toString();
    }
    
    @Override
    public int compareTo(Index index) {
        return height - index.height;
    }
    
}
