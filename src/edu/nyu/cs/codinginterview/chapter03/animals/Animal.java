package edu.nyu.cs.codinginterview.chapter03.animals;

import edu.nyu.cs.codinginterview.util.Check;

public abstract class Animal implements Comparable<Animal> {
    private final int order;
    
    Animal(int order) {
        this.order = order;
    }
    
    @Override
    public int compareTo(Animal a) {
        Check.nullCheck(a, "compared animal");
        
        return order - a.order;
    }

}
