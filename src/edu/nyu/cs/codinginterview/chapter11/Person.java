package edu.nyu.cs.codinginterview.chapter11;

public class Person {
    private final double height;
    private final double weight;
    private volatile int hashCode;
    
    public Person(double height, double weight) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.height = height;
        this.weight = weight;
    }
    
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person p = (Person) o;
        return Double.compare(height, p.height) == 0
                && Double.compare(weight, p.weight) == 0;
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            long toLong = Double.doubleToLongBits(height);
            result = result * 31 + (int) (toLong ^ (toLong >>> 32));
            toLong = Double.doubleToLongBits(weight);
            result = result * 31 + (int) (toLong ^ (toLong >>> 32));
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "(" + height + ", " + weight + ")";
    }
    
}
