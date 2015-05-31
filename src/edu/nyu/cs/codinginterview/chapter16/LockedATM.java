package edu.nyu.cs.codinginterview.chapter16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM {
    private Lock lock;
    private int balance;
    
    public LockedATM() {
        lock = new ReentrantLock();
        balance = 100;
    }
    
    public int withdraw(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
        } catch (InterruptedException e) {
            
        } finally {
            lock.unlock();
        }
        return temp;
    }
    
    public int deposit(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp = temp + value;
            Thread.sleep(300);
            balance = temp;
        } catch (InterruptedException e) {
            
        } finally {
            lock.unlock();
        }
        return temp;
    }

}
