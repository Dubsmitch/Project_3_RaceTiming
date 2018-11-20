package edu.ncsu.csc216.wolf_results.util;

public class ArrayList implements List  {
	/** serialization UID is long **/
	private static final long serialVersionUID = 1L;
	/** resize the array **/
	private static final int RESIZE = 1;
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
    public boolean contains(Object o) {
    	//errr not sure what in the world to do with this
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
    		return false;
    	}
    	//I will still need to check to see if the object is a duplicate
    	//if(object is a duplicate) {
    	
    		//do not add 
    	//}
    	
    	//check to see if the current list is full    	
    	if (this.size == this.list.length) {
    		// if so create a new list that is one larger
    		int sizeOfArray = list.length;
    		Object[] holderList = new Object[sizeOfArray + RESIZE];
    		// add old elements into the new list
    		for (int i = 0; i < list.length; i++) {
    			Object element = list[i];
    			holderList[i] = element;
    		}
    	// set the list to the new list
    	this.list = holderList;
    	}
    	
    	list[size] = o;
    	size = size + 1;
    	//will need to change this to true
    	return false;
    }
    
    
}
