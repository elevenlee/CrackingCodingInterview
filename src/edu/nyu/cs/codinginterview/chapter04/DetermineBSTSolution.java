package edu.nyu.cs.codinginterview.chapter04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * <p>
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class DetermineBSTSolution {
    private static int lastPrinted = Integer.MIN_VALUE;
    
    private DetermineBSTSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static <T extends Comparable<? super T>> boolean isBST1(TreeNode<T> root) {
        if (root == null) {
            return true;
        }
        List<TreeNode<T>> inOrder = new ArrayList<TreeNode<T>>();
        isBST1Helper(inOrder, root);
        T prev = null;
        T curr = null;
        for (int i = 1; i < inOrder.size(); i++) {
            prev = inOrder.get(i - 1).getKey();
            curr = inOrder.get(i).getKey();
            if (prev.compareTo(curr) > 0) {
                return false;
            }
        }
        return true;
    }
    
    private static <T extends Comparable<? super T>> void isBST1Helper(
            List<TreeNode<T>> inOrder, TreeNode<T> node) {
        assert inOrder != null;
        
        if (node != null) {
            isBST1Helper(inOrder, node.getLeft());
            inOrder.add(node);
            isBST1Helper(inOrder, node.getRight());
        }
    }
    
    /**
     * time complexity O(n)
     * space complexity O(logn)
     */
    public static boolean isBST2(TreeNode<Integer> node) {
        if (node == null) {
            return true;
        }
        if (!isBST2(node.getLeft())) {
            return false;
        }
        if (node.getKey() < lastPrinted) {
            return false;
        }
        lastPrinted = node.getKey();
        if (!isBST2(node.getRight())) {
            return false;
        }
        return true;    // All good
    }
    
    /**
     * time complexity O(n)
     * space complexity O(logn)
     */
    public static boolean isBST3(TreeNode<Integer> root) {
        return isBST3Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBST3Helper(TreeNode<Integer> node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.getKey() < min || node.getKey() > max) {
            return false;
        }
        return isBST3Helper(node.getLeft(), min, node.getKey())
                && isBST3Helper(node.getRight(), node.getKey(), max);
    }

}
