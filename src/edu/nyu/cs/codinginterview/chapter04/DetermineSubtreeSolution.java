package edu.nyu.cs.codinginterview.chapter04;

/**
 * @author shenli
 * <p>
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create 
 * an algorithm to decide if T2 is a subtree of T1.
 */
public class DetermineSubtreeSolution {
    
    private DetermineSubtreeSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n + km)
     * space complexity O(logn + logm)
     */
    public static <T extends Comparable<? super T>> boolean isSubtree(
            TreeNode<T> root1, TreeNode<T> root2) {
        if (root2 == null) {
            return true;
        }
        return isSubtreeHelper(root1, root2);
    }
    
    private static <T extends Comparable<? super T>> boolean isSubtreeHelper(
            TreeNode<T> node, TreeNode<T> root2) {
        if (node == null) {
            return false;
        }
        if (!matchTree(node, root2)) {
            return false;
        }
        return isSubtreeHelper(node.getLeft(), root2)
                || isSubtreeHelper(node.getRight(), root2);
    }
    
    private static <T extends Comparable<? super T>> boolean matchTree(
            TreeNode<T> node1, TreeNode<T> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (!node1.getKey().equals(node2.getKey())) {
            return false;
        }
        return matchTree(node1.getLeft(), node2.getLeft())
                && matchTree(node1.getRight(), node2.getRight());
    }

}
