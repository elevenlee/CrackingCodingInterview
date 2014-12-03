package edu.nyu.cs.codinginterview.chapter03;

import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Stack;

/**
 * @author shenli
 * <p>
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class MyQueue1<E> {
    private final Stack<E> stackOldest;
    private final Stack<E> stackNewest;

    public MyQueue1() {
        stackOldest = new Stack<E>();
        stackNewest = new Stack<E>();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public E deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        shiftStack();
        return stackOldest.pop();
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public boolean enQueue(E item) {
        if (item == null) {
            return false;
        }
        stackNewest.push(item);
        return true;
    }
    
    public boolean isEmpty() {
        return stackOldest.isEmpty() && stackNewest.isEmpty();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public E peek() {
        shiftStack();
        return stackOldest.peek();
    }
    
    public int size() {
        int size = 0;
        for (@SuppressWarnings("unused") E item : stackOldest) {
            size++;
        }
        for (@SuppressWarnings("unused") E item : stackNewest) {
            size++;
        }
        return size;
    }
    
    private void shiftStack() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
    
}
