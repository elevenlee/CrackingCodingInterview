package edu.nyu.cs.codinginterview.chapter02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all 
 * nodes greater than or equal to x.
 */
public class PartitionLinkedListSolution<E extends Comparable<? super E>>
                                                        implements Iterable<E> {
    private Element<E> head;
    
    private static class Element<E> {
        private E key;
        private Element<E> next;
        
        Element(E key, Element<E> next) {
            assert key != null;
            
            this.key = key;
            this.next = next;
        }
        
    }
    
    public PartitionLinkedListSolution() {
        head = null;
    }
    
    public PartitionLinkedListSolution(E[] items) {
        Check.nullCheck(items, "item array");
        for (E item : items) {
            Check.nullCheck(item, "item");
        }
        
        for (E item : items) {
            head = new Element<E>(item, head);
        }
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public void partition(E value) {
        Check.nullCheck(value, "value");
        
        Element<E> curr = head;
        Element<E> prev = null;
        while (curr != null) {
            if (curr.key.compareTo(value) < 0) {
                prev = prev == null ? head : prev.next;
                exchange(prev, curr);
            }
            curr = curr.next;
        }
    }
    
    private static <T> void exchange(Element<T> e1, Element<T> e2) {
        T tmp = e1.key;
        e1.key = e2.key;
        e2.key = tmp;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Element<E> curr = null;
            private Element<E> next = head;
            
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
