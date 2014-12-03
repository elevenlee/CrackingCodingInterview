package edu.nyu.cs.codinginterview.chapter03;

import edu.nyu.cs.codinginterview.util.Check;
import edu.nyu.cs.codinginterview.util.Stack;

/**
 * @author shenli
 * <p>
 * Write a program to sort a stack in ascending order. You may use additional stacks to hold items, but you 
 * may not copy the elements into any other data structure.
 */
public class SortStackSolution {
    
    private SortStackSolution() {
        throw new AssertionError();
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(n)
     */
    public static <T extends Comparable<? super T>> void sort1(Stack<T> stack) {
        Check.nullCheck(stack, "stack");
        
        Stack<T> stackItems = new Stack<T>();
        Stack<T> stackAux = new Stack<T>();
        T item = null;
        while (!stack.isEmpty()) {
            item = stack.pop();
            while (!stackItems.isEmpty()
                    && item.compareTo(stackItems.peek()) > 0) {
                stackAux.push(stackItems.pop());
            }
            stackItems.push(item);
            shiftStack(stackAux, stackItems);
        }
        shiftStack(stackItems, stack);
    }
    
    private static <T extends Comparable<? super T>> void shiftStack(
            Stack<T> from, Stack<T> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(n)
     */
    public static <T extends Comparable<? super T>> void sort2(Stack<T> stack) {
        Check.nullCheck(stack, "stack");
        
        Stack<T> stackAux = new Stack<T>();
        T item = null;
        while (!stack.isEmpty()) {
            item = stack.pop();
            while (!stackAux.isEmpty()
                    && item.compareTo(stackAux.peek()) > 0) {
                stack.push(stackAux.pop());
            }
            stackAux.push(item);
        }
        while (!stackAux.isEmpty()) {
            stack.push(stackAux.pop());
        }
    }

}
