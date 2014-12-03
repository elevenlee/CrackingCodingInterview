package edu.nyu.cs.codinginterview.chapter03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixNStacks<E> implements Iterable<E> {
    private static final int CAPACITY = 16;
    private static final int NUMBER_OF_STACKS = 3;
    private E[] items;
    private int[] tops;
    
    public FixNStacks() {
        this(NUMBER_OF_STACKS, CAPACITY);
    }
    
    public FixNStacks(int number) {
        this(number, CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public FixNStacks(int number, int capacity) {
        if (number <= 0 || capacity <= 0) {
            throw new IllegalArgumentException();
        }
        
        items = (E[]) new Object[capacity];
        tops = new int[number];
        for (int i = 0; i < number; i++) {
            tops[i] = items.length * i / tops.length - 1;
        }
    }
    
    public boolean isEmpty(int n) {
        if (!isStackNumber(n)) {
            throw new IllegalArgumentException();
        }
        
        return tops[n] == items.length * n / tops.length - 1;
    }
    
    public boolean isFull(int n) {
        if (!isStackNumber(n)) {
            throw new IllegalArgumentException();
        }
        
        return tops[n] == items.length * (n + 1) / tops.length - 1;
    }
    
    public E peek(int n) {
        if (!isStackNumber(n)) {
            throw new IllegalArgumentException();
        }
        
        return isEmpty(n) ? null : items[tops[n]];
    }
    
    public E pop(int n) {
        if (!isStackNumber(n)) {
            throw new IllegalArgumentException();
        } else if (isEmpty(n)) {
            throw new NoSuchElementException();
        }
        
        tops[n] = tops[n] - 1;
        return items[tops[n] + 1];
    }
    
    public E push(E item, int n) {
        if (!isStackNumber(n)) {
            throw new IllegalArgumentException();
        } else if (item == null) {
            throw new NullPointerException();
        } else if (isFull(n)) {
            throw new IndexOutOfBoundsException();
        }
        
        items[++tops[n]] = item;
        return items[tops[n]];
    }
    
    private boolean isStackNumber(int n) {
        return n >= 0 && n < tops.length;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            
            @Override
            public boolean hasNext() {
                return false;
            }
            
            @Override
            public E next() {
                return null;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }

}
