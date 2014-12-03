package edu.nyu.cs.codinginterview.chapter02;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthToLastElementSolution<E> {
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
    
    public KthToLastElementSolution() {
        head = null;
    }
    
    public KthToLastElementSolution(E[] items) {
        Check.nullCheck(items, "item list");
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
    public E kthToLastElementIterative(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        
        Element<E> p1 = head;
        Element<E> p2 = head;
        int i = 1;
        while (i < k && p2 != null) {
            p2 = p2.next;
            i++;
        }
        if (p2 == null) {
            return null;
        }
        
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.key;
    }
    
    public E kthToLastElementRecursive(int k) {
        return null;
    }
}
