package edu.nyu.cs.codinginterview.chapter02;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 */
public class CircularLinkedListSolution<E> {
    private Element<E> head;
    private Element<E> tail;
    
    private static class Element<E> {
        private final E key;
        private DFSColor color;
        private Element<E> next;
        
        Element(E key, Element<E> next) {
            assert key != null;
            
            this.key = key;
            this.color = DFSColor.WHITE;
            this.next = next;
        }
        
    }
    
    private static enum DFSColor {
        WHITE("White"), GRAY("Gray");
        
        private String description;
        
        private DFSColor(String description) {
            assert description != null;
            
            this.description = description;
        }
        
        @Override
        public String toString() {
            return description;
        }
    }
    
    public CircularLinkedListSolution() {
        head = tail = null;
    }
    
    public CircularLinkedListSolution(E[] items) {
        Check.nullCheck(items, "item array");
        for (E item : items) {
            Check.nullCheck(item, "item");
        }
        
        for (E item : items) {
            if (head == null) {
                head = tail = new Element<E>(item, null);
            } else {
                head = new Element<E>(item, head);
            }
        }
    }
    
    public void addCircular(int position) {
        if (position < 0 || position >= size()) {
            throw new IllegalArgumentException();
        }
        
        Element<E> curr = head;
        for (int i = 0; i < position; i++) {
            curr = curr.next;
        }
        tail.next = curr;
    }
    
    private int size() {
        int length = 0;
        for (Element<E> curr = head; curr != null; curr = curr.next) {
            length++;
        }
        return length;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public E circular() {
        Element<E> curr = head;
        while (curr != null) {
            if (curr.color == DFSColor.WHITE) {
                curr.color = DFSColor.GRAY;
            } else if (curr.color == DFSColor.GRAY) {
                return curr.key;
            }
            curr = curr.next;
        }
        return null;
    }
    
}
