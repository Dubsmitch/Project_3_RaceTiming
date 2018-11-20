package edu.ncsu.csc216.wolf_results.util;

/**
 * The sorted linked list will be used to hold and sort and curate
 * race results.
 * 
 * @author William
 *
 * @param <E>
 * 		the generic object to be held by
 * 		the sorted linked list
 */
public class SortedLinkedList <E extends Comparable <E>> implements SortedList <E> {
	/** reference to the first element **/
	private Node head;
	//this seems rather sparse. no
	//size or capacity? humm.
	public SortedLinkedList (){
		head = null;
	}
	// Query Operations

    /**
     * Returns the number of elements in this list. If this list contains more
     * than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this list
     */
	@Override
    public int size() {
		return 0;
	}
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
    	return false;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element a
     * such that (o==null ? a==null : o.equals(a)).
     *
     * @param e element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(E e) {
    	return false;
    }

    // Modification Operations

    /**
     * Adds the specified element to list in sorted order
     *
     * @param e element to be appended to this list
     * @return true (as specified by {@link Collection#add})
     * @throws NullPointerException if e is null
     * @throws IllegalArgumentException if list already contains e
     */
    @Override
    public boolean add(E e) {
    	//head = new Node(e, null);
    	return false;
    }

    // Positional Access Operations

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *             || index >= size())
     */
    @Override
    public E get(int index) {
    	E e = null;
    	return e;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *             || index >= size())
     */
    @Override
    public E remove(int index) {
    	E e = null;
    	return e;
    }

    // Search Operations

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param e element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(E e) {
    	return 0;
    }

	/**
	 * inner class for the sorted linked list that creates the nodes
	 * for use within the linked list
	 * 
	 * @author William
	 *
	 */
	public class Node {
		/** the data within the node **/
		private E value;
		/** reference to the next node (otherwise null) **/
		private Node next;
		/**
		 * creates a null with a null
		 * reference (for the first node in a  list
		 * with only one element, or for the last node
		 * in a list larger than one element)
		 * @param e
		 * 		the element holding data
		 */
		public Node(E e) {
			this.value = e;
			next = null;
			
		}
		
		/**
		 * creates a node with a reference to another node
		 * (the next node in the list)
		 * 
		 * @param e
		 * 		the element holding data
		 * @param next
		 * 		the reference to the next element
		 */
		public Node(E e, Node next) {
			this.value = e;
			this.next = next;
		}
		public boolean equals(Object o) {
			return true;
		}
	}
}
