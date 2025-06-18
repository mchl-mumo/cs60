package com.gradescope.hw9;
import java.util.EmptyStackException;



/**
 * A stack that uses a singly-linked list to implement last-in-first-out.
 * 
 */
public class Stack <E extends Comparable<E>>{
    private List<E> stackData;
    
    /**
     * Constructs an empty stack
     */
    public Stack() {
        stackData =  new List<E>();
    }

    /**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in this stack
	 */
    public int getSize() {
        return stackData.length();
    }

    /**
	 * Returns true if this stack contains no elements.
	 * 
	 * @return true if this stack contains no elements
	 */
    public boolean isEmpty() {
        return stackData.isEmpty();
    }

    /**
	 * Returns the top element of the stack.
	 * 
	 * @return top element of the stack without removing it permanently.
	 */
    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackData.get(0);
    }

    /**
	 * Returns the top element of the stack.
	 * 
	 * @return top element of the stack by removing it permanently.
	 */
    public E pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackData.removeFirst();
    }

    /**
	 * Accepts an element and adds it to the top of the stack.
	 * 
	 * @param - e, Element to to be added to the top of the stack.
	 */
    public void push(E e) {
        stackData.addFirst(e);
    }

    /**
	 * Makes a stack empty.
	 */
    public void clear() {
        stackData = new List<E>();
    }

    /**
	 * Compares 2 stacks and determines whether they are equal.
	 * 
     * @param - s, other stack
	 * @return boolean true if this stack and other stack are equal.
	 */
    public boolean equals(Stack<E> s) {
        return stackData.equals(s.stackData);
    }
        
    /**
	 * Returns a string representation of the stack.
	 * 
	 * @return - string representation of the stack with top most element to the left.
	 */
    public String toString() {
        return stackData.toString();
    }
}
