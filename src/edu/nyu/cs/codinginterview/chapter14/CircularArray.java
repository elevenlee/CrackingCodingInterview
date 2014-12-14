package edu.nyu.cs.codinginterview.chapter14;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArray<E> implements Iterable<E> {
    private E[] items;
    private int head;
    
    @SuppressWarnings("unchecked")
    public CircularArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("array size is negative!");
        }
        items = (E[]) new Object[size];
        head = 0;
    }
    
    public E get(int index) {
        if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException();
        }
        return items[convert(index)];
    }
    
    public boolean set(int index, E item) {
        if (item == null) {
            return false;
        }
        items[convert(index)] = item;
        return true;
    }
    
    public void rotate(int shift) {
        head = convert(shift);
    }
    
    private int convert(int index) {
        if (index < 0) {
            index = index % items.length + items.length;
        }
        return (head + index) % items.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < items.length;
            }

            @Override
            public E next() {
                if (position >= items.length) {
                    throw new NoSuchElementException();
                }
                E item = items[convert(position)];
                position = position + 1;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }

}
