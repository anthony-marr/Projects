// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Anthony Marraccini, amarraccini216

package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;


/**
 * 
 * @author Anthony Marraccini, amarraccini216
 * @version 10/4/2022
 *
 * @param <T>
 *             The class that you want to store
 */
public class LinkedStack<T> implements StackInterface<T> {
    private int size;
    private Node<T> topNode;
    
    /**
     * initializes fields
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }
    
    /**
     * gets the size of the linked stack
     * @return the number of elements
     */
    public int size() {
        return size;
    }
    
    /**
     * returns boolean based of if the stack is empty
     * @return true if successful
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * clears the stack
     */
    public void clear() {
        this.topNode = null;
        this.size = 0;
    }
    
    /**
     * converts stack to a string sequence
     * @return the stack in a string sequence
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> p = topNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }
    
    /**
     * adds a new Entry to the stack
     * @param anEntry
     *               specified value to be pushed into stack
     */
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        newNode.setNextNode(topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * shows the entry that is on the top of the stack
     * @return the topnode's data
     */
    public T peek() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }
    
    /**
     * finds the entry on the top of the stack and pops it
     * @return the top node in the stack
     */
    public T pop() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        else {
            T popped = topNode.getData();
            topNode = topNode.getNextNode();
            size--;
            return popped;
        }
    }
    
    /**
     * 
     * @author Anthony Marraccini, amarraccini216
     * @version 10/16/2022
     *
     * @param <T>
     *          The class you want to store
     */
    private class Node<T> {
        private T data;
        private Node<T> next;
        
        /**
         * sets up the private node class
         * @param entry
         *              object to be added to stack
         * @param node
         *              node to be added to stack
         */
        public Node(T entry, Node<T> node) {
            this(entry);
            this.setNextNode(node);
        }
        
        /**
         * sets the next node to the specified value
         * @param node
         *              node to be set as next
         */
        public void setNextNode(Node<T> node) {
            this.next = node;
        }
        
        /**
         * sets up node class to get data of nodes
         * @param data
         *              data to add to node
         */
        public Node(T data) {
            this.data = data;
        }
        
        /**
         * gets the next node from the one its called on
         * @return the next node
         */
        public Node<T> getNextNode() {
            return this.next;
        }
        
        /**
         * gets the data from the specified node
         * @return the data from node
         */
        public T getData() {
            return this.data;
        }
    }
}
