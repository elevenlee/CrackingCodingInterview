package edu.nyu.cs.codinginterview.chapter14;

public class Ambiguous extends Shape {
    private final double area;
    
    public Ambiguous(double area) {
        super();
        this.area = area;
    }
    
    @Override
    public double computeArea() {
        return area;
    }
    
}
