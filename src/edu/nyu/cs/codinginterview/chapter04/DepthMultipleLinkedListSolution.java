package edu.nyu.cs.codinginterview.chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.nyu.cs.codinginterview.util.Queue;

/**
 * @author shenli
 * <p>
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth 
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class DepthMultipleLinkedListSolution {
    
    private DepthMultipleLinkedListSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static <T extends Comparable<? super T>> List<List<TreeNode<T>>> treeDepthR(
            TreeNode<T> root) {
        List<List<TreeNode<T>>> mulList = new ArrayList<List<TreeNode<T>>>();
        treeDepthRecursive(mulList, root, 0);
        return Collections.unmodifiableList(mulList);
    }
    
    private static <T extends Comparable<? super T>> void treeDepthRecursive(
            List<List<TreeNode<T>>> mulList, TreeNode<T> node, int height) {
        if (node == null) {
            return;
        }
        if (mulList.size() <= height) {
            mulList.add(new ArrayList<TreeNode<T>>());
        }
        mulList.get(height).add(node);
        treeDepthRecursive(mulList, node.getLeft(), height + 1);
        treeDepthRecursive(mulList, node.getRight(), height + 1);
    }
    
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static <T extends Comparable<? super T>> List<List<TreeNode<T>>> treeDepthI(
            TreeNode<T> root) {
        List<List<TreeNode<T>>> mulList = new ArrayList<List<TreeNode<T>>>();
        Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
        TreeNode<T> curr = root;
        if (curr == null) {
            return Collections.unmodifiableList(mulList);
        }
        
        List<TreeNode<T>> subList = null;
        queue.enQueue(curr);
        while (!queue.isEmpty()) {
            subList = new ArrayList<TreeNode<T>>();
            while (!queue.isEmpty()) {
                subList.add(queue.deQueue());
            }
            for (TreeNode<T> node : subList) {
                if (node.getLeft() != null) {
                    queue.enQueue(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.enQueue(node.getRight());
                }
            }
            mulList.add(subList);
        }
        return Collections.unmodifiableList(mulList);
    }

}
