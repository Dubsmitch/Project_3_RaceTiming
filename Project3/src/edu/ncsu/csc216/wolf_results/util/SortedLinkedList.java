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
public class SortedLinkedList <E extends Comparable <E>> {

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
		
		public Node(E e) {
			this.value = e;
			next = null;
			
		}
	}
}
