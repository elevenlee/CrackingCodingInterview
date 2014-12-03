package edu.nyu.cs.codinginterview.chapter03;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Check;

public class StackFull<E> implements Iterable<E> {
    private E[] items;
    private int top;
    
    @SuppressWarnings("unchecked")
    public StackFull(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        
        items = (E[]) new Object[capacity];
        top = -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == items.length - 1;
    }
    
    public E peek() {
        return isEmpty() ? null : items[top];
    }
    
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        top = top - 1;
        return items[top + 1];
    }
    
    public E push(E item) {
        Check.nullCheck(item, "item");
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        
        items[++top] = item;
        return items[top];
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int pos = top;
            
            @Override
            public boolean hasNext() {
                return pos > -1;
            }
            
            @Override
            public E next() {
                if (pos <= -1) {
                    throw new NoSuchElementException();
                }
                E item = items[pos--];
                return item;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
