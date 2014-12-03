package edu.nyu.cs.codinginterview.chapter02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a 
 * temporary buffer is not allowed?
 */
public class RemoveDuplicateLinkedListSolution<E> implements Iterable<E> {
    private Element<E> head;
    
    private static class Element<E> {
        private final E key;
        private Element<E> next;
        
        Element(E key, Element<E> next) {
            assert key != null;
            
            this.key = key;
            this.next = next;
        }
        
    }
    
    public RemoveDuplicateLinkedListSolution() {
        head = null;
    }
    
    public RemoveDuplicateLinkedListSolution(E[] items) {
        Check.nullCheck(items, "item list");
        for (E item : items) {
            Check.nullCheck(item, "item");
        }
        
        for (E item : items) {
            head = new Element<E>(item, head);
        }
    }
    
    public int size() {
        int length = 0;
        for (Element<E> curr = head; curr != null; curr = curr.next) {
            length++;
        }
        return length;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public void removeDuplicates1() {
        Map<E, Boolean> dup = new HashMap<E, Boolean>();
        Element<E> curr = head;
        Element<E> prev = null;
        while (curr != null) {
            if (dup.containsKey(curr.key)) {
                prev.next = curr.next;
            } else {
                dup.put(curr.key, true);
                prev = curr;
            }
            curr = curr.next;
        }
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(1)
     */
    public void removeDuplicates2() {
        Element<E> curr = null;
        Element<E> prev = null;
        for (Element<E> point = head; point != null; point = point.next) {
            curr = point.next;
            prev = point;
            while (curr != null) {
                if (curr.key.equals(point.key)) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
        }
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
