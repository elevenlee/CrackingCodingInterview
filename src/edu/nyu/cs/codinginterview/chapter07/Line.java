package edu.nyu.cs.codinginterview.chapter07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 */
public class Line {
    private final double slope;
    private final double intercept;
    private final boolean vertical;
    private volatile int hashCode;
    
    public Line(Point p1, Point p2) {
        Check.nullCheck(p1, "point 1");
        Check.nullCheck(p2, "point 2");
        
        this.slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        if (Double.compare(Math.abs(slope), Double.POSITIVE_INFINITY) == 0) {
            this.intercept = p1.getX();
            this.vertical = true;
        } else {
            this.intercept = p1.getY() - slope * p1.getX();
            this.vertical = false;
        }
    }
    
    public double getSlope() {
        return slope;
    }
    
    public double getIntercept() {
        return intercept;
    }
    
    public boolean isVertical() {
        return vertical;
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public static boolean isIntersect(Line line1, Line line2) {
        Check.nullCheck(line1, "line 1");
        Check.nullCheck(line2, "line 2");
        
        if (Double.compare(Math.abs(line1.slope), Double.POSITIVE_INFINITY) == 0
                && Double.compare(Math.abs(line2.slope), Double.POSITIVE_INFINITY) == 0) {
            return false;
        }
        return Double.compare(line1.slope, line2.slope) != 0;
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(n)
     */
    public static Line mostPoints(List<Point> points) {
        Map<Line, Integer> lines = new HashMap<Line, Integer>();
        Line line = null;
        Line bestLine = null;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                line = new Line(points.get(i), points.get(j));
                if (!lines.containsKey(line)) {
                    lines.put(line, 0);
                }
                lines.put(line, lines.get(line) + 1);
                if (bestLine == null
                        || lines.get(bestLine) < lines.get(line)) {
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }
        if (!(o instanceof Line)) {
            return false;
        }
        Line l = (Line) o;
        return Double.compare(slope, l.slope) == 0
                && Double.compare(intercept, l.intercept) == 0
                && vertical == l.vertical;
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        long tmp = 0;
        if (result == 0) {
            result = 17;
            tmp = Double.doubleToLongBits(slope);
            result = 31 * result + (int) (tmp ^ (tmp >>> 32));
            tmp = Double.doubleToLongBits(intercept);
            result = 31 * result + (int) (tmp ^ (tmp >>> 32));
            result = 31 * result + (vertical ? 1 : 0);
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("slope: ");
        sb.append(slope);
        sb.append(", intercept: ");
        sb.append(intercept);
        sb.append(", vertical: ");
        sb.append(vertical);
        return sb.toString();
    }

}
