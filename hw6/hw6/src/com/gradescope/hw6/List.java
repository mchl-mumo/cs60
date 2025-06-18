package com.gradescope.hw6;

import java.util.NoSuchElementException;

/**
 * A singly-linked list in which each element references the next element.
 */
public class List<DataType extends Comparable<DataType>> {

	private ListNode head;
	private int size;

	/**
	 * Constructs an empty list
	 */
	public List() {
		head = null;
		size = 0;
	}

	/**
	 * A node in a list that contains data and references the next node.
	 */
	private class ListNode {

		private DataType data;
		private ListNode next;

		private ListNode(DataType data, ListNode next) {
			this.data = data;
			this.next = next;
		}

		private ListNode(DataType data) {
			this(data, null);
		}
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int length() {
		return size;
	}

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this collection contains no elements
	 */
	public boolean isEmpty() {
		return length() == 0;
	}

	/**
	 * Returns a string representation of this list.
	 * 
	 * The string representation consists of the list's elements in order, separated
	 * by a space. Elements are converted to strings by object.toString().
	 * 
	 * @return a string representation of this list
	 */
	public String toString() {
		String result = "( ";
		ListNode node = head;
		while (node != null) {
			result = result + node.data.toString() + " ";
			node = node.next;
		}
		return result + ")";
	}

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * More formally, if o==null, this list returns true if and only if this list
	 * contains at least one null element. Otherwise, this list returns true if and
	 * only if this list contains at least one element e such that o.equals(e).
	 * 
	 * @param o - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(DataType o) {
		if (o == null) {
			for (ListNode node = head; node != null; node = node.next) {
				if (node.data == null) {
					return true;
				}
			}
		} else {
			for (ListNode node = head; node != null; node = node.next) {
				if (o.equals(node.data)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	public DataType get(int index) {
		// check that index is within the bounds of the list
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index to get must be at least 0.");
		}
		if (index >= length()) {
			throw new IndexOutOfBoundsException("Index to get is too large.");
		}

		// iterate through the list and find the right node
		int currentIndex = 0;
		ListNode currentNode = head;
		while (currentIndex != index) {
			currentIndex++;
			currentNode = currentNode.next;
		}

		return currentNode.data;
	}

	/**
	 * Compares the specified object with this list for equality.
	 * 
	 * Returns true if and only if the specified object is also a list, both lists
	 * have the same size, and all corresponding pairs of elements in the two lists
	 * are equal. In other words, two lists are defined to be equal if they contain
	 * the same elements in the same order.
	 * 
	 * @param obj - the object to be compared for equality with this list
	 * @return true if the specified object is equal to this list
	 */
	public boolean equals(Object obj) {
		// @CS60: You do not need to understand the code in this method,
		// but feel free to take a look and ask questions about it,
		// if you are interested!

		// if obj is not of type List, they are not equal
		if (!(obj instanceof List)) {
			return false;
		}

		// cast the object to a List and use the overloaded version of equals
		@SuppressWarnings("unchecked")
		List<DataType> other = (List<DataType>) obj;
		// if the two lists are different sizes, they are not equal
		if (size != other.size) {
			return false;
		}

		// compare element by element
		ListNode node1 = head;
		ListNode node2 = other.head;
		for (int i = 0; i < size; i++) {
			// get the two strings, so we can compare them
			DataType s1 = node1.data;
			DataType s2 = node2.data;
			if (!s1.equals(s2)) {
				return false;
			}
			node1 = node1.next; // walk down this list
			node2 = node2.next; // walk down other list
		}
		return true;
	}

	/**
	 * Inserts the specified element at the beginning of this list.
	 * 
	 * Note that the list is modified. Nothing is returned. It is different than the
	 * constructor, which does create a new list.
	 * 
	 * @param e - the element to add
	 */
	public void addFirst(DataType e) {
		if (head == null) {
			this.head = new ListNode(e);
		}
		else {
			this.head = new ListNode(e, this.head);
		}
		this.size++;
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public DataType removeFirst() {
		if (this.head == null) {
			throw new NoSuchElementException("The list is empty.");
		}
		ListNode first = this.head;
		this.head = this.head.next;
		this.size--;
		return first.data;
	}

	/**
	 * Removes the first element from this list and adds it at the beginning of the
	 * other list.
	 * 
	 * @param other - the list to which to move the element
	 * @throws NoSuchElementException if this list is empty
	 */
	public void moveFirstElementTo(List<DataType> other) {
		if (this.head == null) {
			throw new NoSuchElementException("This list is empty.");
		}
		ListNode movingElement = this.head;
		this.head = this.head.next;
		this.size--;
		movingElement.next = other.head;
		other.head = movingElement;
		other.size++;
	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * Note that the list is modified. Nothing is returned. It is different than the
	 * constructor, which does create a new list.
	 * 
	 * @param e - element to be appended to this list
	 */
	public void add(DataType e) {
		if (this.head == null) {
			this.head = new ListNode(e);
		}
		else {
			ListNode node = this.head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new ListNode(e);
		}
		this.size++;
	}

	/**
	 * Constructs a list containing containing the elements of the string array, in
	 * the same order.
	 * 
	 * This static method can be thought of as another constructor.
	 * 
	 * @param stringArray - the array whose elements are to be placed into this list
	 */
	public static List<String> makeFromStringArray(String[] stringArray) {
		List<String> stringList = new List<String>();
		for (int i=stringArray.length -1; i>=0; i--) {
			stringList.addFirst(stringArray[i]);
		}
		return stringList;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element). Elements are converted to strings by
	 * object.toString().
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence
	 */
	public String[] toStringArray() {
		String[] stringArray = new String[this.size];
		ListNode node = this.head;
		int index = 0;
		while (node != null) {
			stringArray[index] = node.data.toString();
			node = node.next;
			index++;
		}
		return stringArray;
	}

	/**
	 * Appends all of the elements in the other list to the end of this list, in the
	 * order that they are stored by the other list.
	 * 
	 * This operation is in-place. Note that the other list should not be modified
	 * while the operation is in progress. (This will occur if the specified
	 * collection is this list, and it is nonempty.)
	 * 
	 * @param other - list containing elements to be added to this list
	 */
	public void append(List<DataType> other) {
		if (this.head == null) {
			this.head = other.head;
		} else {
			ListNode node = this.head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = other.head;
		}
		this.size = this.size + other.size;
	}

	/**
	 * Reverses the elements of this list.
	 * 
	 * This operation is in-place.
	 */
	public void reverse() {
		if (this.head != null) {

		ListNode prevNode = null;
		ListNode curNode = this.head;
		ListNode nxtNode = curNode.next;

		while(nxtNode != null) {
			prevNode = curNode;
			curNode = nxtNode;
			nxtNode = curNode.next;

			curNode.next = prevNode;
			if (nxtNode == null) {
				this.head = curNode;
			}
		}
		}

	}
	                  
	/**
	 * Splits this list in two.
	 * 
	 * Afterwards, this list contains only elements from the first half, and the
	 * returned list contains only elements from the second half.
	 * 
	 * If this list has an odd number of elements, afterwards, it should contain one
	 * more element than the list that is returned. If this list has one element, it
	 * is unmodified, and an empty list is returned.
	 * 
	 * @return a new list that contains the second half of the elements in the
	 *         original list
	 */
	public List<DataType> split() {
		List<DataType> newList = new List<DataType>();
		int half = this.size/2;
		if (this.size % 2 == 1) {
			half = half + 1;  //move halfway mark by one for odd sizes
		}
		if (this.size == 1) {
			return newList;
		} else {
			ListNode node = this.head;
			int index = 1;
			while (index < half) {
				node = node.next;
				index++;
			}
			newList.head = node.next;
			node.next = null;
			newList.size = this.size - half;
			this.size = half;
			return newList;
		}
	}

	/**
	 * Merges this list with the other list.
	 * 
	 * Both this list and other list should already be in sorted order.
	 * 
	 * This method will modify this list and the other list. When completed, other
	 * should be empty and this list should contain all elements in sorted order.
	 * 
	 * @param other - the list to be merged with this list
	 */
	public void merge(List<DataType> other) {
		ListNode prev = null;
		ListNode movedNode = null;       // intermediate to help transfer pointers
		ListNode thisNode = this.head;
		ListNode otherNode = other.head;

		while (otherNode != null) {
			if (thisNode == null) {  //case when this at end, other not at end
				thisNode = otherNode;
				prev.next = otherNode;
				otherNode = otherNode.next;
				other.head = otherNode;
				this.size++;
				other.size--;
			} else if (thisNode.data.compareTo(otherNode.data) >= 0) {
				movedNode = otherNode;
				otherNode = otherNode.next;
				other.head = otherNode;
				movedNode.next = thisNode;
				if (prev != null) {
					prev.next = movedNode;
					prev = movedNode;
				} else {
					this.head = movedNode;
				}
				other.size--;
				this.size++;
			} else { // this node is smaller than other node
				prev = thisNode;
				thisNode = thisNode.next;
			}		
		}
	}

	/**
	 * Sorts this list using merge sort.
	 */
	public void mergeSort() {
		if (this.size <= 1) {  
			return; //base case for our recursion
		}
		List<DataType> secondHalf = this.split(); 
		this.mergeSort();
		secondHalf.mergeSort();
		this.merge(secondHalf);
	}

	public static void main(String[] args) {
		System.out.println("You can add code here to test your List implementation!");
		System.out.println("Also, look at the assignment for debugging tips.");

		// For example, you might start like this:
		// List<Dog> myList = new List<Dog>();
		// System.out.println(myList.head.data);
	}
}
