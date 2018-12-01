package edu.ncsu.csc216.wolf_results.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedLinkedListTest {

	@Test
	public void testConstructor() {
		SortedLinkedList<String> SL = new SortedLinkedList<String>();
		
		assertEquals(SL.size(), 0);
		assertTrue(SL.isEmpty());
	}
	
	@Test
	public void testAdd() {
		SortedLinkedList<Integer> intL = new SortedLinkedList<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		
		SortedLinkedList<String> stringL = new SortedLinkedList<String>();
		String aa = "a";
		String bb = "b";
		String cc = "c";
		String dd = "d";
		assertEquals(intL.size(), 0);
		assertTrue(intL.isEmpty());
		//add to an emptyList
		assertTrue(intL.add(b));
		assertEquals(intL.size(), 1);
		assertEquals((Integer) intL.get(0), (Integer) b);
		
		assertTrue(intL.add(a));
		assertEquals(intL.size(), 2);
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);

		assertTrue(intL.add(d));
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);
		assertEquals(intL.size(), 3);
		assertEquals((Integer) intL.get(2), (Integer) d);

		assertTrue(intL.add(c));
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);
		assertEquals(intL.size(), 4);
		assertEquals((Integer) intL.get(2), (Integer) c);
		assertEquals((Integer) intL.get(3), (Integer) d);

		
		assertEquals(stringL.size(), 0);
		assertTrue(stringL.isEmpty());
		//add to an emptyList
		assertTrue(stringL.add(bb));
		assertEquals(stringL.size(), 1);
		assertEquals(stringL.get(0), bb);
		
		assertTrue(stringL.add(aa));
		assertEquals(stringL.size(), 2);
		assertEquals(stringL.get(0), aa);
		assertEquals(stringL.get(1), bb);

		assertTrue(stringL.add(dd));
		assertEquals(stringL.get(0), aa);
		assertEquals(stringL.get(1), bb);
		assertEquals(stringL.size(), 3);
		assertEquals(stringL.get(2), dd);

		assertTrue(stringL.add(cc));
		assertEquals(stringL.get(0), aa);
		assertEquals(stringL.get(1), bb);
		assertEquals(stringL.size(), 4);
		assertEquals(stringL.get(2), cc);
		assertEquals(stringL.get(3), dd);

	}
	
	@Test
	public void testRemove() {
		SortedLinkedList<Integer> intL = new SortedLinkedList<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		
		assertEquals(intL.size(), 0);
		assertTrue(intL.isEmpty());
		//add to an emptyList
		assertTrue(intL.add(b));
		assertEquals(intL.size(), 1);
		assertEquals((Integer) intL.get(0), (Integer) b);
		
		assertTrue(intL.add(a));
		assertEquals(intL.size(), 2);
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);

		assertTrue(intL.add(d));
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);
		assertEquals(intL.size(), 3);
		assertEquals((Integer) intL.get(2), (Integer) d);

		assertTrue(intL.add(c));
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);
		assertEquals(intL.size(), 4);
		assertEquals((Integer) intL.get(2), (Integer) c);
		assertEquals((Integer) intL.get(3), (Integer) d);
		
		//remove from end
		assertEquals((Integer) intL.remove(3), (Integer) d);
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);
		assertEquals(intL.size(), 3);
		assertEquals((Integer) intL.get(2), (Integer) c);
		
		//remove from middle
		assertEquals((Integer) intL.remove(1), (Integer) b);
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals(intL.size(), 2);
		assertEquals((Integer) intL.get(1), (Integer) c);
		
		//remove from front
		assertEquals((Integer) intL.remove(0), (Integer) a);
		assertEquals(intL.size(), 1);
		assertEquals((Integer) intL.get(0), (Integer) c);
		
		//remove from list of 1
		assertEquals((Integer) intL.remove(0), (Integer) c);
		assertEquals(intL.size(), 0);
		
		
	}
	
	@Test
	public void testIndexOf() {
		SortedLinkedList<Integer> intL = new SortedLinkedList<Integer>();
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;

		assertEquals(intL.size(), 0);
		assertTrue(intL.isEmpty());
		//add to an emptyList
		assertTrue(intL.add(b));
		assertEquals(intL.size(), 1);
		assertEquals((Integer) intL.get(0), (Integer) b);
		
		assertTrue(intL.add(a));
		assertEquals(intL.size(), 2);
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);

		assertTrue(intL.add(d));
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);
		assertEquals(intL.size(), 3);
		assertEquals((Integer) intL.get(2), (Integer) d);

		assertTrue(intL.add(c));
		assertEquals((Integer) intL.get(0), (Integer) a);
		assertEquals((Integer) intL.get(1), (Integer) b);
		assertEquals(intL.size(), 4);
		assertEquals((Integer) intL.get(2), (Integer) c);
		assertEquals((Integer) intL.get(3), (Integer) d);
		
		assertEquals(intL.indexOf(a), 0);
		assertEquals(intL.indexOf(b), 1);
		assertEquals(intL.indexOf(c), 2);
		assertEquals(intL.indexOf(d), 3);
	}
	
	/**
	 * test inner class
	 */
	@Test
	public void testNode() {
		SortedLinkedList<String> list = new SortedLinkedList<String>();
		String a = "a";
		
		list.add(a);
		assertEquals(list.get(0), a);
		String aToString = "[a]";
		
		assertEquals(list.toString(), aToString);
		 
		String b = "b";
		String c = "c";
		String ab = "[b],[a]";
		list.add(b);
		assertEquals(list.toString(), ab);
		
		SortedLinkedList<String> list2 = new SortedLinkedList<String>();
		list2.add(a);
		list2.add(b);
		
		
		
		assertEquals(list.hashCode(), list2.hashCode());
		assertTrue(list.equals(list2));
		list2.add(c);
	
		assertTrue(!list.equals(list2));
		assertTrue(list.hashCode() != list2.hashCode());
		
	}

}
