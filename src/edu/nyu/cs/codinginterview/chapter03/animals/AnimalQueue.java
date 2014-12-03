package edu.nyu.cs.codinginterview.chapter03.animals;

import java.util.Iterator;
import java.util.NoSuchElementException;

class AnimalQueue<E extends Animal> implements Iterable<E> {
    private Element<E> head;
    private Element<E> tail;
    
    private static class Element<E> {
        private final E item;
        private Element<E> next;
        
        Element(E item, Element<E> next) {
            assert item != null;
            
            this.item = item;
            this.next = next;
        }
        
    }
    
    public AnimalQueue() {
        head = tail = null;
    }
    
    public E deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        E item = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return item;
    }
    
    public boolean enQueue(E item) {
        if (item == null) {
            return false;
        }
        if (isEmpty()) {
            head = tail = new Element<E>(item, null);
        } else {
            tail.next = new Element<E>(item, null);
            tail = tail.next;
        }
        return true;
    }
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public E peek() {
        return isEmpty() ? null : head.item;
    }
    
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int size = 0;
        for (Element<E> curr = head; curr != tail.next; curr = curr.next) {
            size++;
        }
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Element<E> curr = null;
            private Element<E> next = head;
            
            @Override
            public boolean hasNext() {
                return !isEmpty() && next != tail.next;
            }
            
            @Override
            public E next() {
                if (isEmpty() || next == tail.next) {
                    throw new NoSuchElementException();
                }
                curr = next;
                next = next.next;
                return curr.item;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }
    
}
