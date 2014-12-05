package edu.nyu.cs.codinginterview.chapter07;

import edu.nyu.cs.codinginterview.util.Check;

public class Point implements Comparable<Point> {
    private static final double ZERO = 0;
    private final double x;
    private final double y;
    private volatile int hashCode;
    
    public Point() {
        this(ZERO, ZERO);
    }
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() { return x; }
    public double getY() { return y; }
    
    public double distance(Point p) {
        Check.nullCheck(p, "point");
        
        double xDiff = x - p.x;
        double yDiff = y - p.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return Double.compare(x, p.x) == 0
                && Double.compare(y, p.y) == 0;
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        long tmp = 0;
        if (result == 0) {
            result = 17;
            tmp = Double.doubleToLongBits(x);
            result = 31 * result + (int) (tmp ^ (tmp >>> 32));
            tmp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (tmp ^ (tmp >>> 32));
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(x);
        sb.append(", ");
        sb.append(y);
        sb.append(")");
        return sb.toString();
    }

    @Override
    public int compareTo(Point p) {
        Check.nullCheck(p, "compared point");
        
        int xDiff = Double.compare(x, p.x);
        if (xDiff != 0) {
            return xDiff;
        }
        return Double.compare(y, p.y);
    }
    
}
