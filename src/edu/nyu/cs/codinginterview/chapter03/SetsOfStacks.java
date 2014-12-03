package edu.nyu.cs.codinginterview.chapter03;

import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Imagine a stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would 
 * likely start a new stack when the previous stack exceeds some threshold. Implement a data structure 
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new 
 * stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave 
 * identically to a single stack (that is, pop() should return the same values as it would if there were just 
 * a single stack)
 * <p>
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class SetsOfStacks<E> {
    private static final int CAPACITY = 16;
    private Element<E> top;
    private final int capacity;
    
    private static class Element<E> {
        private final StackFull<E> subStack;
        private Element<E> next;
        
        Element(StackFull<E> subStack, Element<E> next) {
            assert subStack != null;
            
            this.subStack = subStack;
            this.next = next;
        }
        
    }
    
    public SetsOfStacks() {
        this(CAPACITY);
    }
    
    public SetsOfStacks(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        
        top = null;
        this.capacity = capacity;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public E peek() {
        return isEmpty() ? null : top.subStack.peek();
    }
    
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        StackFull<E> sub = top.subStack;
        E item = sub.pop();
        while (sub.isEmpty()) {
            top = top.next;
            if (!isEmpty()) {
                sub = top.subStack;
            } else {
                break;
            }
        }
        return item;
    }
    
    public E popAt(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        Element<E> curr = top;
        Element<E> prev = null;
        while (i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        StackFull<E> sub = curr.subStack;
        E item = sub.pop();
        while (sub.isEmpty()) {
            curr = curr.next;
            if (curr != null) {
                sub = curr.subStack;
            } else {
                break;
            }
        }
        if (prev == null) {
            top = curr;
        } else {
            prev.next = curr;
        }
        return item;
    }
    
    public E push(E item) {
        Check.nullCheck(item, "item");
        
        if (isEmpty() || top.subStack.isFull()) {
            top = new Element<E>(new StackFull<E>(capacity), top);
        }
        top.subStack.push(item);
        return top.subStack.peek();
    }

    private int size() {
        int size = 0;
        for (Element<E> curr = top; curr != null; curr = curr.next) {
            size++;
        }
        return size;
    }
    
}
