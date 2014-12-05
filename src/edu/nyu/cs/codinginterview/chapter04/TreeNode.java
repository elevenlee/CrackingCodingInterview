package edu.nyu.cs.codinginterview.chapter04;

import edu.nyu.cs.codinginterview.util.Check;

public class TreeNode<E extends Comparable<? super E>> {
    private final E key;
    private TreeNode<E> p;
    private TreeNode<E> left;
    private TreeNode<E> right;
    
    public TreeNode(E key, TreeNode<E> p, TreeNode<E> left, TreeNode<E> right) {
        Check.nullCheck(key, "key");
        
        this.key = key;
        this.p = p;
        this.left = left;
        this.right = right;
    }
    
    public E getKey() {
        return key;
    }
    
    public TreeNode<E> getParent() {
        return p;
    }
    
    public TreeNode<E> getLeft() {
        return left;
    }
    
    public TreeNode<E> getRight() {
        return right;
    }
    
    public void setParent(TreeNode<E> p) {
        this.p = p;
    }
    
    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }
    
    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
    
}
