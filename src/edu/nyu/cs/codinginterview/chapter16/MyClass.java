package edu.nyu.cs.codinginterview.chapter16;

public class MyClass implements Runnable {
    private final String name;
    private final MyObject myObject;
    
    public MyClass(String name, MyObject myObject) {
        this.name = name;
        this.myObject = myObject;
    }
    
    @Override
    public void run() {
        myObject.foo(name);
    }

    public static void main(String[] args) {
        MyObject obj = new MyObject();
        MyClass instance1 = new MyClass("1", obj);
        MyClass instance2 = new MyClass("2", obj);
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
    }

}
