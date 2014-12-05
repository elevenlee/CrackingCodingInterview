package edu.nyu.cs.codinginterview.chapter04;

/**
 * @author shenli
 * <p>
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search 
 * tree. You may assume that each node has a link to its parent.
 */
public class SuccessorSolution {
    
    private SuccessorSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n)
     * space complexity O(1)
     */
    public static <T extends Comparable<? super T>> TreeNode<T> successor(
            TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return minimum(node.getRight());
        } else {
            TreeNode<T> parent = node.getParent();
            while (parent != null && parent.getRight() == node) {
                node = parent;
                parent = parent.getParent();
            }
            return parent;
        }
    }
    
    private static <T extends Comparable<? super T>> TreeNode<T> minimum(
            TreeNode<T> node) {
        assert node != null;
        
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

}
