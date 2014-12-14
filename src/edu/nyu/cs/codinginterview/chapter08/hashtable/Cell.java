package edu.nyu.cs.codinginterview.chapter08.hashtable;

import edu.nyu.cs.codinginterview.util.Check;

public class Cell<K, V> {
    private final K key;
    private final V value;
    private volatile int hashCode;
    
    public Cell(K key, V value) {
        Check.nullCheck(key, "key");
        Check.nullCheck(value, "value");
        
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
    
    public boolean equivalent(K key) {
        return this.key.equals(key);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }
        @SuppressWarnings("unchecked")
        Cell<K, V> cell = (Cell<K, V>) o;
        return key.equals(cell.key);
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + key.hashCode();
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "(" + key.toString() + ", " + value.toString() + ")";
    }
    
}
