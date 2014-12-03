package edu.nyu.cs.codinginterview.chapter03;

import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Stack;

/**
 * @author shenli
 * <p>
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class MyQueue2<E> {
    private Stack<E> stackItems;
    private Stack<E> stackAux;
    
    public MyQueue2() {
        stackItems = new Stack<E>();
        stackAux = new Stack<E>();
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public E deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        return stackItems.pop();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public boolean enQueue(E item) {
        if (item == null) {
            return false;
        }
        while (!stackItems.isEmpty()) {
            stackAux.push(stackItems.pop());
        }
        stackAux.push(item);
        while (!stackAux.isEmpty()) {
            stackItems.push(stackAux.pop());
        }
        return true;
    }
    
    public boolean isEmpty() {
        return stackItems.isEmpty();
    }
    
    /**
     * time complexity O(1)
     * space complexity O(n)
     */
    public E peek() {
        if (stackItems.isEmpty()) {
            return null;
        }
        return stackItems.peek();
    }
    
    public int size() {
        int size = 0;
        for (@SuppressWarnings("unused") E item : stackItems) {
            size++;
        }
        return size;
    }
    
}
