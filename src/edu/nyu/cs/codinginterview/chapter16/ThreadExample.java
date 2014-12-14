package edu.nyu.cs.codinginterview.chapter16;

public class ThreadExample extends Thread {
    private int count;
    
    public ThreadExample() {
        super();
        count = 0;
    }
    
    public int getCount() {
        return count;
    }
    
    @Override
    public void run() {
        System.out.println("Thread starting.");
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("In Thread, count is " + count);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Thread terminating.");
    }

    public static void main(String[] args) {
        ThreadExample instance = new ThreadExample();
        instance.start();
        
        while (instance.getCount() != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
