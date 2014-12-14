package edu.nyu.cs.codinginterview.chapter14;

public class IntroductionOverriding {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        Circle circle = new Circle(5);
        Ambiguous ambiguous = new Ambiguous(10);
        
        shapes[0] = circle;
        shapes[1] = ambiguous;
        
        for (Shape s : shapes) {
            s.printMe();
            System.out.println(s.computeArea());
        }
    }

}
