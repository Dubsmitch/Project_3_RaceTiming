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
	/** contains the size of the linked list **/
	private int size;
	//this seems rather sparse. no
	//size or capacity? humm.
	public SortedLinkedList (){
		head = null;
		this.size = 0;
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
		if (this.size > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		
		return this.size;
	}
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
    	if(this.size() == 0) {
    		return true;
    	}
    	
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
    	if (size == 0) {
    		return false;
    	}
    	Node leading = head;
    	//test first item in a list with one item
    	
    	//so at the second to last item head.next will be a thing
    	//then head.next will be null
    	while (leading.next != null) {
    		if(leading.value.equals(e)) {
    			return true;
    		}
    		leading = leading.next;
    	}
    	if(leading.value.equals(e)) {
			return true;
		}
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
    	Node leading = head;
    	Node trailing = null;
    	if (e == null) {
    		throw new NullPointerException("element cannot be null");
    	}
    	if (this.contains(e)) {
    		throw new IllegalArgumentException("duplicate elements are not allowed");
    	}
    	int index = 0;
    	if(size == 0) {
    		Node newNode = new Node(e);
    		leading = newNode;
    		head = leading;
    		size = size + 1;
    		return true;
    	}
    	
    	while (e.compareTo(leading.value) > 0 && leading.next != null) {
    		trailing = leading;
    		leading = leading.next;
    		index++;
    	}
    	
    	if (index == 0) {
    		Node newNode = new Node(e, leading);
    		head = newNode;
    	}
    	
    	if (index != 0 && leading.next != null) {
    		Node newNode = new Node (e, leading);
    		trailing.next = newNode;
    		
    	} 
    	
    	if (leading.next == null && index != 0 && e.compareTo(leading.value) > 0) {
    		Node newNode = new Node(e);
    		trailing = leading;
    		leading = newNode;
    		
    		trailing.next = newNode;
    	} 
    	
    	if (leading.next == null && index != 0 && e.compareTo(leading.value) <= 0) {
    		Node newNode = new Node(e, leading);
    		trailing.next = newNode;
    	}

    	
    	size = size + 1;
    	return true;
    	
    }
    //private int compareTo(E e) {
    	//this.value
    //}
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
    	Node leading = head;
    	int idx = 0;
    	if (index < 0 || index >= size()) {
    		throw new IndexOutOfBoundsException ();
    	}
    	while (idx < index) {
    		leading = leading.next;
    		idx++;
    	}
    	return leading.value;
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
    	if (index < 0 || index >= size()) {
    		throw new IndexOutOfBoundsException ();
    	}
    	Node leading = head;
    	Node trailing = null;
    	int travel = 0;
    	while (travel < index) {
    		trailing = leading;
    		leading = trailing.next;
    		travel++;
    	}
    	if (travel == 0) {
    		Node returnThis = leading;
    		trailing = leading;
    		leading = leading.next;
    		head = leading;
    		size = size - 1;
    		return returnThis.value;
    	} else if ( travel != 0 && leading.next != null) {
    		Node returnThis = leading;
    		leading = leading.next;
    		trailing.next = leading;
    		size = size - 1;
    		return returnThis.value;
    	} else {
    		Node returnThis = leading;

    		trailing.next = null;
    		size = size - 1;
    		return returnThis.value;
    	}
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

    	Node leading = head;
    	//Node trailing = null;
    	int index = 0;
    	
    	while (leading.value != e && leading.next != null) {
    		//trailing = leading;
    		leading = leading.next;
    		index ++;
    	}
    	if (leading.value == e) {
    		return index;
    	} 
    	if (leading.value != e && leading.next == null) {
    		return -1;
    	}
    	
    	return -1;
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
		@SuppressWarnings("unchecked")
		public Node(Object e) {
			this.value = (E) e;
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
		@SuppressWarnings("unchecked")
		public Node(Object e, Node next) {
			this.value = (E) e;
			this.next = next;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		@SuppressWarnings("rawtypes")
		private SortedLinkedList getOuterType() {
			return SortedLinkedList.this;
		}
		
	}
}
