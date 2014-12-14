package edu.nyu.cs.codinginterview.chapter16;

public class MyObject {
    
    public MyObject() {
        
    }
    
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + ".foo(): starting.");
            Thread.sleep(3000);
            System.out.println("Thread " + name + ".foo(): ending.");
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }

}
