package edu.nyu.cs.codinginterview.chapter02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are 
 * stored in reverse order, such that the 1's digit is at the head of the list. Write a function that ads the 
 * two numbers and returns the sum as a linked list.
 * <p>
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */
public class AddNumberSolution implements Iterable<Integer> {
    private Element head;
    private Element tail;
    
    private static class Element {
        private final int key;
        private Element next;
        
        Element(int key, Element next) {
            this.key = key;
            this.next = next;
        }
        
    }
    
    public AddNumberSolution() {
        head = tail = null;
    }
    
    public AddNumberSolution(int[] a) {
        Check.nullCheck(a, "number array");
        
        for (int i : a) {
            addToTail(i);
        }
    }
    
    public void add(int value) {
        if (head == null) {
            head = tail = new Element(value, null);
        } else {
            head = new Element(value, head);
        }
    }
    
    public void addToTail(int value) {
        if (head == null) {
            head = tail = new Element(value, null);
        } else {
            tail.next = new Element(value, null);
            tail = tail.next;
        }
    }

    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static AddNumberSolution add(AddNumberSolution n1, AddNumberSolution n2) {
        Check.nullCheck(n1, "list 1");
        Check.nullCheck(n2, "list 2");
        
        AddNumberSolution result = new AddNumberSolution();
        Element item1 = n1.head;
        Element item2 = n2.head;
        boolean plusOne = false;
        while (item1 != null && item2 != null) {
            plusOne = result.addHelper(item1.key, item2.key, plusOne);
            item1 = item1.next;
            item2 = item2.next;
        }
        if (item1 != null) {
            while (item1 != null) {
                plusOne = result.addHelper(item1.key, 0, plusOne);
                item1 = item1.next;
            }
        } else if (item2 != null) {
            while (item2 != null) {
                plusOne = result.addHelper(0, item2.key, plusOne);
                item2 = item2.next;
            }
        }
        while (plusOne) {
            plusOne = result.addHelper(0, 0, plusOne);
        }
        return result;
    }
    
    private boolean addHelper(int n1, int n2, boolean plusOne) {
        int digit = plusOne ? n1 + n2 + 1 : n1 + n2;
        if (digit < 10) {
            addToTail(digit);
            return false;
        } else {
            addToTail(digit - 10);
            return true;
        }
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Element curr = null;
            private Element next = head;
            
            @Override
            public boolean hasNext() {
                return next != null;
            }
            
            @Override
            public Integer next() {
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
