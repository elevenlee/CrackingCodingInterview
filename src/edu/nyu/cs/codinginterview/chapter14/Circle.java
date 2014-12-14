package edu.nyu.cs.codinginterview.chapter14;

public class Circle extends Shape {
    private final double rad;
    
    public Circle(double rad) {
        super();
        this.rad = rad;
    }
    
    @Override
    public void printMe() {
        System.out.println("I'm a circle.");
    }
    
    @Override
    public double computeArea() {
        return rad * rad * Math.PI;
    }

}
