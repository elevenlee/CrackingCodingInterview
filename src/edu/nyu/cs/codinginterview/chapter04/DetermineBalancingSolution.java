package edu.nyu.cs.codinginterview.chapter04;

/**
 * @author shenli
 * <p>
 * Implement a function to check if a binary tree is balanced. For the purpose of this question, a balanced 
 * tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more 
 * than one.
 */
public class DetermineBalancingSolution {

    private DetermineBalancingSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(logn)
     */
    public static <T extends Comparable<? super T>> boolean isBalanced1(TreeNode<T> node) {
        if (node == null) {
            return true;
        }
        int heightDiff = getHeight(node.getLeft()) - getHeight(node.getRight());
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        return isBalanced1(node.getLeft()) && isBalanced1(node.getRight());
    }
    
    private static <T extends Comparable<? super T>> int getHeight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }
    
    /**
     * time complexity O(n)
     * space complexity O(logn)
     */
    public static <T extends Comparable<? super T>> boolean isBalanced(TreeNode<T> root) {
        return !(checkHeight(root) == -1);
    }
    
    private static <T extends Comparable<? super T>> int checkHeight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkHeight(node.getLeft());
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(node.getRight());
        if (rightHeight == -1) {
            return -1;
        }
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
}
