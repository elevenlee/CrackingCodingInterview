package edu.nyu.cs.codinginterview.chapter03.animals;

public class AnimalFactory {
    private static int order = 0;
    
    private AnimalFactory() {
        throw new AssertionError();
    }
    
    public static Animal getAnimal(AnimalType type) {
        switch (type) {
            case DOG: return new Dog(++order);
            case CAT: return new Cat(++order);
            case PIG: return new Pig(++order);
        }
        throw new IllegalArgumentException("No such animal type");
    }

}
