package edu.nyu.cs.codinginterview.chapter03;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the 
 * minimum element? push, pop and min should all operate in O(1) time.
 */
public class StackMin1<E extends Comparable<? super E>> implements Iterable<E> {
    private Element<E> top;
    
    private static class Element<E> {
        private final E key;
        private Element<E> next;
        private final E min;
        
        Element(E key, Element<E> next, E min) {
            assert key != null;
            assert min != null;
            
            this.key = key;
            this.next = next;
            this.min = min;
        }
        
    }
    
    public StackMin1() {
        top = null;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public E min() {
        return isEmpty() ? null : top.min;
    }
    
    public E peek() {
        return isEmpty() ? null : top.key;
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        E item = top.key;
        top = top.next;
        return item;
    }
    
    /**
     * time complexity O(1)
     * space complexity O(1)
     */
    public E push(E item) {
        Check.nullCheck(item, "item");
        
        if (isEmpty() || item.compareTo(top.min) < 0) {
            top = new Element<E>(item, top, item);
        } else {
            top = new Element<E>(item, top, top.min);
        }
        return top.key;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Element<E> curr = null;
            private Element<E> next = top;
            
            @Override
            public boolean hasNext() {
                return next != null;
            }
            
            @Override
            public E next() {
                if (next == null) {
                    throw new NoSuchElementException();
                }
                curr = next;
                next = next.next;
                return curr.key;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }

}
