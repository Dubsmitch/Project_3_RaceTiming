package edu.ncsu.csc216.wolf_results.util;

public class ArrayList implements List  {
	/** serialization UID is long **/
	private static final long serialVersionUID = 1L;
	/** resize the array **/
	private static final int RESIZE = 2;
	/** the array of objects **/
	private Object[] list;
	/** the size of the list **/
	private int size;
	
	/**
	 * creates an array of capacity 1
	 */
	public ArrayList () {
        Object[] list = new Object[RESIZE];
        this.list = list;
        this.size = 0;
	}
	/**
	 * creates an arraylist of size 0 but with
	 * a given capacity
	 * 
	 * @param cap
	 * 		the capacity of the arrayList
	 */
	public ArrayList (int cap) {
		if (cap == 0) {
			throw new IllegalArgumentException();
		}
		Object[] list = new Object[cap];
		this.list = list;
		this.size = 0;
	}
	
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
    	if (this.size == 0) {
    		return true;
    	}
    	
    	return false;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
	@Override
    public boolean contains(Object o) {
    	//errr not sure what in the world to do with this
		// find each object in the list and then check it against the parameter
		for (int i = 0; i < this.size(); i++) {
			Object element = list[i];
			if (o.equals(element)) {
				return true;
			}
		}
    	return false;
    }

