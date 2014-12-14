package edu.nyu.cs.codinginterview.chapter09;

import edu.nyu.cs.codinginterview.util.Check;

public class Box implements Comparable<Box>{
    private static int count = 0;
    private final int id;
    private final int width;
    private final int height;
    private final int depth;
    private volatile int hashCode;
    
    public Box(int width, int height, int depth) {
        if (width <= 0 || height <= 0 || depth <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = count++;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    
    public int getId()      { return id; }
    public int getWidth()   { return width; }
    public int getHeight()  { return height; }
    public int getDepth()   { return depth; }
    
    public boolean isValidAbove(Box bottom) {
        return width < bottom.width
                && height < bottom.height
                && depth < bottom.depth;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Box)) {
            return false;
        }
        Box b = (Box) o;
        return id == b.id;
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
        return "(" + width + "," + height + "," + depth + ")";
    }
    
    @Override
    public int compareTo(Box b) {
        Check.nullCheck(b, "compare box");
        
        return b.id - id;
    }

}
