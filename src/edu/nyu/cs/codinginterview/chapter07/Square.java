package edu.nyu.cs.codinginterview.chapter07;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Given two squares on a two-dimensional plane, find a line that would cut these two squares in half. Assume 
 * that the top and the bottom sides of the square run parallel to the x-axis.
 */
public class Square implements Comparable<Square> {
    private static final Point ZERO = new Point(0, 0);
    private static final double UNIT = 1;
    private final Point p;
    private final double n;
    private volatile int hashCode;
    
    public Square() {
        this(ZERO, UNIT);
    }
    
    public Square(Point p, double n) {
        if (p == null) {
            throw new NullPointerException();
        } else if (Double.compare(n, 0) <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.p = p;
        this.n = n;
    }
    
    public Point getLeftBottomPoint() {
        return p;
    }
    
    public Point getLeftTopPoint() {
        return new Point(p.getX(), p.getY() + n);
    }
    
    public Point getRightBottomPoint() {
        return new Point(p.getX() + n, p.getY());
    }
    
    public Point getRightTopPoint() {
        return new Point(p.getX() + n, p.getY() + n);
    }
    
    public Point getMiddlePoint() {
        return new Point(p.getX() + n / 2, p.getY() + n / 2);
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public static Line getHalfSquaresLine(Square s1, Square s2) {
        Check.nullCheck(s1, "square 1");
        Check.nullCheck(s2, "square 2");
        
        Point p1 = s1.getMiddlePoint();
        Point p2 = s2.getMiddlePoint();
        if (p1.equals(p2)) {
            return new Line(p1, new Point(p1.getX() + 1, p1.getY()));
        }
        return new Line(p1, p2);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }
        if (!(o instanceof Square)) {
            return false;
        }
        Square s = (Square) o;
        return Double.compare(n, s.n) == 0
                && p.equals(s.p);
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result
                    + (int) (Double.doubleToLongBits(n)
                            ^ (Double.doubleToLongBits(n) >>> 32));
            result = 31 * result + p.hashCode();
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        return p.toString() + " -- " + n;
    }

    @Override
    public int compareTo(Square s) {
        Check.nullCheck(s, "compared square");
        
        int nDiff = Double.compare(n, s.n);
        if (nDiff != 0) {
            return nDiff;
        }
        return p.compareTo(s.p);
    }
    
}
