package edu.nyu.cs.codinginterview.chapter11;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of 
 * a number x (the number of values less than or equal to x). implement the data structure and algorithms to 
 * support these operations. That is, implement the method track(int x), which is called when each number is 
 * generated, and the method getRankOfNumber(int x), which returns the number of values less than or equal to 
 * x (not including x itself)
 */
public class BST<E extends Comparable<? super E>> {
    private Element<E> root;
    
    private static class Element<E> {
        private final E key;
        @SuppressWarnings("unused")
        private Element<E> p;
        private Element<E> left;
        private Element<E> right;
        private int n;
        
        Element(E key, Element<E> p, Element<E> left, Element<E> right) {
            assert key != null;
            
            this.key = key;
            this.p = p;
            this.left = left;
            this.right = right;
            this.n = 0;
        }
        
        int getN() {
            return n;
        }
        
        void setN(int n) {
            this.n = n;
        }
        
    }
    
    public BST() {
        root = null;
    }
    
    public void insert(E[] items) {
        Check.nullCheck(items, "item array");
        
        for (E item : items) {
            insert(item);
        }
    }
    
    public void insert(E item) {
        Check.nullCheck(item, "item");
        
        Element<E> curr = root;
        Element<E> parent = null;
        while (curr != null) {
            if (item.compareTo(curr.key) == 0) {
                curr.setN(curr.getN() + 1);
                return;
            } else if (item.compareTo(curr.key) < 0) {
                curr.setN(curr.getN() + 1);
                parent = curr;
                curr = curr.left;
            } else {
                parent = curr;
                curr = curr.right;
            }
        }
        if (parent == null) {
            root = new Element<E>(item, null, null, null);
        } else if (item.compareTo(parent.key) < 0) {
            parent.left = new Element<E>(item, parent, null, null);
        } else {
            parent.right = new Element<E>(item, parent, null, null);
        }
    }
    
    /**
     * time complexity O(logn)
     * space complexity O(1)
     */
    public int getRank(E item) {
        if (item == null) {
            return -1;
        }
        
        int rank = 0;
        Element<E> curr = root;
        while (curr != null) {
            if (item.compareTo(curr.key) == 0) {
                rank += curr.n;
                return rank;
            } else if (item.compareTo(curr.key) < 0) {
                curr = curr.left;
            } else {
                rank += curr.n;
                rank++;
                curr = curr.right;
            }
        }
        return -1;
    }
    
}
