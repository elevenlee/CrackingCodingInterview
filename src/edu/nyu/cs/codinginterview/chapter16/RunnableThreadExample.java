package edu.nyu.cs.codinginterview.chapter16;

public class RunnableThreadExample implements Runnable {
    private int count;
    
    public RunnableThreadExample() {
        count = 0;
    }
    
    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        System.out.println("RunnableThread starting.");
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("In Thread, count is " + count);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("RunnableThread interrupted.");
        }
        System.out.println("RunnableThread terminating.");
    }
    
    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();
        
        /*wait until above thread counts to 5 (slowly)*/
        while (instance.getCount() != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
