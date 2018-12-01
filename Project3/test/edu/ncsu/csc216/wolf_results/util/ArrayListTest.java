package edu.ncsu.csc216.wolf_results.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {
	/**
	 * tests the constructor with and without
	 * parameters
	 */
	@Test
	public void testConstructor() {
		ArrayList al = new ArrayList();
		assertEquals(al.size(), 0);
	
		ArrayList bl = new ArrayList(5);
		assertEquals(bl.size(), 0);
	}
	
	/**
	 * tests adding to the back of the 
	 * arraylist
	 */
	@Test
	public void testAddToBack() {
		ArrayList al = new ArrayList();
		assertEquals(al.size(), 0);
		
		String a = "a";
		String b = "b";
		
		assertTrue(al.add(a));
		assertEquals(al.size(), 1);
		
		assertTrue(al.add(b));
		assertEquals(al.size(), 2);
		
	}
	
	/**
	 * tests adding to any index
	 */
	@Test
	public void testAddToAnywhere() {
		ArrayList al = new ArrayList();
		assertEquals(al.size(), 0);
		
		String a = "a";
		String b = "b";
		String c = "c";
		
		al.add(0, a);
		assertEquals(al.size(), 1);
		
		al.add(1, b);
		assertEquals(al.size(), 2);
		
		al.add(1, c);
		assertEquals(al.size(), 3);
		
		assertEquals(al.get(0), a);
		assertEquals(al.get(1), c);
		assertEquals(al.get(2), b);
		
		String e = "e";
		al.add(0, e);
		
	}
	/**
	 * tests removing from the array list
	 */
	@Test
	public void testRemove() {
		ArrayList al = new ArrayList();
		assertEquals(al.size(), 0);
		
		String a = "a";
		String b = "b";
		String c = "c";
		
		al.add(0, a);
		assertEquals(al.size(), 1);
		
		al.add(1, b);
		assertEquals(al.size(), 2);
		
		al.add(1, c);
		assertEquals(al.size(), 3);
		
		//remove from middle
		assertEquals(al.remove(1), c);
		//check
		assertEquals(al.get(0), a);
		assertEquals(al.get(1), b);
		//remove from back
		assertEquals(al.remove(1), b);
		//remove from front
		assertEquals(al.remove(0), a);
		
		try {
			al.remove(10);
			fail("shouldn't be able to remove index out of bounds");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
	}
	/**
	 * tests finding a particular object's index
	 */
	@Test
	public void testInstance() {
		ArrayList al = new ArrayList();
		assertEquals(al.size(), 0);
		
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		
		al.add(0, a);
		assertEquals(al.size(), 1);
		
		al.add(1, b);
		assertEquals(al.size(), 2);
		
		al.add(1, c);
		assertEquals(al.size(), 3);
		
		assertEquals(al.indexOf(c), 1);
		
		assertEquals(al.indexOf(b), 2);
		
		assertEquals(al.indexOf(a), 0);
		
		assertEquals(al.indexOf(d), -1);
	}
}
