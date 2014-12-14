package edu.nyu.cs.codinginterview.chapter14;

public abstract class Shape {
    
    public Shape() {
        
    }
    
    public void printMe() {
        System.out.println("I am a shape");
    }
    
    public abstract double computeArea();

}
