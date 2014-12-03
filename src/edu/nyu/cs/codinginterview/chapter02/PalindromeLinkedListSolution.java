package edu.nyu.cs.codinginterview.chapter02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Stack;

/**
 * @author shenli
 * <p>
 * Implement a function to check if a linked list is a palindrome.
 */
public class PalindromeLinkedListSolution<E> implements Iterable<E> {
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
    
    public PalindromeLinkedListSolution() {
        head = null;
    }
    
    public boolean add(E value) {
        if (value == null) {
            return false;
        }
        head = new Element<E>(value, head);
        return true;
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
    public boolean isPalindrome1() {
        PalindromeLinkedListSolution<E> reverseList = reverse();
        Element<E> curr1 = head;
        Element<E> curr2 = reverseList.head;
        int checkSize = size() / 2;     // only need to check the first half
        for (int i = 0; i < checkSize; i++) {
            if (!curr1.key.equals(curr2.key)) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }
    
    private PalindromeLinkedListSolution<E> reverse() {
        PalindromeLinkedListSolution<E> result =
                new PalindromeLinkedListSolution<E>();
        Element<E> curr = head;
        while (curr != null) {
            result.add(curr.key);
            curr = curr.next;
        }
        return result;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public boolean isPalindrome2() {
        if (head == null || head.next == null) {
            return true;
        }
        Element<E> slowRunner = head;
        Element<E> fastRunner = head;
        Stack<E> stack = new Stack<E>();
        int size = 0;
        while (fastRunner != null) {
            if (size % 2 == 1) {
                stack.push(slowRunner.key);
                slowRunner = slowRunner.next;
            }
            fastRunner = fastRunner.next;
            size++;
        }
        if (size % 2 == 1) {
            slowRunner = slowRunner.next;
        }
        return equals(stack, slowRunner);
    }
    
    private boolean equals(Stack<E> stack, Element<E> starter) {
        while (starter != null) {
            if (!starter.key.equals(stack.pop())) {
                return false;
            }
            starter = starter.next;
        }
        return true;
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
