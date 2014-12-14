package edu.nyu.cs.codinginterview.chapter08.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * <p>
 * Design and implement a hash table which uses chaining (linked list) to handle collisions.
 */
public class MyHashTable<K, V> {
    private static final int CAPACITY = 16;
    private List<Cell<K, V>>[] table;
    private final int capacity;
    
    public MyHashTable() {
        this(CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.capacity = capacity;
        table = (List<Cell<K, V>>[]) new List[capacity];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ArrayList<Cell<K, V>>();
        }
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     * @param key
     * @param value
     * @return
     */
    public boolean put(K key, V value) {
        if (key == null || value == null) {
            return false;
        }
        List<Cell<K, V>> cells = table[hashFunc(key)];
        for (Cell<K, V> c : cells) {
            if (c.equivalent(key)) {
                cells.remove(c);
                break;
            }
        }
        cells.add(new Cell<K, V>(key, value));
        return true;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     * @param key
     * @return
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }
        List<Cell<K, V>> cells = table[hashFunc(key)];
        for (Cell<K, V> c : cells) {
            if (c.equivalent(key)) {
                return c.getValue();
            }
        }
        return null;
    }
    
    private int hashFunc(K key) {
        int hashCode = key.hashCode() % capacity;
        return hashCode < 0 ? hashCode + capacity : hashCode;
    }
    
}