    // Modification Operations
    
    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * Lists that support this operation may place limitations on what elements
     * may be added to this list. In particular, some lists will refuse to add
     * null elements, and others will impose restrictions on the type of
     * elements that may be added. List classes should clearly specify in their
     * documentation any restrictions on what elements may be added.
     *
     * @param o element to be appended to this list
     * @return true (as specified by {@link Collection#add})
     */
    @Override
    public boolean add(Object o) {
    	if (o == null) {
    		throw new NullPointerException();
    	}
    	if(this.contains(o)) {
    		throw new IllegalArgumentException();
    	}
    	//check to see if the array size is equal to length
    	//if so double the size
    	if ((size() + 1) == list.length) {
    		int sizeCurrentArray = list.length;
		
    		Object[] list2 = new Object[sizeCurrentArray * RESIZE];
    		
    		for (int j = 0 ; j < size; j++) {
    			list2[j] = list[j];
    		}
    		
    		this.list = list2;
    	}
    	
    	list[this.size()] = o;
    	size = size + 1;
    	//will need to change this to true
    	return true;
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *             || index >= size())
     */
    @Override
    public Object get(int index) {
    	if (index < 0 || index > size()) {
    		throw new IndexOutOfBoundsException();
    	}
    	Object e = list[index];
    	return e;
    }
    
    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation). Shifts the element currently at that position (if
     * any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws NullPointerException if the specified element is null and this
     *             list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *             element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *             || index > size())
     */
    @Override
    public void add(int index, Object element) {
    	if (index < 0 || index > size()) {
    		throw new IndexOutOfBoundsException("index is out of range");
    	}
    	if (this.contains(element)) {
    		throw new IllegalArgumentException("cannot add duplicate element");
    	}
    	if (element == null) {
    		throw new NullPointerException("Cannot add a null element");
    	}
    	
    	//check size
    	if (size + 1 == list.length) {
    		int sizeCurrentArray = list.length;
		
    		Object[] list2 = new Object[sizeCurrentArray * RESIZE];
    		
    		for (int j = 0 ; j < size; j++) {
    			list2[j] = list[j];
    		}
    		
    		this.list = list2;
    	}
    	
    	//size is the number of items the list currently holds
    	//length is the capacity (initialized to 10)
    	//if the element is not added at the beginning or the end (end would be size-1 = index)
    	if (index != 0 && index != (size)) {
    		//create a second list to hold the original list (with the same length)
    		Object[] list2 = new Object[list.length];
    		
    		//go through all the elements and add them to the second list
    		//until the index to add is reached.
    		for (int j = 0; j < index; j++) {
    			list2[j] = list[j];
    		}
    		//then add object to the index to add
    		list2[index] = element;
    		
    		//add one to size because the array will have to be
    		//one larger to accomedate the new addition
        	size = size + 1;
        	
    		//then add the rest of the items, adding one to the index for the
        	//location in the new list
    		for (int k = index; k < size; k++) {
    			list2[k + 1] = list[k];
    		}
    		//then add all elements back to original list
    		for (int j = 0; j < size; j++) {
    			list[j] = list2[j];
    		}
    		
    	// if tried to add to the beginning
    	} else if (index == 0 && index != (size)) {
    		//create a second list to hold the original list (with the same length)
    		Object[] list2 = new Object[list.length];
    		
    		//add element to the beginning of the empty list
    		list2[index] = element;
    		
    		//add one to size because the array will have to be
    		//one larger to accomedate the new addition
    		size = size + 1;
    		
    		//add all of the orginal list's elements to the new list
    		//in order +1 of original index
    		for (int j = 1; j < size; j++) {
    			list2[j] = list[j-1];
    		}
    		
    		//then add all elements back to original list
    		for (int j = 0; j < size; j++) {
    			list[j] = list2[j];
    		}
    		
    		// if size is equal to length
    	} else {
    		
    		//create a second list to hold the original list (with the same length)
    		Object[] list2 = new Object[list.length];

    		if (index != 0) {
    			//go through all the elements and add them to the second list
        		//until the index to add is reached.
        		for (int j = 0; j < size; j++) {
        			list2[j] = list[j];
        		}
        		//then add object to the index to add
        		list2[index] = element;
        		
        		//add one to size because the array will have to be
        		//one larger to acommadate the new addition
            	size = size + 1;
        		
        		//then add all elements back to original list
        		for (int j = 0; j < size; j++) {
        			list[j] = list2[j];
        		}
        		
    		} else {
    			//add element to the beginning of the empty list
        		list2[index] = element;
        		
        		//add one to size because the array will have to be
        		//one larger to accomedate the new addition
        		size = size + 1;
        		
        		//add all of the orginal list's elements to the new list
        		//in order +1 of original index
        		for (int j = 1; j < size; j++) {
        			list2[j] = list[j-1];
        		}
        		
        		//then add all elements back to original list
        		for (int j = 0; j < size; j++) {
        			list[j] = list2[j];
        		}
    		}
    	}
    	
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation). Shifts any subsequent elements to the left (subtracts one
     * from their indices). Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *             || index >= size())
     */
    @Override
    public Object remove(int index) {
    	if (index < 0 || index >= size()) {
    		throw new IndexOutOfBoundsException ("index is out of range");
    	}
    	
    	//if the index is not zero and less than the size
    	if (index != 0 && index != size) {
    		
			Object ee = new Object();
    		ee = list[index];
    		
    		//create new list to hold
    		Object[] list2 = new Object[list.length];
		
    		//before the index of removal the list is the same
    		for (int i = 0; i < index; i++) {
    			list2[i] = list[i];
    		}
		
    		//not sure if size should be one smaller or not here..
    		for (int i = index; i < size; i++) {
    			list2[i] = list[i + 1];
    		}
		
    		//	now switch again
    		for (int i = 0; i < size; i++) {
    			list[i]=list2[i];
    		}
    		list[size - 1] = null;
    		
    		size = size - 1;
    		
    		return ee;
    		
    	//	if the index is zero
    	} else {
        	//create new list to hold
    		Object[] list2 = new Object[list.length];
    			
			Object ee = new Object();
    		ee = list[index];
    		
    	//	before the index of removal the list is the same
   			for (int i = 0; i < size; i++) {
   				list2[i] = list[i + 1];
   			}
   			
   		//	now switch again
    		for (int i = 0; i < size; i++) {
    			list[i]=list2[i];
    		}
   			list[size - 1] = null;
   			
   			size = size - 1;
    			
    		return ee;
    	}
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
    	for (int i = 0; i < size(); i++) {
    		if (list[i].equals(o)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
}
