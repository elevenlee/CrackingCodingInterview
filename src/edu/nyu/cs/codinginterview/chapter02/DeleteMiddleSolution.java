package edu.nyu.cs.codinginterview.chapter02;

/**
 * @author shenli
 * <p>
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access t that node.
 */
public class DeleteMiddleSolution {
    
    private DeleteMiddleSolution() {
        throw new AssertionError();
    }
    
    private static class Element<E> {
        private E key;
        private Element<E> next;
        
        @SuppressWarnings("unused")
        Element(E key, Element<E> next) {
            assert key != null;
            
            this.key = key;
            this.next = next;
        }
        
    }
    
    /**
     * Cannot solve if the node to be deleted is the last node in linked list. That's ok -- your interviewer 
     * wants you to point that out, and to discuss how to handle this case.
     * <p>
     * time complexity O(1)
     * space complexity O(1)
     */
    public static <T> boolean deleteMiddle(Element<T> middle) {
        if (middle == null || middle.next == null) {
            return false;
        }
        Element<T> next = middle.next;
        middle.key = next.key;
        middle.next = next.next;
        next.next = null;
        return true;
    }
    
}
